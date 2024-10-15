package chapter07;

import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_3")
public class exam07_3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("연결");
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/fileupload03.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String save = req.getServletContext().getRealPath("img");
		System.out.println(save);
		
		DiskFileUpload upload = new DiskFileUpload();
		
		List items;
		try 
		{
			items = upload.parseRequest(req);
			Iterator params = items.iterator();
			while(params.hasNext()) 
			{
				FileItem fileItem = (FileItem)params.next();
				if(!fileItem.isFormField())
				{
					String fileName = fileItem.getName();
					fileName = fileName.substring(fileName.lastIndexOf("//") + 1);
					File file = new File(save + "/" +fileName);
					fileItem.write(file);
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			RequestDispatcher ds = req.getRequestDispatcher("chapter07/fileupload03.jsp");
			ds.forward(req, resp);
		}
		
		
	}

}
