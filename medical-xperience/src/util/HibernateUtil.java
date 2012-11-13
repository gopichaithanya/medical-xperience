package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Used to generate a session.
 * Baseed on Factory Design Pattern
 * @author Ricardo
 *
 */
public class HibernateUtil {

	private static final SessionFactory session = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory(){
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch (Exception e){
			throw new ExceptionInInitializerError();
		}
	}
	
	
	/**
	 * 
	 * @return session to use in persistence actions.
	 */
	public static SessionFactory getSession() {
		return session;
	}
	
	


	
}
