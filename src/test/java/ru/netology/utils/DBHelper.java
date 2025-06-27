package ru.netology.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static String getPaymentStatus() throws SQLException {
        var sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var runner = new QueryRunner();
        try (var conn = getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>());
        }
    }

    public static String getCreditRequestStatus() throws SQLException {
        var sql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var runner = new QueryRunner();
        try (var conn = getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>());
        }
    }

    public static void clearData() throws SQLException {
        var runner = new QueryRunner();
        try (var conn = getConnection()) {
            runner.update(conn, "DELETE FROM payment_entity");
            runner.update(conn, "DELETE FROM credit_request_entity");
            runner.update(conn, "DELETE FROM order_entity");
        }
    }
}