

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private DataSource ds;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			
			Context envContext = new InitialContext();
			ds = (DataSource)envContext.lookup("java:/comp/env/jdbc/mypool");
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] paraNames = {"name","address","email","username","password"};
			
			//String[] personInfo = new String[5];
			conn = ds.getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into register values (?,?,?,?,?)");
			
			for(int i = 0 ; i<5;i++) {
				//personInfo[i] = request.getParameter(paraNames[i]);
				pst.setString(i+1,request.getParameter(paraNames[i]) );
				}
				pst.executeUpdate();
				conn.close();
			}
		catch(java.sql.SQLIntegrityConstraintViolationException dee) {
			PrintWriter pw = response.getWriter();
			pw.print("<h1>USERNAME ALREADY TAKEN</h1><br> <a href=\"register.html\">Go Back</a><br>");
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.print("<a href=\"login.html\">Login</a>");
		//response.sendRedirect("Home.html");
		
	}

}
