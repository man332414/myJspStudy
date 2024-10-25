package controller;

import java.io.IOException;

import DAO.member_repository;
import DTO.member_DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class member_controller4 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String userid = req.getParameter("id");
		//모델이동
		member_repository mr = member_repository.getInstance();
		member_DTO dto = mr.getOnemember(userid);
		System.out.println(dto.getId());
		//페이지이동
		req.setAttribute("DTO", dto);
		RequestDispatcher ds = req.getRequestDispatcher("updateform.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		Integer age = Integer.parseInt(req.getParameter("age"));
		System.out.println(id);
		System.out.println(pw);
		System.out.println(age);
		
		member_DTO dto = new member_DTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAge(age);
		
		//모델이동
		member_repository mr = member_repository.getInstance();
		mr.updatemember(dto);
		//페이지 이동
		resp.sendRedirect("readall");
	}
}
