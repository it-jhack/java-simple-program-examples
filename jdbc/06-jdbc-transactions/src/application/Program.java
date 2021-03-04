package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        // References: https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.4.0/product-overview/acid.html

        // Transactions - operation that must maintain:
        // ACID: Atomicity, Consistency, Isolation, Durability

        // Bank transaction is a good example:
        // If Alice transfer money to Bob and an error occurs, all
        // the transaction must be cancelled and returned to initial state,
        // that is, either everything goes smoothly or nothing happens.

        // API:
        // setAutoCommit(false):
            // true = each isolated operation will be automatically confirmed
            // false = each isolated operations is NOT auto confirmed.
        // commit() = confirm transaction
        // rollback() = undo


        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false); // !PENDING EXPLICIT CONFIRMATION

            st = conn.createStatement();

            int rows1 = st.executeUpdate(
                    "UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            // SIMULATING AN ERROR:

            int x = 1;
            if (x < 2) {
            	throw new SQLException("Fake error");
            }

            int rows2 = st.executeUpdate(
                    "UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit(); // !THIS CONFIRMS THE TRANSACTION

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);
        }
        catch (SQLException e) {
            try {
                conn.rollback(); // !ROLLING BACK IF AN ERROR HAPPENS
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
