package chapter17;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/17_2")
public class exam17_2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		System.out.println("17_2 doget 이동");
		//모델이동
		//뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter17/core02.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		System.out.println("17_2 doPost 이동");
		int num = Integer.parseInt(req.getParameter("num"));
		//모델이동
		//뷰 이동
		req.setAttribute("num", num);
		RequestDispatcher ds = req.getRequestDispatcher("chapter17/core02_process.jsp");
		ds.forward(req, resp);
	}

}
