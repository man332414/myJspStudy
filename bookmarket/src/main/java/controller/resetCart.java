package controller;

import java.io.IOException;
import java.util.ArrayList;

import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/resetCart")
public class resetCart extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		ArrayList<Book> cartList = (ArrayList<Book>)session.getAttribute("cartlist");
		Book goodsQnt = new Book();
		for(int i = 0; i<cartList.size(); i++)
		{
			goodsQnt = cartList.get(i);
			cartList.remove(goodsQnt);
		}
		
		resp.sendRedirect("cart");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
