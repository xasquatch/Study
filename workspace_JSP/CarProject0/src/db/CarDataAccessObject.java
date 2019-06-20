package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CarDataAccessObject {
	
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getCon() {
		try {
			//1.WAS서버와 연결된 웹프로젝트에 컨텍스트 정보를 가지고 있는 컨텍스트 객체 생성(naming패키지)
			Context init = new InitialContext();
			//2.연결된  WAS서버에서 DataSource(커넥션풀) 검색해서 얻기
			ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");
			//3.DataSource(커넥션풀)에서 DB연동객체(커넥션) 얻기
			con = ds.getConnection();
			
		} catch (Exception e) {
			System.out.println("connection Fail");
			e.printStackTrace();
		}
	}
	
	public Vector<CarListBean> getAllCarList() {
		getCon();
		String sql = "";
		Vector<CarListBean> v = new Vector<CarListBean>();
		CarListBean bean = null;
		
		try {
			sql = "SELECT * FROM carlist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bean = new CarListBean();
				
				bean.setCarno(rs.getInt(1));
				bean.setCarname(rs.getString(2));
				bean.setCarcompany(rs.getString(3));
				bean.setCarprice(rs.getInt(4));
				bean.setCarusepeople(rs.getInt(5));
				bean.setCarinfo(rs.getString(6));
				bean.setCarimg(rs.getString(7));
				bean.setCarcategory(rs.getString(8));
				
				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return v;
	}

	public Vector<CarListBean> getCarList(String carcategory) {
		
		getCon();
		Vector<CarListBean> v = new Vector<>();
		String sql = "";
		CarListBean bean = null;
		
		try {
			sql="SELECT * FROM carlist WHERE Carcategory = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carcategory);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1));
				bean.setCarname(rs.getString(2));
				bean.setCarcompany(rs.getString(3));
				bean.setCarprice(rs.getInt(4));
				bean.setCarusepeople(rs.getInt(5));
				bean.setCarinfo(rs.getString(6));
				bean.setCarimg(rs.getString(7));
				bean.setCarcategory(rs.getString(8));
				
				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return v;
	}

	public CarListBean getOneCar(int carno) {
		
		getCon();
		String sql = "";
		CarListBean bean = new CarListBean();
		try {
			sql = "SELECT * FROM carlist WHERE carno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, carno);
			rs = pstmt.executeQuery();
			
			rs.next();
			bean.setCarno(rs.getInt(1));
			bean.setCarname(rs.getString(2));
			bean.setCarcompany(rs.getString(3));
			bean.setCarprice(rs.getInt(4));
			bean.setCarusepeople(rs.getInt(5));
			bean.setCarinfo(rs.getString(6));
			bean.setCarimg(rs.getString(7));
			bean.setCarcategory(rs.getString(8));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}
	
	
	
	
	
	
}
