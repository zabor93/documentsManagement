package com.Gemalto.database.dbUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            return new AnnotationConfiguration().configure(new File("C:\\Users\\10054889\\Documents\\documentsManagement\\src\\main\\resources\\Hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void initDatabase(){
        buildSessionFactory();
        shutdown();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static void shutdown() {
        getSessionFactory().close();
    }

}
