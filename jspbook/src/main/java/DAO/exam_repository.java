package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.exam_DTO;

public class exam_repository 
{
	private static exam_repository er = new exam_repository();
	public static exam_repository getInstance()
	{
		return er;
	}
	
	public Connection DBconn()
	{
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspbookdb";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
		}
		catch (Exception e) 
		{
			System.out.println("데이터베이스 연결 실패");
		}
		return conn;
	}
	public void insert_member(exam_DTO dto)
	{
		try {
		//DB연결
		Connection conn = DBconn();

		//sql 작성 및 보내기		
		Statement stmt = conn.createStatement();
		String id = dto.getId();
		String pw = dto.getPassword();
		String name = dto.getName();
		
		String sql = "insert into member value('"+id+"', '"+pw+"', '"+name+"')";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
		 	
		// ResultSet 보내기
		} 
		catch (SQLException e){System.out.println(e.getMessage());}
	}
	public void insert_member_2(exam_DTO dto)
	{
		// DB 연결
		Connection conn = DBconn();
		// sql 전송
		
		try 
		{
			String id = dto.getId();
			String pw = dto.getPassword();
			String name = dto.getName();
			
			String sql = "insert into member values(?, ? ,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			
			pstmt.executeUpdate();
		// ResultSet 수신
			
			pstmt.close();
			conn.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
		
	}
	public ArrayList<exam_DTO> readall()
	{
		System.out.println("readall 연결");
		//DB연결
		Connection conn = DBconn();
		
		//Statement 객체생성 및 sql 전송
		ArrayList<exam_DTO> arr = new ArrayList<exam_DTO>();
		try 
		{
			System.out.println("step2 진행");
			String sql = "select * from member";
			Statement pstmt = conn.prepareStatement(sql);
		// ResultSet 수신
			System.out.println("step 3");
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next())
			{
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				exam_DTO dto = new exam_DTO();
				dto.setId(id);
				dto.setPassword(pw);
				dto.setName(name);
				
				arr.add(dto);
			}		
			rs.close();
			pstmt.close();
			conn.close();
		}
		catch (SQLException e){System.out.println(e.getMessage());}
		return arr;
	}
	public exam_DTO before_update_member(String id)
	{
		System.out.println("update member");
		//DB연결
		Connection conn = DBconn();
		exam_DTO dto = new exam_DTO();
		try 
		{
			//sql 보내기 및 받기
			String sql = "select * from member where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs;
				rs = pstmt.executeQuery();
			
			//ResultSet 조리하기
			if(rs.next())
			{
				System.out.println(rs.getString("id") + " / " + rs.getString("pw") + " / " + rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("pw"));
				dto.setName(rs.getString("name"));
			}
		} 
		catch (SQLException e) {e.printStackTrace();}
		return dto;
	}
	public void update_member(exam_DTO dto)
	{
		// db연결
		Connection conn = DBconn();
		try 
		{
		// sql 전송 및 수신
			String id = dto.getId();
			String pw = dto.getPassword();
			String name = dto.getName();
			
			String sql = "update member set pw = ?, name = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, id);
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {e.printStackTrace();}
		// ResultSet 처리
	}
}