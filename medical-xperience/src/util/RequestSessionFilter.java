package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

public class RequestSessionFilter implements Filter{

	private SessionFactory sf;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		try
		{
			sf.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			sf.getCurrentSession().getTransaction().commit();
			sf.getCurrentSession().close();
		}catch (Throwable e){
			try{
				if (sf.getCurrentSession().getTransaction().isActive()){
					sf.getCurrentSession().getTransaction().rollback();
				}
				sf.getCurrentSession().close();
			}catch (Throwable ex2){
				ex2.printStackTrace();
			}
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.sf = HibernateUtil.getSession();
	}
	
}
