package member_controller;

import java.io.IOException;
import java.util.Date;

import dao.MemberRepository;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member_add")
public class member_addController extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		System.out.println("member_add doget 이동");
		//모델이동
		//뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("addMember.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		System.out.println("member_add doPost 이동");
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

		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());

		Member mb = new Member();
		
		mb.setId(id);
		mb.setPassword(password);
		mb.setName(name);
		mb.setGender(gender);
		mb.setBirth(birth);
		mb.setMail(mail);
		mb.setPhone(phone);
		mb.setAddress(address);
		mb.setRegist_day(timestamp);
		//모델이동
		MemberRepository mr = MemberRepository.getMr();
		mr.create(mb);
		//뷰 이동
		resp.sendRedirect("/bookmarket");
	}

}
