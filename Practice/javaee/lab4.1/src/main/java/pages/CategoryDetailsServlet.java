package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;

/**
 * Servlet implementation class CategoryDetailsServlet
 */
@WebServlet("/category_details")
public class CategoryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get session
			HttpSession session = request.getSession();

			BookDaoImpl bookDao = (BookDaoImpl) session.getAttribute("book_dao");
			String category = request.getParameter("cat_name");
			
			List<Book> bookList = bookDao.getAllBookByCategory(category);

			pw.print("<h5> Books under " + category + "</h5>");
			pw.print("<form action='add_to_cart'>");
			for (Book b : bookList) {
				// dyn check boxes;
				pw.print("<input type='checkbox' name='book_id' value=" + b.getBookId() + ">" + b+ "<br>");
			}

			pw.print("<input type='submit' value='Add To Cart'>");
			pw.print("</form>");

		} catch (Exception e) {
			throw new ServletException("error in do-get of " + getClass().getName(), e);
		}
	}

}
