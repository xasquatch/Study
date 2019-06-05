package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.willtoto.dto.MemberDTO;


public class MemberDAO {
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";
	
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	public MemberDAO() {
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
	
	public boolean memberjoin(String name, String id, String pw, String e_mail, String find_q, String find_a) {
		try {
			String sql = "insert into member(name, id, pw, e_mail, pass_q, pass_a) values(?,?,?,?,?,?)";
			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, e_mail);
			pstmt.setString(5, find_q);
			pstmt.setString(6, find_a);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			return false;
		} finally {
			DBClose();
		}
		return true;
	}
	
	 public MemberDTO memberlogin(String user_id, String user_pw) {

		    try {
		      String sql = "select * from member where id=? and pw=?";
		      con = DriverManager.getConnection(url, uid, upw);
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, user_id);
		      pstmt.setString(2, user_pw);
		      rs = pstmt.executeQuery();
		      if (rs.next()) {
		        String id = rs.getString("id");
		        String pw = rs.getString("pw");
		        String name = rs.getString("name");
		        String e_mail = rs.getString("e_mail");
		        String pass_q = rs.getString("pass_q");
		        String pass_a = rs.getString("pass_a");
		        long point = rs.getLong("point");
		        String join_time = rs.getString("join_time");
		        MemberDTO dto = new MemberDTO(id, pw, name, e_mail, pass_q, pass_a, point, join_time);
		        return dto;
		      }else{
		      return null;
		      }
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      return null;
		    } finally {
		    	DBClose();
		    }
		  }
	 
	 
	 
	 
	 public MemberDTO point_trade(String my_id, int trade_point, String send_id){    
		    
		    try {
		      String sql = "update member set point=point+? where id=?";
		      con = DriverManager.getConnection(url, uid, upw);
		      pstmt = con.prepareStatement(sql);
		      pstmt.setLong(1, trade_point);
		      pstmt.setString(2, send_id);
		      pstmt.executeUpdate();
		      
		      String sql2 = "update member set point=point-? where id=?";
		      con = DriverManager.getConnection(url, uid, upw);
		      pstmt = con.prepareStatement(sql2);
		      pstmt.setLong(1, trade_point);
		      pstmt.setString(2, my_id);
		      pstmt.executeUpdate();
		      
		      String sql3 = "select * from member where id=?";
		      con = DriverManager.getConnection(url, uid, upw);
		      pstmt = con.prepareStatement(sql3);
		      pstmt.setString(1, my_id);
		      rs = pstmt.executeQuery();
		      
		      String sql4 = "insert into point_trade_ok(myid, send_id, send_point) values(?,?,?)";
		      con = DriverManager.getConnection(url, uid, upw);
		      pstmt = con.prepareStatement(sql4);
		      pstmt.setString(1, my_id);
		      pstmt.setString(2, send_id);
		      pstmt.setLong(3, trade_point);
		      pstmt.executeUpdate();
		      
		      if (rs.next()) {
		        String id = rs.getString("id");
		        String pw = rs.getString("pw");
		        String name = rs.getString("name");
		        String e_mail = rs.getString("e_mail");
		        String pass_q = rs.getString("pass_q");
		        String pass_a = rs.getString("pass_a");
		        long point = rs.getLong("point");
		        String join_time = rs.getString("join_time");
		        MemberDTO dto = new MemberDTO(id, pw, name, e_mail, pass_q, pass_a, point, join_time);
		        return dto;
		      }else{
		      return null;
		      }
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      return null;
		    } finally {
		      try {
		    	  DBClose();
		      }
		      catch (Exception e) {
		        e.printStackTrace();
		      }
		    }
		  }
	 
	 public ArrayList<MemberDTO> point_Top5rank(){
		 ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		 try{
			 String sql = "select * from member order by point desc, name asc limit 5";
			 con = DriverManager.getConnection(url, uid, upw);
		     pstmt = con.prepareStatement(sql);
		     rs = pstmt.executeQuery();
		     while(rs.next()){
		    	 String id = rs.getString("id");
		    	 long point = rs.getLong("point");
		    	 String pw = rs.getString("pw");
		    	 String name = rs.getString("name");
		    	 String e_mail = rs.getString("e_mail");
		    	 String pass_q = rs.getString("pass_q");
		    	 String pass_a = rs.getString("pass_a");
		    	 String join_time = rs.getString("join_time");
		    	 MemberDTO dto = new MemberDTO(id, pw, name, e_mail, pass_q, pass_a, point, join_time);
		    	 dtos.add(dto);
		     }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 DBClose();
		}
		return dtos;
	 }
	 
	 public ArrayList<MemberDTO> point_Bottom5rank(){
		 ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		 try{
			 String sql = "select * from member order by point asc, name desc limit 5";
			 con = DriverManager.getConnection(url, uid, upw);
		     pstmt = con.prepareStatement(sql);
		     rs = pstmt.executeQuery();
		     while(rs.next()){
		    	 String id = rs.getString("id");
		    	 long point = rs.getLong("point");
		    	 String pw = rs.getString("pw");
		    	 String name = rs.getString("name");
		    	 String e_mail = rs.getString("e_mail");
		    	 String pass_q = rs.getString("pass_q");
		    	 String pass_a = rs.getString("pass_a");
		    	 String join_time = rs.getString("join_time");
		    	 MemberDTO dto = new MemberDTO(id, pw, name, e_mail, pass_q, pass_a, point, join_time);
		    	 dtos.add(dto);
		     }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 try{
			 if(rs != null){rs.close();}
			 if(pstmt != null){pstmt.close();}
			 if(con != null){con.close();}
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}
		return dtos;
	 }
	 
	 public MemberDTO Member_Modify(String id, String name, String pw, String email, String pass_q, String pass_a){

		 try{
			 String sql = "update member set name=?, pw=?, e_mail=?, pass_q=?, pass_a=? where id=?";
			 con = DriverManager.getConnection(url, uid, upw);
		     pstmt = con.prepareStatement(sql);
		     pstmt.setString(1, name);
		     pstmt.setString(2, pw);
		     pstmt.setString(3, email);
		     pstmt.setString(4, pass_q);
		     pstmt.setString(5, pass_a);
		     pstmt.setString(6, id);
		     pstmt.executeUpdate();
		     
		     String sql2 = "select * from member where id=?";
		     con = DriverManager.getConnection(url, uid, upw);
		     pstmt = con.prepareStatement(sql2);
		     pstmt.setString(1, id);
		     rs = pstmt.executeQuery();
		     if(rs.next()){
		    	 String id2 = rs.getString("id");
		    	 String name2 = rs.getString("name");
		    	 String pw2 = rs.getString("pw");
		    	 String email2 = rs.getString("e_mail");
		    	 String pass_q2 = rs.getString("pass_q");
		    	 String pass_a2 = rs.getString("pass_a");
		    	 long point = rs.getInt("point");
		    	 String join_time = rs.getString("join_time");
		    	 MemberDTO dto = new MemberDTO(id2, pw2, name2, email2, pass_q2, pass_a2, point, join_time);
		    	 return dto;
		     }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 DBClose();
		}
		 return null;
		 
	 } 
	 
	 public MemberDTO getMember(String user_id){
		 try{
			 String sql = "select * from member where id=?";
			 con = DriverManager.getConnection(url, uid, upw);
		     pstmt = con.prepareStatement(sql);
		     pstmt.setString(1, user_id);
		     
		     rs = pstmt.executeQuery();
		     
		     if(rs.next()){
		    	 String id = rs.getString("id");
		    	 String name = rs.getString("name");
		    	 String pw = rs.getString("pw");
		    	 String email = rs.getString("e_mail");
		    	 String pass_q = rs.getString("pass_q");
		    	 String pass_a = rs.getString("pass_a");
		    	 long point = rs.getInt("point");
		    	 String join_time = rs.getString("join_time");
		    	 MemberDTO dto = new MemberDTO(id, pw, name, email, pass_q, pass_a, point, join_time);
		    	 return dto;
		     }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 DBClose();
		}
		 return null;
	 }
}
