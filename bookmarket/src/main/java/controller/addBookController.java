package controller;

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

@WebServlet("/addBook")
public class addBookController extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("addBook doGet 도착");
		//전처리
		//모델이동
		//뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("addBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("addBook doPost 도착");
		//전처리
		String filename = "";
		String realFolder = req.getServletContext().getRealPath("resources/images");
		System.out.println(realFolder); 
		//D:\sgh\jsp\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\bookmarket\resources\images
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
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
		
		BookRepository dao = BookRepository.getInstance();
		
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
		
		dao.addBook(newBook);
		
		
		//모델이동
		
		//뷰 이동
		resp.sendRedirect("bookList");
	}

}
