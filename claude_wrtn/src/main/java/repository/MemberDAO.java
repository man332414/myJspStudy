// MemberDAO.java: 데이터베이스와의 상호작용을 처리하는 클래스
// 이 클래스는 회원 정보를 CRUD(생성, 읽기, 수정, 삭제)하는 메서드를 제공합니다.
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DTO.Member;
import org.mindrot.jbcrypt.BCrypt; // BCrypt 라이브러리 추가

public class MemberDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // 드라이버 로드 실패 시 에러 출력
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/memberdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root"; // DB 사용자명
        String password = "1234"; // DB 비밀번호
        return DriverManager.getConnection(url, user, password); // 데이터베이스 연결 반환
    }

    public boolean insertMember(Member member) {
        String sql = "INSERT INTO members (username, password, name, email, phone) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            conn.setAutoCommit(false); // 트랜잭션 시작
            pstmt.setString(1, member.getUsername());
            String hashedPassword = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt()); // 비밀번호 해시화
            pstmt.setString(2, hashedPassword); // 해시된 비밀번호 저장
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getPhone());
            
            boolean result = pstmt.executeUpdate() > 0; // 쿼리 실행 후 성공 여부
            conn.commit(); // 트랜잭션 커밋
            return result;
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류 발생 시 에러 출력
            return false; // 실패 반환
        }
    }

    public Member getMember(int id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password")); // 해시된 비밀번호 반환
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setCreatedAt(rs.getTimestamp("created_at"));
                member.setUpdatedAt(rs.getTimestamp("updated_at"));
                return member;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        
        try (Connection conn = getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password")); // 해시된 비밀번호 반환
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setCreatedAt(rs.getTimestamp("created_at"));
                member.setUpdatedAt(rs.getTimestamp("updated_at"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public boolean updateMember(Member member) {
        String sql = "UPDATE members SET username=?, password=?, name=?, email=?, phone=? WHERE id=?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            conn.setAutoCommit(false); // 트랜잭션 시작
            pstmt.setString(1, member.getUsername());
            String hashedPassword = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt()); // 비밀번호 해시화
            pstmt.setString(2, hashedPassword); // 해시된 비밀번호 저장
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getPhone());
            pstmt.setInt(6, member.getId());
            
            boolean result = pstmt.executeUpdate() > 0; // 쿼리 실행 후 성공 여부
            conn.commit(); // 트랜잭션 커밋
            return result;
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류 발생 시 에러 출력
            return false; // 실패 반환
        }
    }

    public boolean deleteMember(int id) {
        String sql = "DELETE FROM members WHERE id=?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            conn.setAutoCommit(false); // 트랜잭션 시작
            pstmt.setInt(1, id);
            boolean result = pstmt.executeUpdate() > 0; // 쿼리 실행 후 성공 여부
            conn.commit(); // 트랜잭션 커밋
            return result;
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류 발생 시 에러 출력
            return false; // 실패 반환
        }
    }
}
