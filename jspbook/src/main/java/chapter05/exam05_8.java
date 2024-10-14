package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/5_8")
public class exam05_8 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter05/out02.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("id");
		String userpw = req.getParameter("passwd");
		
		req.setAttribute("id", userid);
		req.setAttribute("pw", userpw);
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter05/out02_process.jsp");
		ds.forward(req, resp);
	}

}
