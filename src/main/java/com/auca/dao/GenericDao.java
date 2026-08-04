package com.auca.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.auca.util.DBConnection;

public class GenericDao<T, ID extends Serializable> {
    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T save(T entity) {
        Transaction tx = null;
        try (Session session = DBConnection.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public T findById(ID id) {
        try (Session session = DBConnection.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        }
    }
}