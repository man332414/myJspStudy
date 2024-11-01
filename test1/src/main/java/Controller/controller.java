package Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.repository;
import DTO.dto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/2_1")
public class controller extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("utf-8");
		String save = req.getServletContext().getRealPath("./image");
		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		String id = multi.getParameter("id");
		String name = multi.getParameter("name");
		String pw = multi.getParameter("pw");
		String filename = multi.getFilesystemName("filename");
		
		dto dto = new dto();
		
		dto.setId(id);
		dto.setName(filename);
		dto.setPw(pw);
		dto.setFilename(filename);
		//모델이동
		repository rp = repository.getRp();
		rp.create(dto);
		//뷰 이동
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
