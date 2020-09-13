

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn;
    private DataSource ds;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String passwordC = request.getParameter("passwordC");
			String usernameC = request.getParameter("usernameC");
			
			conn=ds.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from register where username = ? and password = ?");
			pst.setString(1, usernameC);
			pst.setString(2, passwordC);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				response.sendRedirect("success.html");
			}
			else {
				response.sendRedirect("failed.html");
			}
			
			conn.close();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
		
	}

}


