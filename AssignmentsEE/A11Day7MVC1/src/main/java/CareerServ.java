

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.CareerExpert;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CareerExpert c1 = new CareerExpert();
		
		try {
			
			String ss = request.getParameter("qualification");
			PrintWriter pw = response.getWriter();
			pw.print(ss);
			
			request.setAttribute("advice", c1.getAdvice(ss));
			RequestDispatcher rd = request.getRequestDispatcher("CareerDetails.jsp");
			rd.forward(request, response);
		}
		catch(Exception ee) {ee.printStackTrace();}
	}

}
