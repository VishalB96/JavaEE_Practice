
import mypack.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mypack.HibernateUtil;

/**
 * Servlet implementation class ViewServ
 */
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
		Query<?> query = session.createQuery("from Product");
		List<Product> ar = (List<Product>) query.list();
		request.setAttribute("viewproduct", ar);
		RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
		rd.forward(request, response);
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

}
