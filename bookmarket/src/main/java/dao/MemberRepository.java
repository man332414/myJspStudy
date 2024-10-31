package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberRepository 
{
	private static MemberRepository mr = new MemberRepository();
	private MemberRepository() {}
	public static MemberRepository getMr() {
		return mr;
	}
	
	//DB 연결
	Connection DBconn() throws Exception
	{
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bookmarketDB";
		String root = "root";
		String passwd = "1234";
		conn = DriverManager.getConnection(url, root, passwd);
		System.out.println("DB연결이 성공했습니다.");
		
		return conn;
	}
	//c
	public void create(Member mb) 
	{
		//database 연결
		try 
		{
			Connection conn = DBconn();
			//sql 전송
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getGender());
			pstmt.setString(5, mb.getBirth());
			pstmt.setString(6, mb.getMail());
			pstmt.setString(7, mb.getPhone());
			pstmt.setString(8, mb.getAddress());
			pstmt.setTimestamp(9, mb.getRegist_day());
			pstmt.executeUpdate();
			
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		
		//ResultSet
		}
		catch (Exception e) {e.printStackTrace();}
	}
	//r
	//u
	//d
	public Member getUesr(String id, String password) 
	{
		Member returnData = new Member();				
		//DB 연결
		try 
		{
			Connection conn = DBconn();
			//sql 작성
			String sql = "select * from member where id=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//ResultSet 변환 -> DTO
			ResultSet re = pstmt.executeQuery();
			if(re.next())
			{
				returnData.setId(re.getString("id"));
				returnData.setPassword(re.getString("password"));
				returnData.setName(re.getString("name"));
				returnData.setGender(re.getString("gender"));
				returnData.setBirth(re.getString("birth"));
				returnData.setMail(re.getString("mail"));
				returnData.setPhone(re.getString("phone"));
				returnData.setAddress(re.getString("address"));
				returnData.setRegist_day(re.getTimestamp("regist_day"));
			}
			if(re!=null) {re.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		}
		catch (Exception e) {e.printStackTrace();}
		return returnData;
	}
}
