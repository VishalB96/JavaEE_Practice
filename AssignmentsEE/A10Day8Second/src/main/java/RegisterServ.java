

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mypack.HibernateUtil;
import mypack.Register1;


/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession(); 
			System.out.println("after change");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			Register1 b1=new Register1();
			b1.setName(name);
			b1.setAddress(address);
			b1.setEmail(email);
			b1.setUsername(username);
			b1.setPassword(password);
			
			Transaction tx = session.beginTransaction();
			session.save(b1);
			tx.commit();
			session.close();
			out.println("Done with Registration");
		}
		catch(Exception ee)
		{
			System.out.println("in service  "+ee);
		}
	}

}
