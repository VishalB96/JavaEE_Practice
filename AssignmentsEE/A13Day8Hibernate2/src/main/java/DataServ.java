

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mypack.Dept;
import mypack.HibernateUtil;

/**
 * Servlet implementation class DataServ
 */
public class DataServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loca = request.getParameter("SearchQuery");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query<?> query = session.createQuery("from Dept as D where D.loc=:str");
			query.setParameter("str", loca);
			List<Dept> dept = (List<Dept>)query.list();
			session.close();
			request.setAttribute("loclist", dept);
			RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}

}
