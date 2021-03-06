package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(description = "Authentication Servlet", urlPatterns = { "/authenticate" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set response content type
		response.setContentType("text/html");
		
//		open PW to send response from servlet ---> clnt
		try(PrintWriter pw = response.getWriter()){
			pw.print("<h3> Email : "+ request.getParameter("email")+ "</h3>");
			pw.print("<h3> Password : "+ request.getParameter("pass")+ "</h3>");
		}
	}

}
