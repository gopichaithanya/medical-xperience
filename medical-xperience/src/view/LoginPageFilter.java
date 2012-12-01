package view;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import controller.LoginController;

/**
 * Filter that verify if user is logged. This filter implements the security.
 * @author Ricardo
 *
 */
public class LoginPageFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Filter that if the user is logged, permit the acess. If the user isn't logged, redirect to login.jsf
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		String path = ((HttpServletRequest) request).getServletPath();
		if (excludeFromFilter(path)) { //Verify if is a page excluded from filter
			
			chain.doFilter(request, response); //proceed with request
			
			
		}else{ //if is not a page excluded
			
			HttpServletRequest sessionrequest= (HttpServletRequest)request;
			String url = "/login.jsf";
			if (!LoginController.isLogged(sessionrequest)){
				request.getRequestDispatcher(url).forward(request, response);
				return;
			} else {
				chain.doFilter(request, response);
			}
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Method that exclude some pages from the login filter.
	 * @param path related with HTTP request, will be used to verify if the page is allowed without the filter
	 * @return true if is one of pages permitted, false if not.
	 */
	private boolean excludeFromFilter(String path) {
	      if (path.startsWith("/login.jsf") || path.startsWith("/template.jsf")) {  // add more page to exclude here
	    	  return true; 
	      }else{
	    	  return false;
	      }
	   }

}
