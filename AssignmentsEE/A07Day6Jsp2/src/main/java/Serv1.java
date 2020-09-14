

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv1
 */
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = (String) request.getParameter("nameList");
		PrintWriter pw = response.getWriter();
		pw.print(request.getParameter("nameList"));
		if(s1.equalsIgnoreCase("java")) {
			//response.sendRedirect("j2se.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("j2se.jsp");
			rd.forward(request, response);
		}else if(s1.equalsIgnoreCase("c++")) {
			//response.sendRedirect("cplusplus.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("cplusplus.jsp");
			rd.forward(request, response);
		}else if(s1.equalsIgnoreCase("oracle")) {
			//response.sendRedirect("ora.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("ora.jsp");
			rd.forward(request, response);
		}
		
	}

}
