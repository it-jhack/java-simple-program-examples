package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB { // static methods to connect/disconnect the database

    private static Connection conn = null;

    // Open connection to DB
    public static Connection getConnection() {
        if (conn == null) { // if null, then try connect
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        String propFilePath = System.getProperty("user.dir") + "\\jdbc\\01-jdbc1\\db.properties";
        try (FileInputStream fs = new FileInputStream(propFilePath)) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) { // catches both IOException and FileNotFoundException
            throw new DbException(e.getMessage());
        }
    }
}
