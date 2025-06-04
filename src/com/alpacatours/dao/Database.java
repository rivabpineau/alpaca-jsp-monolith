package com.alpacatours.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:alpaca;DB_CLOSE_DELAY=-1");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS users(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(255)," +
                "password VARCHAR(255)," +
                "role VARCHAR(255))");
        stmt.execute("CREATE TABLE IF NOT EXISTS tours(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255)," +
                "location VARCHAR(255)," +
                "price DOUBLE," +
                "description VARCHAR(255)," +
                "capacity INT)");
        stmt.execute("CREATE TABLE IF NOT EXISTS bookings(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "userId INT," +
                "tourId INT," +
                "numPeople INT," +
                "bookingDate DATE)");
        stmt.close();
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void reset() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM bookings");
            stmt.executeUpdate("DELETE FROM tours");
            stmt.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
