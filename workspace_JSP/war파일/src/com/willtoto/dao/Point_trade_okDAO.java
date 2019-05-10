package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.willtoto.dto.Point_trade_okDTO;


public class Point_trade_okDAO {
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";
	
	public Point_trade_okDAO() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Point_trade_okDTO> trade_ok_Select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Point_trade_okDTO> arry = new ArrayList<Point_trade_okDTO>();
		try {
			String sql = "select * from point_trade_ok order by send_time desc limit 3";

			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String myid = rs.getString("myid");
				String send_id = rs.getString("send_id");
				long send_point = rs.getLong("send_point");
				Point_trade_okDTO dto = new Point_trade_okDTO(myid, send_id, send_point, null);
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
				}
				if (rs != null){
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arry;
	}
	
	
}
