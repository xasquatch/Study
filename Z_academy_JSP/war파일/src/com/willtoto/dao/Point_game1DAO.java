package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import com.willtoto.dto.Point_game1DTO;

public class Point_game1DAO {
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	Connection con2 = null;
	ResultSet rs2 = null;
	PreparedStatement pstmt2 = null;

	Connection con3 = null;
	ResultSet rs3 = null;
	PreparedStatement pstmt3 = null;

	Connection con4 = null;
	ResultSet rs4 = null;
	PreparedStatement pstmt4 = null;

	Connection con5 = null;
	ResultSet rs5 = null;
	PreparedStatement pstmt5 = null;

	Connection con6 = null;
	ResultSet rs6 = null;
	PreparedStatement pstmt6 = null;

	Connection con7 = null;
	ResultSet rs7 = null;
	PreparedStatement pstmt7 = null;

	Connection con8 = null;
	ResultSet rs8 = null;
	PreparedStatement pstmt8 = null;

	Connection con9 = null;
	ResultSet rs9 = null;
	PreparedStatement pstmt9 = null;

	public Point_game1DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Point_game1DTO> getGame1() {
		try {
			ArrayList<Point_game1DTO> dtos = new ArrayList<Point_game1DTO>();

			con = DriverManager.getConnection(url, uid, upw);
			String sql = "select * from point_game1ok order by game_time desc limit 3;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String game_id = rs.getString("game_id");
				Timestamp game_time = rs.getTimestamp("game_time");

				SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
				String time = format.format(game_time);
				Point_game1DTO dto = new Point_game1DTO(num, game_id, time);
				dtos.add(dto);
			}
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return null;
	}

	public int getGame1ok(int lotto, int my_point, String my_id) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		Connection con2 = null;
		ResultSet rs2 = null;
		PreparedStatement pstmt2 = null;

		Connection con3 = null;
		ResultSet rs3 = null;
		PreparedStatement pstmt3 = null;

		Connection con4 = null;
		ResultSet rs4 = null;
		PreparedStatement pstmt4 = null;

		Connection con5 = null;
		ResultSet rs5 = null;
		PreparedStatement pstmt5 = null;

		Connection con6 = null;
		ResultSet rs6 = null;
		PreparedStatement pstmt6 = null;

		Connection con7 = null;
		ResultSet rs7 = null;
		PreparedStatement pstmt7 = null;

		Connection con8 = null;
		ResultSet rs8 = null;
		PreparedStatement pstmt8 = null;

		Connection con9 = null;
		ResultSet rs9 = null;
		PreparedStatement pstmt9 = null;

		try {
			con9 = DriverManager.getConnection(url, uid, upw);
			String sql9 = "update member set point=point-1000 where id=?";
			pstmt9 = con9.prepareStatement(sql9);
			pstmt9.setString(1, my_id);
			pstmt9.executeUpdate();

			con2 = DriverManager.getConnection(url, uid, upw);
			String sql2 = "update point_game1 set disabled=1 where num=?";
			pstmt2 = con2.prepareStatement(sql2);
			pstmt2.setInt(1, lotto);
			pstmt2.executeUpdate();

			con = DriverManager.getConnection(url, uid, upw);
			String sql = "select * from point_game1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lotto);
			rs = pstmt.executeQuery();

			con3 = DriverManager.getConnection(url, uid, upw);
			String sql3 = "select disabled from point_game1 where result = 1";
			pstmt3 = con3.prepareStatement(sql3);
			rs3 = pstmt3.executeQuery();
			if (rs3.next()) {
				if (rs3.getInt(1) == 1) {
					con4 = DriverManager.getConnection(url, uid, upw);
					String sql4 = "update point_game1 set disabled=0";
					pstmt4 = con4.prepareStatement(sql4);
					pstmt4.executeUpdate();

					con5 = DriverManager.getConnection(url, uid, upw);
					String sql5 = "update point_game1 set result=0";
					pstmt5 = con5.prepareStatement(sql5);
					pstmt5.executeUpdate();

					Random r = new Random();
					int i = r.nextInt(30) + 1;

					con6 = DriverManager.getConnection(url, uid, upw);
					String sql6 = "update point_game1 set result=1 where num=?";
					pstmt6 = con6.prepareStatement(sql6);
					pstmt6.setInt(1, i);
					pstmt6.executeUpdate();
					if (pstmt6 != null) {
						pstmt6.close();
					}
					if (con6 != null) {
						con6.close();
					}
				}
			}
			if (rs.next()) {
				if (rs.getInt("result") == 1) {

					con7 = DriverManager.getConnection(url, uid, upw);
					String sql7 = "update member set point=point+16000 where id=?";
					pstmt7 = con7.prepareStatement(sql7);
					pstmt7.setString(1, my_id);
					pstmt7.executeUpdate();

					con8 = DriverManager.getConnection(url, uid, upw);
					String sql8 = "insert into point_game1ok(num, game_id) values(?,?)";
					pstmt8 = con8.prepareStatement(sql8);
					pstmt8.setInt(1, lotto);
					pstmt8.setString(2, my_id);
					pstmt8.executeUpdate();

					return 1;
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (con != null) {con.close();}
				
				if (rs2 != null) {rs2.close();}
				if (pstmt2 != null) {pstmt2.close();}
				if (con2 != null) {con2.close();}
				
				if (rs3 != null) {rs3.close();}
				if (pstmt3 != null) {pstmt3.close();}
				if (con3 != null) {con3.close();}
				
				if (rs4 != null) {rs4.close();}
				if (pstmt4 != null) {pstmt4.close();}
				if (con4 != null) {con4.close();}
				
				if (rs5 != null) {rs5.close();}
				if (pstmt5 != null) {pstmt5.close();}
				if (con5 != null) {con5.close();}
				
				if (rs6 != null) {rs6.close();}
				if (pstmt6 != null) {pstmt6.close();}
				if (con6 != null) {con6.close();}
				
				if (rs7 != null) {rs7.close();}
				if (pstmt7 != null) {pstmt7.close();}
				if (con7 != null) {con7.close();}
				
				if (rs8 != null) {rs8.close();}
				if (pstmt8 != null) {pstmt8.close();}
				if (con8 != null) {con8.close();}
				
				if (rs9 != null) {rs9.close();}
				if (pstmt9 != null) {pstmt9.close();}
				if (con9 != null) {con9.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}