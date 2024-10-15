package chapter07;

import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_4")
public class exam07_4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("연결");
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/fileupload04.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String save = req.getServletContext().getRealPath("img");
		DiskFileUpload upload = new DiskFileUpload();
		upload.setRepositoryPath(save);
		
		try 
		{
			List items = upload.parseRequest(req);
			Iterator params = items.iterator();
			int i = 0;
			while(params.hasNext())
			{
				FileItem item = (FileItem) params.next();
				if(item.isFormField())
				{
					String value = item.getString("utf-8");
					req.setAttribute("name"+i, value); //변수 담기
					i++;
				}
				else
				{
					String fileFieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					
					fileName = fileName.substring(fileName.lastIndexOf("//")+1);
					long fileSize = item.getSize();
					req.setAttribute("fileFieldName", fileFieldName);
					req.setAttribute("fileName", fileName);
					req.setAttribute("cotentType", contentType);
					req.setAttribute("fileSize", fileSize);
					
					File file = new File(save + "/" + fileName);
					item.write(file);
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/fileupload04_01.jsp");
		ds.forward(req, resp);
		
	}

}
