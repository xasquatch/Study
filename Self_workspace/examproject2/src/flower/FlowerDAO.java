package flower;

import java.sql.*;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import flower.FlowerDTO;

public class FlowerDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void getCon() {
		try {
			Context init = new InitialContext();

			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/bjb_db");

			con = ds.getConnection(); 

		} catch (Exception e) { 
			System.out.println("DB연결실패");
		}
	}
	
	
	public Vector<FlowerDTO> getFlowerlist() {
		Vector<FlowerDTO> v = new Vector<FlowerDTO>();
		FlowerDTO dto = null;

		try {
			getCon();
			String sql = "select * from flower";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new FlowerDTO();
				dto.setNum(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setImg(rs.getString(4));
				dto.setCategory(rs.getString(5));
				boolean result = v.add(dto);
			}

		} catch (Exception err) {
			System.out.println("getFlowerlist():" + err);
		} finally {

			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 

		return v;
	}
	
	
	public FlowerDTO getFlower(int num) {
		FlowerDTO fdto = null;

		try {
			getCon();
			String sql = "select * from flower where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			rs.next();
			fdto = new FlowerDTO();
			fdto.setNum(rs.getInt("num"));
			fdto.setName(rs.getString("name"));
			fdto.setPrice(rs.getInt("price"));
			fdto.setImg(rs.getString("img"));
			fdto.setCategory(rs.getString("category"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return fdto;
	}
	
	

}
