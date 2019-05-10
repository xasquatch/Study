package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.willtoto.dto.MemberDTO;
import com.willtoto.dto.ReplyDTO;

public class ReplyDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";
	
	public ReplyDAO() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void DBClose(){
		try{
		if(rs != null){ rs.close();}
		if(pstmt != null){ pstmt.close();}
		if(con != null){ con.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public int write(int num, MemberDTO dto, String reply_write){
		int check = 0;
		try{
			int replyNum = max(num);
			if(replyNum == 0){
				replyNum = 1;
			}else{
				replyNum++;
			}
			
			con = DriverManager.getConnection(url, uid, upw);
			sql = "insert into reply(num, replyNum, id, replyWrite) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, replyNum);
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, reply_write);
			check = pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBClose();
			}
		return check;
	}
	
	public ArrayList<ReplyDTO> repleView(int num){
		ArrayList<ReplyDTO> dtos = new ArrayList<ReplyDTO>();
		sql = "select * from reply where num=? order by date asc";
		try{
			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ReplyDTO dto = new ReplyDTO();
				dto.setNum(rs.getInt("num"));
				dto.setReplyNum(rs.getInt("replyNum"));
				dto.setId(rs.getString("id"));
				dto.setReplyWrite(rs.getString("replyWrite"));
				SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
				String time = format.format(rs.getTimestamp("date"));
				dto.setDate(time);
				dtos.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return dtos;
	}
	
	public int count(int num){
		sql = "select count(*) from reply where num=?" ;
		int count = 0;
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return count;
	}
	
	public int max(int num){
		sql = "select max(replyNum) from reply where num=?";
		int count = 0;
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return count;
	}
	
	public int delete(int num, int replyNum, MemberDTO dto){
		int check = 0;
		sql = "delete from reply where num=? and replyNum=? and id=?";
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setInt(2, replyNum);
		pstmt.setString(3, dto.getId());
		check = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return check;
	}
	
	public int update(int num, int replyNum, String update_reply_write, MemberDTO dto){
		int check = 0;
		sql = "update reply set replywrite=? where num=? and replyNum=? and id=?";
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, update_reply_write);
		pstmt.setInt(2, num);
		pstmt.setInt(3, replyNum);
		pstmt.setString(4, dto.getId());
		check = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return check;
	}
	
}
