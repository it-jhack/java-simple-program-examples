package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                    + "(?, ?, ?, ?, ?)"); // placeholders

            st.setString(1, "Carl Johnson"); // 1st placeholder receives "Carl Johnson"
            st.setString(2, "cj@grovemail.com");
            // NOT java.util.Date():
            st.setDate(3, new java.sql.Date(sdf.parse("03/03/1968").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4); // 5th field, DepartmentId == 4

            // st.executeUpdate() return an int of how many lines were modified
            int rowsUpdated = st.executeUpdate();

            System.out.println(rowsUpdated + " rows updated successfully!");
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
