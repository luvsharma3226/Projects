package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;

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
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

	private CustomerDaoImpl customerDao;
	private BookDaoImpl bookDao;
	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// create dao instance
		try {
			customerDao = new CustomerDaoImpl();
			bookDao = new BookDaoImpl();
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
		// set cont type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			Customer customer = customerDao.authenticateCustomer(email, password);
//			System.out.println(customer.toString());

			if (customer == null) // invalid login ==> send a msg and link to retry
				pw.print("<h4> Invalid Login, Please <a href='login.html'>Retry</a></h4>");
			else {// succesful login
				HttpSession hs = request.getSession();
				System.out.println("From login Page + " + hs.isNew());
				System.out.println("Session ID : " + hs.getId());
				hs.setAttribute("user_details", customer);
				//do you want to share anything more across dyn web  pages?
				//YES : dao instances :  empty cart : ArrayList<Integer> : list of selected books
				hs.setAttribute("cust_dao", customerDao);
				hs.setAttribute("book_dao", bookDao);
				hs.setAttribute("shopping_cart", new ArrayList<Integer>());
				
				response.sendRedirect("category");
			}
		} catch (Exception e) {
			throw new ServletException("error in do-post of " + getClass().getName(), e);
		}

	}

}
