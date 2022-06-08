package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session daoSession;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        daoSession = Util.getSession();
        daoSession.beginTransaction();
        daoSession.createNativeQuery("CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), lastName VARCHAR(100), age TINYINT)", User.class).executeUpdate();
        daoSession.getTransaction().commit();
        daoSession.close();
    }

    @Override
    public void dropUsersTable() {
        daoSession = Util.getSession();
        daoSession.beginTransaction();
        daoSession.createNativeQuery("DROP TABLE IF EXISTS users", User.class).executeUpdate();
        daoSession.getTransaction().commit();
        daoSession.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        daoSession = Util.getSession();
        daoSession.getTransaction().begin();
        User user = new User(name, lastName, age);
        daoSession.persist(user);
        daoSession.getTransaction().commit();
        daoSession.close();
    }

    @Override
    public void removeUserById(long id) {
        daoSession = Util.getSession();
        daoSession.getTransaction().begin();
        daoSession.createQuery("DELETE User WHERE id = :id").setParameter("id", id).executeUpdate();
        daoSession.getTransaction().commit();
        daoSession.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        daoSession = Util.getSession();
        daoSession.getTransaction().begin();
        users = daoSession.createQuery("FROM User", User.class).getResultList();
        daoSession.getTransaction().commit();
        daoSession.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        daoSession = Util.getSession();
        daoSession.getTransaction().begin();
        daoSession.createQuery("DELETE User").executeUpdate();
        daoSession.getTransaction().commit();
        daoSession.close();
    }
}