package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase {

    private final String url = "jdbc:mysql://localhost:3306/esport-db";
    private final String user = "root";
    private final String password = "";

    private Connection connection;
    private static MyDatabase instance;

    private MyDatabase() {
        try {
            // Charger driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database !");
        } catch (Exception e) {
            System.out.println("❌ Database connection failed !");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static MyDatabase getInstance() {
        if (instance == null) {
            instance = new MyDatabase();
        }
        return instance;
    }

    // Vérifier connexion
    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    // Test réel SQL
    public boolean testConnection() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT 1");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}