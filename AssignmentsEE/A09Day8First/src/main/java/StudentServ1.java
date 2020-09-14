

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mypack.HibernateUtil;
import mypack.student1;

/**
 * Servlet implementation class StudentServ1
 */
public class StudentServ1 extends HttpServlet {
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
			int age=Integer.parseInt(request.getParameter("age").trim());
			student1 b1=new student1();
			b1.setName(name);
			b1.setAge(age);
			b1.setAddress(address);
			Transaction tx = session.beginTransaction();
			session.save(b1);
			tx.commit();
			session.close();
			out.println("Done with addition of student");
		}
		catch(Exception ee)
		{
			System.out.println("in service  "+ee);
		}
	}

}
