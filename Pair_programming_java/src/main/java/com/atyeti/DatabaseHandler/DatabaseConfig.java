package com.atyeti.DatabaseHandler;

import com.atyeti.fileReader.LogFileAnalyzer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class DatabaseConfig {

    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());

    public static void database() {
        String query = "CREATE TABLE IF NOT EXISTS logs (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "error INT, " +
                "warning INT, " +
                "info INT)";

        Connection myConn = null;
        Statement stmt = null;

        try {
            myConn = DatabaseConnection.getConnection();
            if (myConn == null) {
                logger.severe("Connection is null. Cannot proceed.");
                return;
            }

            stmt = myConn.createStatement();
            stmt.execute(query);
            logger.info("Table created or already exists.");

        } catch (SQLException e) {
            logger.severe("SQL Exception: " + e.getMessage());
        }
    }

    public static void insertLog() {
        String insertQuery = "INSERT INTO logs (error, warning, info) VALUES (?, ?, ?)";

        try (Connection myConn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = myConn.prepareStatement(insertQuery)) {

            pstmt.setInt(1, LogFileAnalyzer.getErrorCount());
            pstmt.setInt(2, LogFileAnalyzer.getWarnCount());
            pstmt.setInt(3, LogFileAnalyzer.getInfoCount());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                logger.info("Log inserted successfully.");
            }

        } catch (SQLException e) {
            logger.severe("Failed to insert log: " + e.getMessage());
        }
    }
}
