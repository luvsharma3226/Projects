package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost of " + getClass().getName() + " invoked by " + Thread.currentThread());

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Successful Login</h5>");

			Customer customer = (Customer) request.getAttribute("user_details");
//			CustomerDaoImpl customerDao = (CustomerDaoImpl) hs.getAttribute("cust_dao");

			if (customer != null) {
				pw.print("<h5> Hello , " + customer.getEmail() + "</h5>");
				pw.print("<form action='category_details'>");
				pw.print("Choose Category : ");
				pw.print("<select name='cat_name'>");

				pw.print("</select>");
				pw.print("<input type='submit' value='Choose'>");
				pw.print("</form>");

			} else {
				pw.print("<h5>Request Dispatching failed !!!");
			}

//			pw.print("Details "+ request.getParameter("email")); 
		} catch (Exception e) {
			throw new ServletException("error in do-get of " + getClass().getName(), e);
		}
	}

}
