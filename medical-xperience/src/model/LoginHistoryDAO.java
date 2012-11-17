package model;

import java.util.Date;

import org.hibernate.Session;

import util.HibernateUtil;

public class LoginHistoryDAO {
	

	public static void newLogin(String user, String ip){
		LoginHistory login = new LoginHistory();
		login.setIp(ip);
		login.setUsername(user);
		login.setTimestamp(new Date());
		login.setAction("login");
		
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.save(login);
		
	}
	
	public static void newLogoff(String user, String ip){
		LoginHistory login = new LoginHistory();
		login.setIp(ip);
		login.setUsername(user);
		login.setTimestamp(new Date());
		login.setAction("logoff");
		
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.save(login);
	}
	
}
