package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection(); // connect to the bank

            st = conn.createStatement(); // sql consultation to search for all departments on database
            rs = st.executeQuery("select * from department"); // storing the result of that consultation
            // String is the SQL command
            // ResultSet
            // first() - moves to 1st position (position 1, not 0), if there's one.
            // beforeFirst() - moves to position 0.
            // next() - moves to next, returns false if at the last position.
            // absolute(int) - moves to informed position.

            while (rs.next()) { // while not at the end
                // Strings are the field names on SQL db:
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // Connection, Statement, and ResultSet are external resources,
        // so it's desirable to close them manually to avoid memory leak
        finally {

            // So we don't need to (again) put these .close() in another try statement, we will
            // do some tweaks to the DB class. so instead of rs. st. and conn.close(), we'll use:
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
