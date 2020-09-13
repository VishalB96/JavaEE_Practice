

import java.io.IOException;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    private Connection conn;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
            conn = DriverManager.getConnection(url,"root","root");
			System.out.println("in init");
		}
		
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			 pw.println("name");
//	        String name = request.getParameter("name");
//	        String address = request.getParameter("address");
//	        System.out.println("in dopost");
//	        String email = request.getParameter("email");
//	        String username = request.getParameter("username");
//	        String password = request.getParameter("password");
//	        pw.println(name);
//	        pw.println(address);
//	        pw.println(email);
//	        pw.println(username);
//	        pw.println(password);
//	        PreparedStatement pst = conn.prepareStatement("insert into person value (?,?,?,?,?)");
//	        pst.setString(1,name);
//	        pst.setString(2,address);
//	        pst.setString(3,email);
//	        pst.setString(4,username);
//	        pst.setString(5,password);
//	        int k=pst.executeUpdate();
//				if(k>0)
//				{
//					pw.println("Record has been added");
//				}
//				else
//				{
//					pw.println("cannot add");
//				}
			
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
	}

}
