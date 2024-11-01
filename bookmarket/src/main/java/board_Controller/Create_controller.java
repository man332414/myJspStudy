package board_Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class Create_controller extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Board Create_Controller의 doGet()입장");
      //전처리
      HttpSession session = req.getSession(false);
      RequestDispatcher rs=null;
//      System.out.println(session);
      //모델이동
      //뷰이동
      if(session != null) 
      {
    	  if(session.getAttribute("member") == null)
    	  {
    		  System.out.println("세션존재 멤버 없음 이동한다");
    		  rs = req.getRequestDispatcher("member_login");
    	  }
    	  else 
    	  {
    		  rs = req.getRequestDispatcher("writeForm.jsp");
    	  }
      }
      else
      {
    	  rs = req.getRequestDispatcher("member_login");
      }
      rs.forward(req, resp);
      
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Create_Controller의 doPost() method");
      //전처리
      HttpSession session = request.getSession(false);
      Member mb = (Member)session.getAttribute("member");
      String id = mb.getId();
      String name = request.getParameter("name");
      String subject = request.getParameter("subject");
      String content = request.getParameter("content");
      Date currentDatetime = new Date(System.currentTimeMillis());
      Date sqlDate = new Date(currentDatetime.getTime());
      Timestamp regiset_day = new Timestamp(currentDatetime.getTime());
      
      int hit = 0;
      
      String ip = request.getRemoteAddr();
      
      Board bd = new Board();
      
      bd.setId(id);
      bd.setName(name);
      bd.setSubject(subject);
      bd.setContent(content);
      bd.setRegist_day(regiset_day);
      bd.setHit(hit);
      bd.setIp(ip);
      
      //모델이동
      BoardRepository br = BoardRepository.getBr();
      br.create(bd);
      //뷰이동 : CUD는 보여줄 뷰어가 없음
      resp.sendRedirect("BoardListAction?pageNum=1");
   }
}
