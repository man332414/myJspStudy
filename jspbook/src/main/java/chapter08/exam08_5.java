package chapter08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/8_5")
public class exam08_5 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter08/validation05.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone1") +"-"+ req.getParameter("phone2") +"-"+ req.getParameter("phone3");
		String email = req.getParameter("email");
		System.out.println(id);
		System.out.println(name);
		System.out.println(pw);
		System.out.println(phone);
		System.out.println(email);
		
		//repository 저장 생략

		//이동
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		req.setAttribute("pw", pw);
		req.setAttribute("phone", phone);
		req.setAttribute("email", email);
		RequestDispatcher ds = req.getRequestDispatcher("chapter08/validation05_process.jsp");
		ds.forward(req, resp);		
	}
	
}
