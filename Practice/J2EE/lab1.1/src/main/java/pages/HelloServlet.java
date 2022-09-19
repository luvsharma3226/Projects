package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@WebServlet(urlPatterns = "/testing")
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doGet " + Thread.currentThread());
		//set content type for client browser
		resp.setContentType("text/html");
		// open print writer to send response from servlet ---> clnt(text)
		try(PrintWriter pw = resp.getWriter()){
			pw.print("<h5>Hello from servlet @ "+ LocalDateTime.now() + "<h5>");
		}
	}

	@Override
	public void destroy() {
		System.out.println("in destroy " + Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init " + Thread.currentThread());
	}
	
}
