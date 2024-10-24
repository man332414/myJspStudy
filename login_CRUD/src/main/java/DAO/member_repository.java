package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import DTO.member_DTO;

public class member_repository 
{
	//1개만 존재해야 하므로 싱글턴으로 작성
	private static member_repository mr = new member_repository();
	public static member_repository getInstance()
	{
		return mr;
	}
	
	//Create
	public void member_create(member_DTO dto)
	{
		try 
		{
			// step 1 : JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// step 2 : Connection 객체 생성
			Connection conn = null;
			String database = "jdbc:mysql://localhost:3306/login_CRUD";
			String id = "root";
			String password = "1234";
			conn = DriverManager.getConnection(database, id, password);
			System.out.println(conn);
			System.out.println("데이터 베이스 연결 완료");
		} 
		catch (Exception e){System.out.println("데이터 베이스 연결 오류");}
		
		// step 3 : SQL 전송객체 생성 및 전송
		
		// step 4 : DBMS 리턴이 있으면 ResultSet 객체에 담기 - CUD는 해당 없음
	}
	//Read
	//Update
	//Delete
}
