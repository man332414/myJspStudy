package member_controller;

import java.io.IOException;

import dao.MemberRepository;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member_update")
public class member_UpdateController extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = "";
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			Member mb = (Member)session.getAttribute("member");
			id = mb.getId();
			System.out.println("id " + id);
		}
		else {
			resp.sendRedirect("member_login");
		}
		//모델이동
		MemberRepository mr = MemberRepository.getMr();
		Member mb = mr.readOneById(id);
		//뷰 이동
		req.setAttribute("mb", mb);
		RequestDispatcher ds = req.getRequestDispatcher("updateMember.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("member_Update doPost 이동");
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String year = req.getParameter("birthyy");
		String month = req.getParameterValues("birthmm")[0];
		String day = req.getParameter("birthdd");
		String birth = year + "/" + month + "/" + day;
		String mail1 = req.getParameter("mail1");
		String mail2 = req.getParameterValues("mail2")[0];
		String mail = mail1 + "@" + mail2;
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		Member mb = new Member();
		
		mb.setId(id);
		mb.setPassword(password);
		mb.setName(name);
		mb.setGender(gender);
		mb.setBirth(birth);
		mb.setMail(mail);
		mb.setPhone(phone);
		mb.setAddress(address);
		
		//모델이동
		MemberRepository mr = MemberRepository.getMr();
		mr.update(mb);
		
		//뷰 이동
		resp.sendRedirect("/bookmarket");
	}

}
