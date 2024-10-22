package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_1")
public class exam13_1 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/session01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(true);
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
//		System.out.println(id + " : " + pw);
		
		//이동
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/session01_process.jsp");
		ds.forward(req, resp);
	}

}
