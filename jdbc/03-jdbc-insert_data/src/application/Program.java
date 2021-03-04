package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)", // placeholders
                    Statement.RETURN_GENERATED_KEYS); // (overloading) insertion + retrieving created id

            st.setString(1, "Carl Johnson"); // 1st placeholder receives "Carl Johnson"
            st.setString(2, "cj@grovemail.com");
            // NOT java.util.Date():
            st.setDate(3, new java.sql.Date(sdf.parse("03/03/1968").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4); // 5th field, DepartmentId == 4

            // it's possible to add more than one Id at once:
            st = conn.prepareStatement(
                    "insert into department (Name) values ('D1'), ('D2')",
                    Statement.RETURN_GENERATED_KEYS);

            // st.executeUpdate() return an int of how many lines were modified
            int rowsUpdated = st.executeUpdate();

            if (rowsUpdated > 0) {
                // st.getGeneratedKeys() returns ResultSet
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Updated! Id: " + id);
                }
            }
            else {
                System.out.println("No rows updated.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection(); // remember to always close connection last.
        }

    }
}
