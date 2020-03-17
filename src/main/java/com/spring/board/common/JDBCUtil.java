package com.spring.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//DB연동 처리 클래스
public class JDBCUtil {

	//DB 연결 메소드
	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	//DB연결 해제 메소드 
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt !=null) {
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		
		if(conn !=null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		
	}
	
	// DB연결 해제 메소드 (ResultSet 포함) 
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs !=null) {
			try {
				if(!rs.isClosed()) {
					rs.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		
		if(stmt !=null) {
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		
		if(conn !=null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		
	}
}
