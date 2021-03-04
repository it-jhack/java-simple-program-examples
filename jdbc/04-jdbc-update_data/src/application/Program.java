package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            // increasing salary for whole department
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");

            st.setDouble(1, 200.0); // 1, == placeholder '?' #1
            st.setInt(2, 2); // 2, == placeholder '?' #2

            int rowsAffected = st.executeUpdate();

            System.out.println("Process finished! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
