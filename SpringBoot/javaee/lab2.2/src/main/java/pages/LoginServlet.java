package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	
	private CustomerDaoImpl dao;
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException {
		//create dao instance
		try {
			dao = new CustomerDaoImpl();
		} catch (Exception e) {
			// Inform WC that init has failed :  so that Wc wont continue
			// HOW:  throw servlet exception
			throw new ServletException("error in init of "+ getClass().getName(),e);
	}
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			dao.cleanUp();
		} catch (SQLException e) {
		System.out.println("in destroy of "+ getClass().getName()+ e);
		throw new RuntimeException("in destroy of "+ getClass().getName(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		//get PW
		try(PrintWriter pw = response.getWriter()){
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			
			Customer customer = dao.authenticateCustomer(email, password);
			System.out.println(customer.toString());
			if(customer == null) // invalid login ==> send a msg and link to retry
				pw.print("<h4> Invalid Login, Please <a href='login.html'>Retry</a></h4>");
			else {// succesful login
				   
				Cookie c1 = new Cookie("customer_dtls", URLEncoder.encode(customer.toString(), "UTF-8") );
				response.addCookie(c1);
				pw.print("<h4> Successful Login, Your Details: "+customer+ "</h4>");
			}
//				pw.flush();
			//
				response.sendRedirect("category");
		}catch(Exception e) {
			throw new ServletException("error in do-post of "+ getClass().getName(), e);
		}
		
	}

}
