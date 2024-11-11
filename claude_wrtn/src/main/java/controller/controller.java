// MemberController.java: 회원 관련 요청을 처리하는 서블릿 클래스
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
                
                String password = request.getParameter("password");
                if (password == null || password.length() < 6) { // 비밀번호 유효성 검증
                    request.setAttribute("error", "비밀번호는 6자 이상이어야 합니다.");
                    request.getRequestDispatcher("/WEB-INF/views/member/form.jsp")
                           .forward(request, response);
                    return;
                }
                
                newMember.setPassword(password); // 비밀번호 설정
                newMember.setName(request.getParameter("name"));
                newMember.setEmail(request.getParameter("email"));
                newMember.setPhone(request.getParameter("phone"));
                
                if (memberDAO.insertMember(newMember)) {
                    response.sendRedirect(request.getContextPath() + "/member/list");
                } else {
                    request.setAttribute("error", "회원 등록에 실패했습니다."); // 보다 구체적인 에러 메시지
                    request.setAttribute("member", newMember); // 입력했던 정보 유지
                    request.getRequestDispatcher("/WEB-INF/views/member/form.jsp") // 폼 JSP로 포워딩
                           .forward(request, response);
                }
                break;
                
            case "/update":
                Member updateMember = new Member();
                updateMember.setId(Integer.parseInt(request.getParameter("id")));
                updateMember.setUsername(request.getParameter("username"));
                
                String updatePassword = request.getParameter("password");
                if (updatePassword != null && updatePassword.length() < 6) { // 비밀번호 유효성 검증
                    request.setAttribute("error", "비밀번호는 6자 이상이어야 합니다.");
                    request.setAttribute("member", updateMember); // 수정할 회원 정보 유지
                    request.getRequestDispatcher("/WEB-INF/views/member/form.jsp") // 폼 JSP로 포워딩
                           .forward(request, response);
                    return;
                }
                
                if (updatePassword != null && !updatePassword.isEmpty()) {
                    updateMember.setPassword(updatePassword); // 새로운 비밀번호 설정
                } else {
                    updateMember.setPassword(memberDAO.getMember(updateMember.getId()).getPassword()); // 기존 비밀번호 유지
                }
                
                updateMember.setName(request.getParameter("name"));
                updateMember.setEmail(request.getParameter("email"));
                updateMember.setPhone(request.getParameter("phone"));
                
                if (memberDAO.updateMember(updateMember)) {
                    response.sendRedirect(request.getContextPath() + "/member/view?id=" + updateMember.getId());
                } else {
                    request.setAttribute("error", "회원 정보 수정에 실패했습니다."); // 에러 메시지 설정
                    request.setAttribute("member", updateMember); // 입력했던 정보 유지
                    request.getRequestDispatcher("/WEB-INF/views/member/form.jsp") // 폼 JSP로 포워딩
                           .forward(request, response);
                }
                break;
                
            case "/delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                if (memberDAO.deleteMember(deleteId)) {
                    response.sendRedirect(request.getContextPath() + "/member/list");
                } else {
                    request.setAttribute("error", "회원 삭제에 실패했습니다."); // 에러 메시지 설정
                    response.sendRedirect(request.getContextPath() + "/member/view?id=" + deleteId); // 상세보기 페이지로 리다이렉트
                }
                break;
        }
    }
}
