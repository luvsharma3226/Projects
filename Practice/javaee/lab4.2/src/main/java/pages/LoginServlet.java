package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {

	private CustomerDaoImpl customerDao;
	private BookDaoImpl bookDao;
	
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		System.out.println("in default constr "+ getServletConfig());
	}

	public void init() throws ServletException {
		// create dao instance
		//get servlet config
		ServletConfig config = getServletConfig();
		System.out.println("in init "+ config);
		try {
			customerDao = new CustomerDaoImpl(
					config.getInitParameter("drvr_cls"),
					config.getInitParameter("db_url"),
					config.getInitParameter("user_nm"),
					config.getInitParameter("password")
			);
			bookDao = new BookDaoImpl(
					config.getInitParameter("drvr_cls"),
					config.getInitParameter("db_url"),
					config.getInitParameter("user_nm"),
					config.getInitParameter("password")
					);
			System.out.println("in init loginservlet");
		} catch (Exception e) {
			// Inform WC that init has failed : so that Wc wont continue
			// HOW: throw servlet exception
			throw new ServletException("error in init of " + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			customerDao.cleanUp();
			bookDao.cleanUp();
		} catch (SQLException e) {
			System.out.println("in destroy of " + getClass().getName() + e);
			throw new RuntimeException("in destroy of " + getClass().getName(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost of "+ getClass().getName()+" invoked by " + Thread.currentThread());
		// set content type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			Customer customer = customerDao.authenticateCustomer(email, password);
//			System.out.println(customer.toString());

			if (customer == null) // invalid login ==> send a msg and link to retry
				pw.print("<h4> Invalid Login, Please <a href='login.html'>Retry</a></h4>");
			else {    // succesful login
				
				request.setAttribute("user_details", customer);
				// Server Pull : Forward Scenario. Navigating clnt from login to category... 
				// Same request
				
				// Step 1 : create RequestDispatcher obj to wrap the necxt page.
				RequestDispatcher rd = request.getRequestDispatcher("category");
				
				// Forward the clnt from login to servlet
						rd.forward(request, response);
						System.out.println("after forward ....");
				
			}
		} catch (Exception e) {
			throw new ServletException("error in do-post of " + getClass().getName(), e);
		}

	}

}
