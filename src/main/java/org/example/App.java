package org.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "Welcome123";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Postgres SQL Successfully");
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database name is : " + metaData.getDatabaseProductName());
            System.out.println("Database version is : " + metaData.getDatabaseProductVersion());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;

    }

    public static void main(String[] args) {
        App app = new App();
        app.connect();

    }
}
