package member_controller;

import java.io.IOException;

import dao.BookRepository;
import dao.MemberRepository;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member_login")
public class member_login extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("membet_login doGet 도착");
		//전처리
		//모델 연결
		//뷰이동
		RequestDispatcher ds = req.getRequestDispatcher("loginMember.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		System.out.println("member_login doPost 도착");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		//모델 연결
		MemberRepository mr = MemberRepository.getMr();
		Member mb = mr.getUesr(id, password);
		if(mb != null) // DTO 가 존재하므로 회원이 맞음
		{
			//세션 생성
			HttpSession session = req.getSession(true); 
			session.setAttribute("member", mb);
		}
		else 
		{
			resp.sendRedirect("member_login?error=1");
		}
		//뷰이동
		RequestDispatcher ds = req.getRequestDispatcher("resultMember.jsp?msg=2");
		ds.forward(req, resp);
	}

}
