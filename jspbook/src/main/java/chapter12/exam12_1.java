package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_1")
public class exam12_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doGet 연결");
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/filter01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doPost 연결");
		//전처리
		System.out.println("이름 : " + req.getParameter("name") + ";");
		String name = req.getParameter("name");
		
		//이동
		req.setAttribute("name", name);
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/filter01_process.jsp");
		ds.forward(req, resp);
	}

}
