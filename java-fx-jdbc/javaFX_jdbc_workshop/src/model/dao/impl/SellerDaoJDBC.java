package model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn; // connection dependency
    // NOTE:
    // DAO object can do more than one operation, so close the connection on the main Program.

    public SellerDaoJDBC(Connection conn) { // forcing connection dependency injection
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS); // returning new inserted seller's id.

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected error! No rows updated!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());
            st.setInt(6, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");

            st.setInt(1, id);

            int rows = st.executeUpdate();
            if (rows == 0) { // means no id affected, so id did not exist
                throw new DbException("invalid id!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // no need to instantiate 'conn' inside methods, because
            // already instantiated as a dependency.
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ?");

            // previous placeholder receives 'id' from parameter
            st.setInt(1, id);
            // executing and storing sql command
            rs = st.executeQuery();
            // ResultSet table from query will be structured as:
            // Id | Name | Email | BirthDate | BaseSalary | DepartmentId | DepName

            // tests if there's any result from previous sql command
            // otherwise 'rs.next() = false' and returns null
            if (rs.next()) {
                // transforming sql table from query into associated objects (Department and Seller)
                Department dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            // Do not close connection in the method, because the same DAO object can do more
            // than one operation. Close the connection on the main Program.
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        // throws SQLException because methods that call instantiateDepartment() already treat it

        // transforming sql table from query into associated objects (Department and Seller)
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        // throws SQLException because methods that call instantiateDepartment() already treat it

        // transforming sql table from query into associated objects (Department and Seller)
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        // Department is the associated object, NOT the id from table:
        obj.setDepartment(dep);
        return obj;
    }

    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE DepartmentId = ? "
                            + "ORDER BY Name");

            st.setInt(1, department.getId());
            rs = st.executeQuery();

            // List<Seller> because there can be more than one result
            List<Seller> list = new ArrayList<>();
            // helping point sellers to the same Department object
            Map<Integer, Department> map = new HashMap<>();

            // 'while' because there can be more than one result
            while (rs.next()) {
                // // WRONG: creating diff Department obj for each seller
                // Department dep = instantiateDepartment(rs);
                // Seller obj = instantiateSeller(rs, dep);
                // list.add(obj);

                // ===============

                // CORRECT: pointing sellers to the same Department obj
                // There are many ways to do it, but with 'map' we'll have
                // better code maintenance options in the future.

                // testing if 'Department dep' already exists
                Department dep = map.get(rs.getInt("DepartmentId"));

                // instantiating, if 'Department dep' does NOT exist
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    // storing instantiated 'dep' into 'map'
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            // Do not close connection in the method, because the same DAO object can do more
            // than one operation. Close the connection on the main Program.
        }
    }

    @Override
    public List<Seller> findAll() {
        // Very similar to findByDepartment(), differences are commented out
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            // + "WHERE DepartmentId = ? " // DIFF findByDepartment()
                            + "ORDER BY Name");

            // st.setInt(1, department.getId()); // DIFF findByDepartment()
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            // 'while' because there can be more than one result
            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}