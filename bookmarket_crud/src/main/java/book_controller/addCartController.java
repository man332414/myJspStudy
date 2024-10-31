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

@WebServlet("/addCart")
public class addCartController extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		System.out.println(id);
		if(id == null || id.trim().equals(""))
		{
			resp.sendRedirect("bookList");
			return;
		}
		
		//모델과 자료 소통
		BookRepository dao = BookRepository.getInstance();
		
		Book book = dao.getBookById(id);
		System.out.println(book);
		if(book==null)
		{
			RequestDispatcher ds = req.getRequestDispatcher("exceptionNoBookId.jsp");
			ds.forward(req, resp);
		}
		
		ArrayList<Book> goodsList = dao.getAllBooks();
		
		Book goods = new Book();
		for(int i = 0; i<goodsList.size(); i++)
		{
			goods = goodsList.get(i);
			if(goods.getBookId().equals(id))
			{
				break;				
			}
		}
		HttpSession session = req.getSession(true);
		ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("cartlist");
		if(list == null)
		{
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}
		
		int cnt = 0;
		Book goodsQnt = new Book();
		for(int i = 0; i<list.size(); i++)
		{
			goodsQnt = list.get(i);
			if(goodsQnt.getBookId().equals(id))
			{				
				cnt++;
				int orderQuantity = goodsQnt.getQuantity()+1;
				goodsQnt.setQuantity(orderQuantity);
			}
		}
		
		if(cnt == 0)
		{
			goods.setQuantity(1);
			list.add(goods);
		}
		
		resp.sendRedirect("book?id=" + id);
	}

}
