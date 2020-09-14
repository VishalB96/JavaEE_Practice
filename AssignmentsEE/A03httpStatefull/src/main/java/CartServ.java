import java.io.*;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServ
 */
public class CartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ArrayList<String> cartItems = new ArrayList<String>();
			String[] temp = request.getParameterValues("cartList");
			int size = temp.length;
			for(int i =0 ; i<size;i++) {
				cartItems.add(temp[i]);
			}
			PrintWriter pw = response.getWriter();
			pw.print(cartItems);
			
			HttpSession session = request.getSession();
			session.setAttribute("cartList", cartItems);
			
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
	}

}
