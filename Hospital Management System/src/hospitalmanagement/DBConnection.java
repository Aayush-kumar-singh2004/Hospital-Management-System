
//
//package hospitalmanagement;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

//public class DBConnection {
//
//    private static final String URL =
//            "jdbc:oracle:thin:@localhost:1521:XE";
//
//    private static final String USERNAME = System.getenv("DB_USERNAME");
//
//    private static final String PASSWORD = System.getenv("DB_PASSWORD");
//
//    public static Connection getConnection() throws SQLException {
//
//        if (USERNAME == null || PASSWORD == null) {
//            throw new SQLException(
//                    "Database username or password is not configured!"
//            );
//        }
//
//        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//    }
//
//    public static void main(String[] args) {
//
//        try {
//            Connection con = getConnection();
//
//            System.out.println("Database connected successfully!");
//
//            con.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}



package hospitalmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    public static Connection getConnection() throws SQLException {

        Properties properties = new Properties();

        try (FileInputStream file = new FileInputStream(".env")) {
            properties.load(file);
        } catch (IOException e) {
            throw new SQLException("Unable to load .env file!", e);
        }

        String username = properties.getProperty("DB_USERNAME");
        String password = properties.getProperty("DB_PASSWORD");
        
        if (username == null || password == null) {
            throw new SQLException("Database credentials are missing!");
        }
        return DriverManager.getConnection(URL, username, password);
    }
}