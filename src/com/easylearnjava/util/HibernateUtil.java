package com.easylearnjava.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.easylearnjava.exception.ServiceException;

public class HibernateUtil {

	private static final String CONFIG_FILE_LOCATION = "/com/easylearnjava/properties/hibernate-cfg.xml";

	public static Session getSession() throws ServiceException {

		Session session = null;
		SessionFactory sessionFactory = null;

		try {			
			Configuration cfg = new Configuration();			
			sessionFactory = cfg.configure(CONFIG_FILE_LOCATION).buildSessionFactory(); 
		} catch (HibernateException he) {
			throw new ServiceException("Unable to build HibernateSessionFactory", he);
		}

		try {
			session = sessionFactory.openSession();
			return session;
		} catch (HibernateException e) {
			throw new ServiceException("Unable to open a HibernateSession");
		}
	}

	public static void closeSession(Session session) {
		if (session != null) {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}