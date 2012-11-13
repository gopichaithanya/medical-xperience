package util;

import org.hibernate.Session;


/**
 * Just a test class, to test database connection and update schema
 * @author Ricardo
 *
 */
public class TestConection {

	
	public static void main (String[] args){
		Session session = null;
		
		try{
			System.out.println("Antes de abrir a sessão");
		session = HibernateUtil.getSession().openSession();
		System.out.println("Depois de abrir a sessao");
		}catch (Exception e){
			System.out.println("Exception:");
			System.out.print(e);
		}finally{
			if (session != null){
				if (session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
				session.close();
			}
		}
		
	}
}
