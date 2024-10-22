package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_2")
public class exam12_2 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doget연결");
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/filter02.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("dopost연결");
		//전처리
		String id_c = req.getParameter("id");
		String pw_c = req.getParameter("passwd");
		System.out.println("id : " + id_c);
		System.out.println("pw : " + pw_c);
		
		//이동
		req.setAttribute("id", id_c);
		req.setAttribute("pw", pw_c);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/filter02_process.jsp");
		ds.forward(req, resp);
	}
	
}
