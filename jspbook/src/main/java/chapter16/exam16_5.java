package chapter16;

import java.io.IOException;
import java.util.ArrayList;

import DAO.exam_repository;
import DTO.exam_DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_5")
public class exam16_5 extends HttpServlet  
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doGet 연결");
		//전처리
		//모델연결
		exam_repository er = exam_repository.getInstance();

		ArrayList<exam_DTO> arr = er.readall(); 
		//페이지 이동
		req.setAttribute("arr", arr);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/select.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
