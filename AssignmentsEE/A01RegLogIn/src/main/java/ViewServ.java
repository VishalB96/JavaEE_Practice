

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ViewServ
 */
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private DataSource ds;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Context envrContext = new InitialContext();
			ds = (DataSource) envrContext.lookup("java:/comp/env/jdbc/mypool");
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			String[] paraNames = {"name","address","email","username"};
			int size = paraNames.length;
			String[] dataRow = new String[size];
			conn = ds.getConnection();
			PreparedStatement pst = conn.prepareStatement("select name,address,email,username From register");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				for(int i=0; i< size;i++) 
					dataRow[i]=rs.getString(i+1);
				
				pw.print("<br>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> <br>");
				
				for(int i=0; i<size;i++)
				pw.print(paraNames[i]+" : "+dataRow[i]+"<br>");
				
				pw.print("<br>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> <br>");
			}
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

}
