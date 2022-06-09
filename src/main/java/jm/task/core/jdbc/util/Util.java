package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/my_first_db";
    private static final String USERNAME = "wertor";
    private static final String PASSWORD = "kA60022160";
    private static Connection connection;

    private static SessionFactory concreteSessionFactory;

    public static Connection getConnection () throws SQLException, ClassNotFoundException {
        System.out.println("Get connection ...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Get connection " + connection);
        System.out.println("Done!");
        return connection;
    }

    public static Session getSession() throws HibernateException {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", URL);
        properties.setProperty("hibernate.connection.username", USERNAME);
        properties.setProperty("hibernate.connection.password", PASSWORD);
        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hbm2ddl.auto", "update");
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        concreteSessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return concreteSessionFactory.openSession();
    }
}
