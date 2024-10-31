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

@WebServlet("/editBook")
public class editBookcontroller extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String edit = req.getParameter("edit");
		System.out.println("edit book 연결 " + edit);
		//모델연결
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> listOfBooks = br.getAllBooks();
		//뷰 이동
		req.setAttribute("arr", listOfBooks);
		req.setAttribute("edit", edit);
		RequestDispatcher ds = req.getRequestDispatcher("editBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
