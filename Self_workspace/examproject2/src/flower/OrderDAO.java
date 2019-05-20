package flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void getCon() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/bjb_db");
			con = ds.getConnection();

		} catch (Exception e) {
			System.out.println("DB연결실패!");
		}
	}
	
	
	public void insertOrder(OrderDTO odto) {
		try {
			getCon();
			String sql = "insert into flowerorder "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odto.getOrderno());
			pstmt.setTimestamp(2, odto.getOrderdate());
			pstmt.setInt(3, odto.getFlowerno());
			pstmt.setString(4, odto.getFlowername());
			pstmt.setString(5, odto.getFlowerimg());
			pstmt.setInt(6, odto.getFlowerqty());
			pstmt.setInt(7, odto.getFlowerprice());
			pstmt.setString(8, odto.getFlowercategory());
			pstmt.setString(9, odto.getMemberid());
			pstmt.setString(10, odto.getMembername());
			pstmt.setString(11, odto.getMemberphone());
			pstmt.setInt(12, odto.getMemberpostcode());
			pstmt.setString(13, odto.getMemberaddress());
			pstmt.setString(14, odto.getMemberaddress2());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertOrder() : " + e);
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

	}
	
	
	public Vector<OrderDTO> getOrderlist(String id) {
		Vector<OrderDTO> v = new Vector<OrderDTO>();
		OrderDTO odto = null;

		try {
			getCon();
			String sql = "select * from flowerorder where memberid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				odto = new OrderDTO();
				odto.setOrderno(rs.getInt("orderno"));
				odto.setOrderdate(rs.getTimestamp("orderdate"));
				odto.setFlowerno(rs.getInt("flowerno"));
				odto.setFlowername(rs.getString("flowername"));
				odto.setFlowerimg(rs.getString("flowerimg"));
				odto.setFlowerqty(rs.getInt("flowerqty"));
				odto.setFlowerprice(rs.getInt("flowerprice"));
				odto.setFlowercategory(rs.getString("flowercategory"));
				odto.setMemberid(rs.getString("memberid"));
				odto.setMembername(rs.getString("membername"));
				odto.setMemberphone(rs.getString("memberphone"));
				odto.setMemberpostcode(rs.getInt("memberpostcode"));
				odto.setMemberaddress(rs.getString("memberaddress"));
				odto.setMemberaddress2(rs.getString("memberaddress2"));
				
				v.add(odto);
			}
		} catch (Exception err) {
			System.out.println("getOrderlist() :" + err);
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
	
	public int deleteOrder(int num){
		int check = 0;
		try {
			getCon();
			String sql = "delete from flowerorder where orderno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			check = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return check;
		
	}
	

	
	
}
