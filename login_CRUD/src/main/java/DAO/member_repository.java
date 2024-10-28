package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.member_DTO;

public class member_repository 
{
	//1개만 존재해야 하므로 싱글턴으로 작성
	private static member_repository mr = new member_repository();
	// static으로 미리 객체생성
	public static member_repository getInstance()
	{
		return mr;
		//생성한 객체 호출함수로 다른 자바코드에서 생성된 객체를 받아서 쓸 수 있음
	}
	
	//데이터베이스 연결 메서드
	private Connection DBconn() throws Exception
	{
			// step 1 : JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// step 2 : Connection 객체 생성
			Connection conn = null;
			String database = "jdbc:mysql://localhost:3306/login_CRUD";
			String id = "root";
			String password = "1234";
			conn = DriverManager.getConnection(database, id, password);
//		System.out.println(conn);
			System.out.println("데이터 베이스 연결 완료");
			return conn;
	}
	
	//Create
	public void member_create(member_DTO dto)
	{
		try 
		{
			Connection conn = DBconn();
			// step 3 : SQL 전송객체 생성 및 전송
			//SQL 쿼리 전송 : 데이터베이스에 데이터를 삽입하는 절차
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String pw = dto.getPw();
			int age = dto.getAge();
			// "insert into member values('admin', '1234', age)";워크벤치에서 테스트 실행
			// "insert into member values('userid', 'pw', age)";
			// "insert into member values('"+userid
			// userid + "', '"+pw
			// pw +"', "+age
			// age + ")"
			String sql = "insert into member values('"+userid+"', '"+pw+"', "+age+")";
//			String sql2 = "insert into member values('"
//					+ userid
//					+ "', '"
//					+ pw
//					+ "', "
//					+ age
//					+ ")";
			stmt.executeUpdate(sql);			
			
			// step 4 Read 해오기
		} 
		catch (Exception e){System.out.println("데이터 베이스 연결 오류");}
		
		
		// step 4 : DBMS 리턴이 있으면 ResultSet 객체에 담기 - CUD는 해당 없음
	}
	//Read
	public ArrayList<member_DTO> getAllmember()
	{
		ArrayList<member_DTO> arr = new ArrayList<member_DTO>();
		try 
		{
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			// step 3 : SQL 전송객체 생성 및 전송
			ResultSet rs = null;
			String sql = "select * from member";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{                // column명
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				
				member_DTO dto = new member_DTO();
				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
				/*
	 				dto.setId(re.getString("id"));
					dto.setPw(re.getString("pw"));
					dto.setAge(re.getInt("age"));
				 */
				arr.add(dto);
			}
		}
		catch (Exception e){System.out.println("데이터 베이스 연결 오류");}
		return arr;
	}
	//Update
	public member_DTO getOnemember(String userid)
	{
		ResultSet rs = null;
		member_DTO dto = new member_DTO();
		try 
		{
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			//step 2 : Query 전송 및 편집
			String sql = "select * from member where id = '"+userid+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
			}
		}
		catch (Exception e) {e.printStackTrace();}
		
		return dto;
	}
	public void updatemember(member_DTO dto)
	{
		try 
		{
			// step1. DB 연결
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			// step2. Query문 작성
			String sql = "update member set pw = '"+dto.getPw()+"', age = "+dto.getAge()+" where id = '"+dto.getId()+"'";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {e.printStackTrace();}
	}
	//Delete
	public void deleteuser(String id)
	{
		try 
		{
			//step 1 DB연결
			Connection conn = DBconn();
			//step 2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "delete from member where id = '"+id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {e.printStackTrace();}
	}
}
