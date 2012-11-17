package model;

import java.util.Date;

import org.hibernate.Session;

import util.HibernateUtil;

public class ApplicationLogDAO {
	
	public static void createLog(String where, String user, String ip, String action, String log_message){
		ApplicationLog log = new ApplicationLog();
		log.setAction(action);
		log.setTimestamp(new Date());
		log.setIp(ip);
		log.setLog_message(log_message);
		log.setFromUser(user);
		log.setFromWhere(where);
		
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.save(log);
	}
}
