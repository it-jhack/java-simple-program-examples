package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        // Referential Integrity Error:
        // You cannot delete department 2 (electronics) if there are
        // sellers under that department.

        // Because of that we're creating: 'DbIntegrityException' class

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?");

            st.setInt(1, 5); // deleting 5th element (test department D1)
            // if you try to delete department #2 it will return error, because
            // there are seller under that department.

            int rowsAffected = st.executeUpdate();

            System.out.println("Process finished! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage()); // throwing our own exception.
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
