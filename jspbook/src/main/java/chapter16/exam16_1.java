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

@WebServlet("/16_1")
public class exam16_1 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		
		//모델이동

		//페이지 이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/insert01.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("post arrived");
		//전처리
		String id = req.getParameter("id");
		String passwd = req.getParameter("password");
		String name = req.getParameter("name");
		System.out.println(id +" / "+ passwd  +" / "+ name);
		
		exam_DTO dto = new exam_DTO();
		dto.setId(id);
		dto.setPassword(passwd);
		dto.setName(name);
		//모델이동
		exam_repository er = exam_repository.getInstance();
		er.insert_member(dto);
		//뷰 이동
		resp.sendRedirect("chapter16/all_member.jsp");
	}

}
