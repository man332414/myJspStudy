package book_controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/removeCart")
public class removeCartController extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		
		if(id == null || id.trim().equals(""))
		{
			resp.sendRedirect("bookList");
			return;
		}
		
		//모델과의 소통
		BookRepository dao = BookRepository.getInstance();
		
		Book book = dao.getBookById(id);
		if(book == null)
		{
			RequestDispatcher ds = req.getRequestDispatcher("exceptionNoBookId.jsp");
			ds.forward(req, resp);
		}
		
		HttpSession session = req.getSession(false);
		ArrayList<Book> cartList = (ArrayList<Book>)session.getAttribute("cartlist");
		Book goodsQnt = new Book();
		for(int i = 0; i<cartList.size(); i++)
		{
			goodsQnt = cartList.get(i);
			if(goodsQnt.getBookId().equals(id))
			{				
				cartList.remove(goodsQnt);
			}
		}
		
		resp.sendRedirect("cart");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
