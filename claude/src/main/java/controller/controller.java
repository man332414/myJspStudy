// MemberController.java
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DTO.Member;
import repository.MemberDAO;


@WebServlet("/member/*")
public class controller extends HttpServlet {
    private MemberDAO memberDAO;

    public void init() {
        memberDAO = new MemberDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        switch(pathInfo) {
            case "/list":
                request.setAttribute("members", memberDAO.getAllMembers());
                request.getRequestDispatcher("/WEB-INF/views/member/list.jsp")
                       .forward(request, response);
                break;
                
            case "/view":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("member", memberDAO.getMember(id));
                request.getRequestDispatcher("/WEB-INF/views/member/view.jsp")
                       .forward(request, response);
                break;
                
            case "/form":
                String memberId = request.getParameter("id");
                if (memberId != null) {
                    // 수정 모드: 기존 회원 정보를 폼에 표시
                    Member member = memberDAO.getMember(Integer.parseInt(memberId));
                    request.setAttribute("member", member);
                }
                request.getRequestDispatcher("/WEB-INF/views/member/form.jsp")
                       .forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        switch(pathInfo) {
            case "/create":
                Member newMember = new Member();
                newMember.setUsername(request.getParameter("username"));
                newMember.setPassword(request.getParameter("password"));
                newMember.setName(request.getParameter("name"));
                newMember.setEmail(request.getParameter("email"));
                newMember.setPhone(request.getParameter("phone"));
                
                if (memberDAO.insertMember(newMember)) {
                    response.sendRedirect(request.getContextPath() + "/member/list");
                } else {
                    request.setAttribute("error", "회원 등록에 실패했습니다.");
                    request.setAttribute("member", newMember); // 입력했던 정보 유지
                    request.getRequestDispatcher("/WEB-INF/views/member/form.jsp")
                           .forward(request, response);
                }
                break;
                
            case "/update":
                Member updateMember = new Member();
                updateMember.setId(Integer.parseInt(request.getParameter("id")));
                updateMember.setUsername(request.getParameter("username"));
                updateMember.setPassword(request.getParameter("password"));
                updateMember.setName(request.getParameter("name"));
                updateMember.setEmail(request.getParameter("email"));
                updateMember.setPhone(request.getParameter("phone"));
                
                if (memberDAO.updateMember(updateMember)) {
                    response.sendRedirect(request.getContextPath() + "/member/view?id=" + updateMember.getId());
                } else {
                    request.setAttribute("error", "회원 정보 수정에 실패했습니다.");
                    request.setAttribute("member", updateMember);
                    request.getRequestDispatcher("/WEB-INF/views/member/form.jsp")
                           .forward(request, response);
                }
                break;
                
            case "/delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                if (memberDAO.deleteMember(deleteId)) {
                    response.sendRedirect(request.getContextPath() + "/member/list");
                } else {
                    request.setAttribute("error", "회원 삭제에 실패했습니다.");
                    response.sendRedirect(request.getContextPath() + "/member/view?id=" + deleteId);
                }
                break;
        }
    }
}