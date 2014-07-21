package com.easylearnjava.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.easylearnjava.exception.DaoException;
import com.easylearnjava.util.HibernateUtil;


/**
 *This class interacts with the database and fetches the password and returns to LoginService class.
 */
public class LoginDao {
	
private final String GET_USER_PASSWORD_BY_USERNAME_HQL = "SELECT password  FROM User WHERE userName = :userName";
	
	public String getUserPassword(String username){
		
		Session session = null;
		String dbPassword = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery(GET_USER_PASSWORD_BY_USERNAME_HQL);
			query.setParameter("userName", username);
			dbPassword =  (String) query.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			if(null!= session && session.isOpen()){
				HibernateUtil.closeSession(session);
			}
			throw new DaoException();
		}	    
		HibernateUtil.closeSession(session);
	    return dbPassword;
	}
}
