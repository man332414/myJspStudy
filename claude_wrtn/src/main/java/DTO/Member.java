// Member.java: 회원 정보를 저장하기 위한 DTO 클래스
// 이 클래스는 회원의 ID, 사용자명, 비밀번호, 이름, 이메일, 전화번호, 생성일 및 수정일을 저장합니다.
package DTO;

import java.sql.Timestamp;

public class Member {
    private int id; // 회원 ID
    private String username; // 사용자명
    private String password; // 비밀번호
    private String name; // 이름
    private String email; // 이메일
    private String phone; // 전화번호
    private Timestamp createdAt; // 생성일
    private Timestamp updatedAt; // 수정일

    // Getter 및 Setter 메서드
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
}
