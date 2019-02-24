package com.Gemalto.database.dbUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String pathprivate = "C:\\Users\\Jakub\\Documents\\PROGRAMMING\\DocumentsManagement\\src\\main\\resources\\Hibernate.cfg.xml";
    private static final String pathGemalto = "C:\\Users\\10054889\\Documents\\documentsManagement\\src\\main\\resources\\Hibernate.cfg.xml";

    private static SessionFactory buildSessionFactory() {

        try {
            return new AnnotationConfiguration().configure(new File(pathprivate)).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void initDatabase() {
        buildSessionFactory();
        shutdown();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}
