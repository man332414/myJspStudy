package chapter13;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_3")
public class exam13_3 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/*System.out.println("dusruf");
		HttpSession session = req.getSession();
		String name;
		String value;
		
		Enumeration en = session.getAttributeNames();
		System.out.println(en.hasMoreElements());
		int i = 0;
		
		while(en.hasMoreElements())
		{
			name = (String)en.nextElement();
			value = (String)session.getAttribute(name);
			i++;
			System.out.println(name + " " + i + " " + value );
		}*/
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/session03.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
