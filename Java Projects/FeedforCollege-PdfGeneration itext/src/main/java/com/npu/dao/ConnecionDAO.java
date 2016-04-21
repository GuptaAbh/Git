package com.npu.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class ConnecionDAO {
	
private static final Logger log = Logger.getAnonymousLogger();
    
	private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    public ConnecionDAO() {
		// TODO Auto-generated constructor stub
	}
    public static Session getSession()
    {
        Session session = (Session) ConnecionDAO.sessionThread.get();
        
        if (session == null)
        {
            session = sessionFactory.openSession();
            ConnecionDAO.sessionThread.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        ConnecionDAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        ConnecionDAO.sessionThread.set(null);
    }



}
