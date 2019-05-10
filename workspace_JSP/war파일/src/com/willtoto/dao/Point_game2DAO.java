package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Point_game2DAO {
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public Point_game2DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getGame2ok(int get_point, String my_id) {
		try {
			con = DriverManager.getConnection(url, uid, upw);
			String sql1 = "update member set point=point+? where id=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, get_point);
			pstmt.setString(2, my_id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (con != null) {con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return get_point;
	}
}