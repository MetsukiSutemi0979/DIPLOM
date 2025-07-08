package ru.netology.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    public static Connection getConnection() throws SQLException {
        String url = System.getProperty("db.url");
        String user = System.getProperty("db.user");
        String password = System.getProperty("db.password");

        if (url.startsWith("jdbc:postgresql:")) {
            return DriverManager.getConnection(url + "?user=" + user + "&password=" + password);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static String getPaymentStatus() {
        String sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();

        try (Connection conn = getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>());
        } catch (SQLException e) {
            return "ERROR: " + e.getMessage();
        }
    }

    public static String getCreditRequestStatus() {
        String sql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();

        try (Connection conn = getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>());
        } catch (SQLException e) {
            return "ERROR: " + e.getMessage();
        }
    }

    public static void clearData() {
        QueryRunner runner = new QueryRunner();
        try (Connection conn = getConnection()) {
            runner.update(conn, "DELETE FROM payment_entity");
            runner.update(conn, "DELETE FROM credit_request_entity");
            runner.update(conn, "DELETE FROM order_entity");
        } catch (SQLException e) {
            System.err.println("Failed to clear database: " + e.getMessage());
        }
    }
}