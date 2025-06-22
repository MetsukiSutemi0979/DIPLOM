package ru.netology.utils;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static void execute(String sql, Object... params) throws SQLException {
        try (var conn = getConnection()) {
            new QueryRunner().update(conn, sql, params);
        }
    }

    public static void clearData() throws SQLException {
        execute("DELETE FROM auth_codes;");
        execute("DELETE FROM cards");
        execute("DELETE FROM users;");
    }
}
