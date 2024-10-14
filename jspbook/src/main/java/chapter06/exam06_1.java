package chapter06;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/6_1")
public class exam06_1 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter06/form01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String phoneNumber = req.getParameter("phone1") +"-"+ req.getParameter("phone2") +"-"+ req.getParameter("phone3");
		String sex = req.getParameter("sex");
		String[] hobby = req.getParameterValues("hobby");
		String comment = req.getParameter("comment");
		
		//이동
		req.setAttribute("id", id);
		req.setAttribute("password", password);
		req.setAttribute("name", name);
		req.setAttribute("phone", phoneNumber);
		req.setAttribute("sex", sex);
		req.setAttribute("hobby", hobby);
		req.setAttribute("comment", comment);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter06/form01_yourinfo.jsp");
		ds.forward(req, resp);
	}

}
