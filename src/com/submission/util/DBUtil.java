package com.submission.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;



public class DBUtil {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/submission";
	private static final String USER="root";
	private static final String PASSWORD="123";
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public Connection getConn(){
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;	
	}
	//增删改
	public int execUpdate(String sql ,Object...param){
		int num = 0;
		try {
			Connection conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for(int i =0;i<param.length;i++){
				pstmt.setObject(i+1, param[i]);
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return num;
	}
	//增删改
	public int execUpdateBackId(String sql ,Object...param){
		int num = 0;
		int mid = 0;
		try {
			Connection conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for(int i =0;i<param.length;i++){
				pstmt.setObject(i+1, param[i]);
			}
			num = pstmt.executeUpdate();
			if (num > 0) {
				String sql1 = "SELECT LAST_INSERT_ID() ";
				pstmt = conn.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				try {
					if(rs.next()) {
						mid = rs.getInt(1);
						if (mid >0) {
							closeAll();
							return mid;
						}
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return num;
	}
	//查
	public ResultSet execQuery(String sql ,Object...param){
		try {
			Connection conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for(int i =0;i<param.length;i++){
				pstmt.setObject(i+1, param[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs; 
	}
	
	public void closeAll(){
		
			try {
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
}
