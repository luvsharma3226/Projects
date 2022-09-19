package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class voterServlet
 */
@WebServlet("/voter")
public class voterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public voterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for (Cookie c : cookies) {
					if(c.getName().equals("cand_details")) {
						pw.print("<h4> Voter Login Successful </h4>");
						pw.print("<h4> Voter Details : "+URLDecoder.decode(c.getValue(), "UTF-8") + "</h4>");

					}
				}
			}
			
		}
	}

}
