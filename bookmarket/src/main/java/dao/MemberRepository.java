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
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	//DB 연결
	Connection DBconn() throws Exception
	{
		conn = null;
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
			conn = DBconn();
			//sql 전송
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
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
	public Member getUesr(String id, String password) 
	{
		Member returnData = new Member();				
		//DB 연결
		try 
		{
			conn = DBconn();
			//sql 작성
			String sql = "select * from member where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			
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

	public Member readOneById(String id) 
	{
		// db연결
		System.out.print("readOneById 함수 : ");
		Member mb = new Member();
		try 
		{
			conn = DBconn();
			
			// sql 작성
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			// ResultSet 제어
			if(rs.next())
			{
				mb.setId(rs.getString("id"));
				mb.setPassword(rs.getString("password"));
				mb.setName(rs.getString("name"));
				mb.setGender(rs.getString("gender"));
				mb.setBirth(rs.getString("birth"));
				mb.setMail(rs.getString("mail"));
				mb.setPhone(rs.getString("phone"));
				mb.setAddress(rs.getString("address"));
			}
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {rs.close();}
			if(conn!=null) {conn.close();}
		}
		catch (Exception e) {e.printStackTrace();}
		return mb;
	}

	//u
	public void update(Member mb) 
	{
		//db연결
		System.out.print("update 함수 : ");
		try 
		{
			conn = DBconn();
		//sql 작성
			String sql = "update set password = ?, name = ?  where";
		//resultset 작성
		}
		catch (Exception e) {e.printStackTrace();}
	}
	//d
	
}
