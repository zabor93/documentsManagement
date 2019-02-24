package com.Gemalto.database.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private SessionFactory sessionFactory;
    private GenericDao<T> dao;
    private Class<T> c1;

    public GenericDaoImpl(Class<T> c1, SessionFactory sessionFactory) {
        this.c1 = c1;
        this.sessionFactory = sessionFactory;
        if (sessionFactory == null) {
            throw new RuntimeException("Session Factory is null");
        }
    }

    public T get(Class<T> tClass, Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        T element = (T) session.get(tClass, id);
        session.getTransaction().commit();
        return element;
    }

    public T save(T object) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    public void update(T object) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();

    }

    public void delete(T object) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hsql);
        if (params != null) {
            for (String i : params.keySet()) {
                query.setParameter(i, params.get(i));
            }
        }

        List<T> result = null;
        if ((hsql.toUpperCase().indexOf("DELETE") == -1)
                && (hsql.toUpperCase().indexOf("UPDATE") == -1)
                && (hsql.toUpperCase().indexOf("INSERT") == -1)) {
            result = query.list();
        } else {
        }
        session.getTransaction().commit();

        return result;
    }

    @Override
    public List<T> getAll() {
        return query("from " + c1.getName(), null);
    }

    public void deleteAll() {
        query("delete from" + c1.getName(), null);

    }

    public boolean deleteById(Class<T> tClass, Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object persistenceInstance = session.load(tClass, id);
        if (persistenceInstance != null) {
            session.delete(persistenceInstance);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }

    public Object find(Class<T> tClass, Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object persistenceInstance = session.load(tClass, id);
        if (persistenceInstance != null) {
            return persistenceInstance;
        }
        return null;
    }
}
