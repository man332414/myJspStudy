package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_6")
public class exam11_6 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/tryCatch.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try 
		{
			//전처리
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			int c = a/b;
			System.out.println(a + " / " +b+ " = " +c);
		}
		catch(Exception e)
		{
			//이동
			RequestDispatcher ds = req.getRequestDispatcher("chapter11/tryCatch_error.jsp");
			ds.forward(req, resp);
		}
	}

}
