package chapter16;

import java.io.IOException;

import DAO.exam_repository;
import DTO.exam_DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_7")
public class exam16_7 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doGet");
		//전처리
		String id = req.getParameter("id");
		//모델이동
		exam_repository er = exam_repository.getInstance();
		//페이지 이동
		exam_DTO dto = er.before_update_member(id);
		req.setAttribute("dto", dto);
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/update.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doPost");
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		System.out.println(id + " / " + pw + " / " + name);	
		
		exam_DTO dto = new exam_DTO();
		dto.setId(id);
		dto.setPassword(pw);
		dto.setName(name);
		//모델이동
		exam_repository er = exam_repository.getInstance();
		er.update_member(dto);
		//페이지 이동
		resp.sendRedirect("16_5");
	}

}
