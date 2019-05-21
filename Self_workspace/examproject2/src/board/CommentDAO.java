package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CommentDAO {
	
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/bjb_db");
		Connection con = ds.getConnection();
		
		return con;
		
	} 
			
	// 댓글 추가 메소드		
	public void insertComment(CommentDTO cb){
		int num =  cb.getNum();
		int number =0;
		
		Connection con=null;
		String sql="";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con = getConnection();
			sql="select max(num) as num from comment";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				number=rs.getInt(1)+1;
			}else{
				number=1;
			}
			sql = "insert into comment values(?, ?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, cb.getId());
			pstmt.setString(3, cb.getContent());
			pstmt.setInt(4, cb.getRef());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){};
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){};
			if(con!=null)try{con.close();}catch(SQLException ex){};
		}
	}
	
	// 댓글 불러오기
	public List getBoard(int num){ 
		
		List commentList=new ArrayList();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="";
		ResultSet rs=null;
		try {
			con=getConnection();
			sql="select * from comment where ref=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				CommentDTO cb=new CommentDTO();
				cb.setNum(rs.getInt("num"));
				cb.setId(rs.getString("id"));
				cb.setContent(rs.getString("content"));
				cb.setReg_date(rs.getDate("reg_date"));
				cb.setRef(rs.getInt("ref"));
				commentList.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return commentList;
	} 
	
	
	public int deleteComment(int num){
		int check = 0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql ="";
		
		try {
			con = getConnection();
			sql = "delete from comment where num=?";
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
