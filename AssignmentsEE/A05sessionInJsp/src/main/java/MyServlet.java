

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> Teammates = new ArrayList<String>();
		Teammates.add("Shridhar");
		Teammates.add("Shweta");
		Teammates.add("Shivani");
		Teammates.add("Ravi");
		Teammates.add("Vishal");
		Teammates.add("Yugandhar");
		
		HttpSession session = request.getSession();
		session.setAttribute("Teammates", Teammates);
		PrintWriter pw = response.getWriter();
		pw.print("Session Created");
		
	}

}
