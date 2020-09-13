

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
 * Servlet implementation class Serv1
 */
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private DataSource ds;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Context envContext = new InitialContext();
			ds = (DataSource) envContext.lookup("java:/comp/env/jdbc/mypool");
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<String> loc = new ArrayList<String>();
			conn = ds.getConnection();
			PreparedStatement pst = conn.prepareStatement("select loc from dept");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				loc.add(rs.getString("loc"));
			}
			
//			PrintWriter pw = response.getWriter();
//			pw.print(loc);
			conn.close();
			request.setAttribute("loc", loc);
			RequestDispatcher rd = request.getRequestDispatcher("Serv2");
			rd.forward(request, response);
			
		}
		catch(Exception ee) 
		{
			ee.printStackTrace();
		}
		
	}

}
