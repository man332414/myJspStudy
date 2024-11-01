package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import DTO.dto;

public class repository 
{
	private static repository rp = new repository();
	public static repository getRp() {
		return rp;
	}
	private repository() {}
	
	public void create(dto dto)
	{
		//DB연결
		try 
		{
			Class.forName("java.jdbc.mysql.Driver");
			String url = "jdbc:mysql://localhost:3306/test1";
			String root = "root";
			String passwd = "1234";
		
			Connection conn = DriverManager.getConnection(url, root, passwd);
			//쿼리 전송
			//resultset
		} 
		catch (Exception e) {e.printStackTrace();}
	}
	
}
