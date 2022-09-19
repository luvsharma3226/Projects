package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Candidate;
import pojos.Voter;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VoterDaoImpl vdao;
	private CandidateDaoImpl cdao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// create dao instance
		try {
			vdao = new VoterDaoImpl();
			cdao = new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in init of " + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			vdao.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("err in destroy of " + getClass().getName(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			List<Candidate> list = cdao.listCandidates();
			
			String em = request.getParameter("email");
			String ps = request.getParameter("pass");
			
			Voter v1 = vdao.validateUser(em, ps);
//			System.out.println(v1);
			if (v1 == null) {
				pw.print("<h5> Invalid Login.... </h5>");
				pw.print("<h5> <a href='login.html' >Retry</a> </h5>");
			} else {
				Cookie c = new Cookie("voter_details", URLEncoder.encode(v1.toString(), "UTF-8"));
				Cookie cdetails = new Cookie("cand_details", URLEncoder.encode(list.toString(), "UTF-8"));
//				System.out.println(c.getName());
//				System.out.println(URLDecoder.decode(c.getValue(), "UTF-8"));
//				System.out.println(v1.getRole());
//				System.out.println(list.toString());
				response.addCookie(c);
				response.addCookie(cdetails);
				if(v1.getRole().equals("admin")) {
					response.sendRedirect("admin");
				} else if (v1.getRole().equals("voter")){
					response.sendRedirect("voter");
				}
				pw.print("<h5> User Details are " + v1.toString() + "</h5>");
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
