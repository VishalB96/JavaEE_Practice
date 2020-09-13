

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
 * Servlet implementation class ConPoolServ
 */

public class ConPoolServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private DataSource ds;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try
		{
		Context envContext  = new InitialContext();
			ds = (DataSource) envContext.lookup("java:/comp/env/jdbc/mypool");
		}
		catch(Exception ee)
		{
			System.out.println("In init\t"+ee);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PrintWriter out=response.getWriter();
	out.println("With Connection Pool");
	con=ds.getConnection();
	PreparedStatement pst=con.prepareStatement("select * from dept");
	ResultSet rs=pst.executeQuery();
	while(rs.next())
	{
		out.println(rs.getInt(1)+"\t");
		out.println(rs.getString(2)+"\t");		
		out.println(rs.getString(3));
	}
		con.close();
		}
		catch(Exception ex)
		{
			System.out.println("In Service\t"+ex);
		}
	}

}
