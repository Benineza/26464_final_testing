package com.auca.dao;

import org.hibernate.Session;

import com.auca.domain.User;
import com.auca.util.DBConnection;

public class UserDao extends GenericDao<User, java.util.UUID> {
    public UserDao() {
        super(User.class);
    }

    public User findByUsername(String username) {
        try (Session session = DBConnection.getSessionFactory().openSession()) {
            return session.createQuery("FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }
}