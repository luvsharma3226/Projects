package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			Cookie[] cookies = request.getCookies();
			pw.print("<h4> Succesful Login </h4>");
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("customer_dtls"))
						pw.print("<h5> Customer Details from logout " + c.getValue() + "</h5");
			} else {
				pw.print("<h5> No Cookies found. Session Tracking failed !!! </h5>");
				pw.print("<h5> You have logged Out!!! </h5>");
				pw.print("<h5> <a href='login.html'> Visit again</a> </h5>");

			}
		}
	}

}
