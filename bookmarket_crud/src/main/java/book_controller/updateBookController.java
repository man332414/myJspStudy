package book_controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class updateBookController extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		System.out.println("update book doGet 연결 : " + id);
		//모델연결
		BookRepository br = BookRepository.getInstance();
		Book book = br.getBookById(id);
		//뷰이동
		req.setAttribute("book", book);
		RequestDispatcher ds = req.getRequestDispatcher("updateBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("utf-8");
		//전처리
		System.out.println("update book doPost 연결");
		String save = req.getServletContext().getRealPath("resources/images");
		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitsInSrock = multi.getParameter("unitsInSrock");
		String condition = multi.getParameter("condition");
		String fileName = multi.getFilesystemName("BookImage");

		Integer price;
		
		if(unitPrice.isEmpty())
		{
			price = 0;
		}
		else
		{
			price = Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitsInSrock.isEmpty())
		{
			stock = 0;
		}
		else
		{
			stock = Long.valueOf(unitsInSrock);
		}
		
		
		Book newBook = new Book();
		newBook.setBookId(bookId);
		newBook.setBookname(name);
		newBook.setUnitPrice(price);
		newBook.setAuthor(author);
		newBook.setPublisher(publisher);
		newBook.setReleaseDate(releaseDate);
		newBook.setBookdescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setBookcondition(condition);
		newBook.setFilename(fileName);
		
		//모델연결
		BookRepository br = BookRepository.getInstance();
		br.updateBook(newBook);

		//뷰 이동
		resp.sendRedirect("editBook?edit=update");
	}

}
