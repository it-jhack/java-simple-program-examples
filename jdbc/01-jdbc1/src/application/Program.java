package application;

import db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

        Connection conn = DB.getConnection();

        DB.closeConnection();

        System.out.println("Program ended");
    }
}
