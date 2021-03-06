import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

    /**
     * Default constructor. 
     */
    public RegisterServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb";
			conn = DriverManager.getConnection(url, "root", "root");
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("Welcome");
			
			PreparedStatement pst =  conn.prepareStatement("insert into person values (?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setString(3, email);
			pst.setString(4, username);
			pst.setString(5, password);
			int k = pst.executeUpdate();
			if(k>0)pw.println("Updated");
			else pw.println("Not Updated");
			
		}
		catch(java.sql.SQLIntegrityConstraintViolationException sqe) {
			PrintWriter pw = response.getWriter();
			
			pw.println("username "+username +" already taken");
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
//		finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	
	}


    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	PrintWriter pw = response.getWriter();
		pw.println("Welcome");
    	}
    }
