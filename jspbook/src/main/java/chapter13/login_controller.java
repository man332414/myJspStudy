package chapter13;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13")
public class login_controller extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session  = req.getSession(true);
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/login.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id.equals("admin") && pw.equals("1234"))
		{
			System.out.println("출근하셨습니다.");
			// getSession(true) 혹은 getSession()은 현재 세션 객체가 있으면 그냥 쓰고 없으면 새로 생성한다.
			// getSesssion(false)는 현재 세션 객체가 있으면 그냥 쓰고 없으면 null 반환
			HttpSession session = req.getSession(true); //세션 생성
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			RequestDispatcher ds = req.getRequestDispatcher("chapter13/printer.jsp");
			ds.forward(req, resp);
}
		else
		{
			System.err.println("로그인 실패");
		}
	}

}
