package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class PersonDAO {

	public static Person getPerson (int id){
		Session session = HibernateUtil.getSession().getCurrentSession();
		Person p = (Person) session.load(Person.class, id);
		return p;
	}
	
	public static Person validateLogin(String user, String password) {
		Session session = HibernateUtil.getSession().getCurrentSession();
		Criteria c = session.createCriteria(Person.class)
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("password", password));
		if (c.list().isEmpty()) {
			return null;
		} else {
			Person p = (Person) c.list().iterator().next();
			return p;
		}
	}
	
	public static List<Person> list(){
		Session session = HibernateUtil.getSession().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> list = (List<Person>) session.createCriteria(Person.class).list();
		return list;
	}
	
	public static void save(Person p){
		//TODO Fazer Try-Catch ou tirar a transação
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
}
