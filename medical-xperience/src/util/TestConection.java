package util;

import model.ApplicationLogDAO;

import org.hibernate.Session;


/**
 * Just a test class, to test database connection and update schema
 * @author Ricardo
 *
 */
public class TestConection {

	
	public static void main (String[] args){
		Session session = null;
		
		session = HibernateUtil.getSession().getCurrentSession();
		/*
		session.beginTransaction();
	    Person p = new Person();
	    p.setCpf("123.123.123-64");
	    p.setEmail("admin@medicalxperirence.com");
	    p.setFirstName("Administrator");
	    p.setLastName("1");
	    p.setPassword("admin");
	    p.setPermission(0);
	    p.setPhone("+55 19 8811-1122");
	    p.setUser("admin");
	    PersonDAO.save(p);
	    */
		session.beginTransaction();
		ApplicationLogDAO.createLog("TestEnvirorment", "admin", "127.0.0.1", "Creating Table", "Creating and Validating Log Table",5);
		session.getTransaction().commit();
		System.out.println("SALVO");
	}
}
