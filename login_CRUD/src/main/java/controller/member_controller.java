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

@WebServlet("/join")
public class member_controller extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("join.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int age = Integer.parseInt(req.getParameter("age"));
//		System.out.printf("%s, %s, %d",id, pw, age);
		
		member_DTO dto = new member_DTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAge(age);
		
		//모델이동
		member_repository mr = member_repository.getInstance();
		mr.member_create(dto);
		
		//뷰 이동
	}

}