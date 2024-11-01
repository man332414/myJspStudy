package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Board;

public class BoardRepository 
{
	private static BoardRepository br = new BoardRepository();
	BoardRepository(){}

	public static BoardRepository getBr() 
	{
		return br;
	}
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;
	
	Connection DBconn() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bookmarketDB";
		String root = "root";
		String passwd = "1234";
		conn = DriverManager.getConnection(url, root, passwd);
		System.out.println("DB연결이 성공했습니다.");
		
		return conn;
	}
	
	// 행의 갯수를 리턴함
	public int getTotalCount() 
	{
		int count = 0;
		//dB 연결
		System.out.print("getTotalCount : ");
		try 
		{
			conn = DBconn();
		// query 전송
			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			
		// ResultSet
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch (Exception e) {e.printStackTrace();}
		return count;
	}	
	
	//create
	public void create(Board bd)
	{
		System.out.println("create 입장");
		//데베 연결
		try 
		{
			conn = DBconn();
		//쿼리전송
			String sql = "insert into board(id, name, subject, content, regist_day, hit, ip) values(?, ?, ?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getId());
			pstmt.setString(2, bd.getName());
			pstmt.setString(3, bd.getSubject());
			pstmt.setString(4, bd.getContent());
			pstmt.setTimestamp(5, bd.getRegist_day());
			pstmt.setInt(6, bd.getHit());
			pstmt.setString(7, bd.getIp());
			
			pstmt.executeUpdate();
		//resultset 없음
		} 
		catch (Exception e) {e.printStackTrace();}
	}
	
	//read All
	public ArrayList<Board> getAllContents() 
	{
		System.out.print("getAllContents 입장");
		ArrayList<Board> arr = new ArrayList<Board>();
		try 
		{
			// DB연결
			conn = DBconn();
			// sql 전송
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// ResultSet 작성
			while(rs.next())
			{
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegist_day(rs.getTimestamp("regist_day"));
				board.setHit(rs.getInt("hit"));
				board.setIp(rs.getString("ip"));
				
				arr.add(board);
			}
			
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}
		catch (Exception e) {e.printStackTrace();}
		return arr;
	}

}
