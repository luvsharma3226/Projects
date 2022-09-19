package pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] bookIds = request.getParameterValues("book_id");
		HttpSession hs = request.getSession();
		
		List<Integer> cart = (List<Integer>) hs.getAttribute("shopping_cart");
		
		for (String s : bookIds) {
			cart.add(Integer.parseInt(s));
		}
		System.out.println("Cart contents : "+ cart);
		response.sendRedirect("category");
		
		
		
	}

}
