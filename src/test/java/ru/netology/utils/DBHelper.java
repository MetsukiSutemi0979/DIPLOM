package ru.netology.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    // Универсальный метод подключения к БД
    public static Connection getConnection() throws SQLException {
        String url = System.getProperty("db.url");
        String user = System.getProperty("db.user");
        String password = System.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }

    // Получение статуса платежа
    public static String getPaymentStatus() {
        String sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();

        try (Connection conn = getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>());
        } catch (SQLException e) {
            return "ERROR: " + e.getMessage();
        }
    }

    // Получение статуса кредитной заявки
    public static String getCreditRequestStatus() {
        String sql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();

        try (Connection conn = getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>());
        } catch (SQLException e) {
            return "ERROR: " + e.getMessage();
        }
    }

    // Очистка данных
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