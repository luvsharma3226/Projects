package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.BookDaoImpl;
import pojos.Book;
import pojos.Customer;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4> Succesful Login </h4>");
			HttpSession hs = request.getSession();
			System.out.println("From Logout page "+hs.isNew());
			System.out.println("Session ID : "+ hs.getId());
			
			Customer c = (Customer) hs.getAttribute("user_details");
			List<Integer> listBooks = (List<Integer>) hs.getAttribute("shopping_cart");
			BookDaoImpl bookDao = (BookDaoImpl) hs.getAttribute("book_dao");
				double cartValue = 0;
			for (Integer i : listBooks) {
				Book b = bookDao.getBookById(i);
				cartValue += b.getPrice();
				pw.print("<h5>"+ b + "</h5> ");
			}
			pw.print("<h5> Total cart value = " +cartValue + "</h5> ");
			
			if(c != null )
				pw.print("Hello "+ c.getEmail());
			else
				pw.print("<h5> No Cookies found. Session Tracking failed !!! </h5><br>");
			hs.invalidate();
			pw.print("<br><h5> You have logged Out!!! </h5>");
			pw.print("<h5> <a href='login.html'> Visit again</a> </h5>");
			
		} catch (Exception e) {
			throw new ServletException("error in do-get of"+getClass().getName(),e);
		}
	}

}
