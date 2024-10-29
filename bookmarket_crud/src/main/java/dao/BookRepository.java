package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.Book;

public class BookRepository 
{
	private static BookRepository instance = new BookRepository();
	
	public static BookRepository getInstance()
	{
		return instance;
	}
	
	Connection DBconn() throws Exception
	{
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bookmarketDB";
		String root = "root";
		String passwd = "1234";
		conn = DriverManager.getConnection(url, root, passwd);
		System.out.println("DB연결이 성공했습니다.");
		
		return conn;
	}
	
	public ArrayList<Book> getAllBooks()
	{
		//DB연결
		System.out.print("getAllBooks 함수 : ");
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		try 
		{
			Connection conn = DBconn();			
			//SQL 작성
			String sql = "select * from book";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//ResultSet 제어
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{				
				Book book = new Book();
				book.setBookId(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setUnitPrice(rs.getInt("unitPrice"));
				book.setAuthor(rs.getString("author"));
				book.setBookdescription(rs.getString("bookdescription"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				book.setUnitsInStock(rs.getLong("unitsInStock"));
				book.setReleaseDate(rs.getString("releaseDate"));
				book.setBookcondition(rs.getString("bookcondition"));
				book.setFilename(rs.getString("filename"));
				
				listOfBooks.add(book);
			}
			pstmt.close();
			conn.close();
		}
		catch (Exception e) {e.printStackTrace();}
		return listOfBooks;
	}
	
	public Book getBookById(String bookId)
	{
		System.out.print("getBookById 함수 : ");
		Book bookById = null;
		//DB연결
		try 
		{
			Connection conn = DBconn();
			//sql 작성 및 전송
			String sql = "select * from book where bookid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			//ResultSet 가져와서 만지기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				bookById = new Book();
				bookById.setBookId(rs.getString("bookid"));
				bookById.setBookname(rs.getString("bookname"));
				bookById.setUnitPrice(rs.getInt("unitPrice"));
				bookById.setAuthor(rs.getString("author"));
				bookById.setBookdescription(rs.getString("bookdescription"));
				bookById.setPublisher(rs.getString("publisher"));
				bookById.setCategory(rs.getString("category"));
				bookById.setUnitsInStock(rs.getLong("unitsInStock"));
				bookById.setReleaseDate(rs.getString("releaseDate"));
				bookById.setBookcondition(rs.getString("bookcondition"));
				bookById.setFilename(rs.getString("filename"));
			}
			pstmt.close();
			conn.close();		
		}
		catch (Exception e) {e.printStackTrace();}
		return bookById;
	}
	
	public void addBook(Book book)
	{
		System.out.print("addBook 함수 : ");
		try 
		{
			//db연결
			Connection conn = DBconn();
			//sql 작성
			String sql = "insert into book values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getBookname());
			pstmt.setInt(3, book.getUnitPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getBookdescription());
			pstmt.setString(6, book.getPublisher());
			pstmt.setString(7, book.getCategory());
			pstmt.setLong(8, book.getUnitsInStock());
			pstmt.setString(9, book.getReleaseDate());
			pstmt.setString(10, book.getBookcondition());
			pstmt.setString(11, book.getFilename());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			//ResultSet 제어
		}
		catch (Exception e) {e.printStackTrace();}
	}

	public void updateBook(Book book) 
	{
		//DB연결
		System.out.print("update book 함수 : ");
		try 
		{
			Connection conn = DBconn();
			//sql 작성
			if(book.getFilename() != null)
			{
				String sql = "update book set bookname=? unitPrice=? author=? bookdescription=? publisher=? category=? unitsInStock=? releaseDate=? bookcondition=? fileName=? where bookid = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getBookname());
				pstmt.setInt(2, book.getUnitPrice());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getBookdescription());
				pstmt.setString(5, book.getPublisher());
				pstmt.setString(6, book.getCategory());
				pstmt.setLong(7, book.getUnitsInStock());
				pstmt.setString(8, book.getReleaseDate());
				pstmt.setString(9, book.getBookcondition());
				pstmt.setString(10, book.getFilename());
				pstmt.setString(11, book.getBookId());
				pstmt.executeUpdate();
			} 
			else
			{
				String sql = "update book set bookname=? unitPrice=? author=? bookdescription=? publisher=? category=? unitsInStock=? releaseDate=? bookcondition=? where bookid = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getBookname());
				pstmt.setInt(2, book.getUnitPrice());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getBookdescription());
				pstmt.setString(5, book.getPublisher());
				pstmt.setString(6, book.getCategory());
				pstmt.setLong(7, book.getUnitsInStock());
				pstmt.setString(8, book.getReleaseDate());
				pstmt.setString(9, book.getBookcondition());
				pstmt.setString(10, book.getBookId());
				pstmt.executeUpdate();
			}
			
			//ResultSet 사용
		} 
		catch (Exception e){e.printStackTrace();}
	}

	public void deleteBook(String id) 
	{
		try 
		{
			//DB연결
			Connection conn = DBconn();
			//sql 작성 및 조작
			String sql = "delete from book where bookid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			//ResultSet 제어
		}
		catch (Exception e){e.printStackTrace();}
	}

}
