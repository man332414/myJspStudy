package board_Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BoardRepository;
import dto.Board;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BoardListAction")
public class boardReadAllController extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int Limit = 5; //페이지당 출력할 글의 갯수를 제한
		//전처리
		System.out.println("boardList doGet 입장");
		String page = req.getParameter("pageNum");
		int pageNum = 1;
		if(page != null)
		{
			pageNum = Integer.parseInt(page);						
		}
		//모델연결
		BoardRepository br = BoardRepository.getBr();
		ArrayList<Board> arr = br.getAllContents();
		int total_record = br.getTotalCount();
		int total_page = 0;
		if(total_record % Limit == 0)
		{
			total_page = total_record/Limit;
		}
		else
		{
			total_page = (total_record/Limit)+1;
		}
		System.out.println(total_page);
		//뷰 이동
		req.setAttribute("total_page", total_page); //출력할 페이지의 갯수
		req.setAttribute("total_record", total_record);	// 전체 글의 갯수
		req.setAttribute("pageNum", pageNum); // 현재 페이지 번호
		req.setAttribute("arr", arr); // 전체 글을 담은 객체
		RequestDispatcher ds = req.getRequestDispatcher("list.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
}
