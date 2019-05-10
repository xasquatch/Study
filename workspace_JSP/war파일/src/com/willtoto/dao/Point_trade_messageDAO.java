package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.willtoto.dto.Point_trade_messageDTO;


public class Point_trade_messageDAO {
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";
	
	public Point_trade_messageDAO() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean messageWrite(String message_id, String message) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into point_trade_message(id, message) values(?,?)";

			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message_id);
			pstmt.setString(2, message);
			pstmt.executeUpdate();
			
			
			return true;
			
		} catch (Exception e) {
			return false;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Point_trade_messageDTO> messageSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Point_trade_messageDTO> arry = new ArrayList<Point_trade_messageDTO>();
		try {
			String sql = "select * from point_trade_message order by message_time desc limit 5";

			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String message = rs.getString("message");
				Point_trade_messageDTO dto = new Point_trade_messageDTO(id, message, null);
				arry.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arry;
	}
	
	
}
