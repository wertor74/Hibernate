package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/my_first_db";
    private static final String USERNAME = "wertor";
    private static final String PASSWORD = "kA60022160";
    private static Connection connection;

    public static Connection getConnection () throws SQLException, ClassNotFoundException {
        System.out.println("Get connection ...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Get connection " + connection);
        System.out.println("Done!");
        return connection;
    }

}
