package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //jm.task.core.jdbc.util.Util.getConnection();
        jm.task.core.jdbc.dao.UserDaoJDBCImpl userDaoJDBC= new UserDaoJDBCImpl();
        //userDaoJDBC.createUsersTable();
        //userDaoJDBC.saveUser("Мария", "Сазыкина", (byte) 43);
        //userDaoJDBC.saveUser("Алексей", "Цуцкарёв", (byte) 48);
        //userDaoJDBC.saveUser("Екатерина", "Цуцкарёва", (byte) 15);
        //userDaoJDBC.saveUser("Валентина", "Цуцкарёва", (byte) 77);
        //userDaoJDBC.saveUser("James", "Brown", (byte) 100);
        //userDaoJDBC.removeUserById(1);
        //System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        //userDaoJDBC.dropUsersTable();
        //jm.task.core.jdbc.dao.UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //userDaoHibernate.createUsersTable();
    }
}
