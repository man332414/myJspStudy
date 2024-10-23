package chapter14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/14_1")
public class exam14_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter14/cookie01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String req_id = req.getParameter("id");
		String req_pw = req.getParameter("pw");
		
		if(req_id.equals("admin") && req_pw.equals("1234"))
		{
			Cookie cookie_id = new Cookie("userid", req_id);
			Cookie cookie_pw = new Cookie("userpw", req_pw);
			
			resp.addCookie(cookie_id);
			resp.addCookie(cookie_pw);
			
			System.out.println("쿠키생성이 성공했습니다.");
			System.out.println(req_id+"님 환영합니다.");
		}
		else 
		{
			System.out.println("쿠키생성 실패");
		}
	}

}
