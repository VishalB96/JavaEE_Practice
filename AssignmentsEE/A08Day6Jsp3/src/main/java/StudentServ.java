

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentServ
 */
public class StudentServ extends HttpServlet {
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
			List<Integer> list = new ArrayList<Integer>();
			conn = ds.getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into students values (?,?,?,?)");
				pst.setInt(1,Integer.parseInt(request.getParameter("rollno").trim()));
				pst.setString(2, request.getParameter("name"));
				pst.setInt(3, Integer.parseInt(request.getParameter("age").trim()));
				pst.setString(4, request.getParameter("address"));
				pst.executeUpdate();
				
				pst = conn.prepareStatement("select rollNo from students");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					list.add(rs.getInt("rollNo"));
				}
				conn.close();
				request.setAttribute("rollno", list);
				PrintWriter pw = response.getWriter();
				pw.print(list);
				RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
				rd.forward(request, response);
			}
		
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
	}
	

}
