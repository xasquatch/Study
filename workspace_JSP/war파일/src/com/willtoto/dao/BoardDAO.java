package com.willtoto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.willtoto.dto.BoardDTO;
import com.willtoto.dto.ReplyDTO;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";
	
	public BoardDAO() {
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
	
	public int write(BoardDTO dto){
		int check = 0;
		sql = "insert into board values(?,?,?,?,?,?,?,?,?,?)";
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getNum());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getTitle());
		pstmt.setString(4, dto.getContent());
		pstmt.setInt(5, dto.getRe_ref());
		pstmt.setInt(6, dto.getRe_lev());
		pstmt.setInt(7, dto.getRe_seq());
		pstmt.setInt(8, dto.getView());
		pstmt.setString(9, dto.getDate());
		pstmt.setString(10, dto.getIp());
		check = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return check;
	}
	
	public int delete(int num, String id){
		int check = 0;
		sql = "delete from board where num=? and id=?";
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setString(2, id);
		check = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return check;
	}
	
	public int update(BoardDTO dto, String id){
		int check = 0;
		sql = "update board set title=?, content= ? where num=? and id=?";
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setInt(3, dto.getNum());
		pstmt.setString(4, id);
		check = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return check;
	}
	
	public BoardDTO updateView(int num, String id){
		BoardDTO dto = null;
		try{
		sql = "select * from board where num=? and id=?";
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setString(2, id);
		rs = pstmt.executeQuery();
		if(rs.next()){
			dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setView(rs.getInt("view"));
			dto.setDate(rs.getString("date"));
			dto.setIp(rs.getString("ip"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return dto;
	}
	
	
	
	public BoardDTO view(int num){
		BoardDTO dto = null;
		try{
		sql = "update board set view=view+1 where num=?";
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.executeUpdate();
		sql = "select * from board where num=?";
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()){
			
			dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setView(rs.getInt("view"));
			SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
			String time = format.format(rs.getTimestamp("date"));
			dto.setDate(time);
			dto.setIp(rs.getString("ip"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return dto;
	}
	
	public ArrayList<BoardDTO> b_list(int startRow, int pageSize){
		sql = "select * from board order by re_ref desc, re_seq asc limit ?,?";
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
		while(rs.next()){
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setView(rs.getInt("view"));
			SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
			String time = format.format(rs.getTimestamp("date"));
			dto.setDate(time);
			dto.setIp(rs.getString("ip"));
			dtos.add(dto);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return dtos;
	}
	
	public ArrayList<BoardDTO> i_list(){
		sql = "select * from board order by num desc";
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setView(rs.getInt("view"));
			SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
			String time = format.format(rs.getTimestamp("date"));
			dto.setDate(time);
			dto.setIp(rs.getString("ip"));
			dtos.add(dto);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return dtos;
	}
	
	public ArrayList<BoardDTO> search(String select, String keyword){
		sql = "select * from board where " + select + " like '%" + keyword + "%' order by num desc";
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setView(rs.getInt("view"));
			SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
			String time = format.format(rs.getTimestamp("date"));
			dto.setDate(time);
			dto.setIp(rs.getString("ip"));
			dtos.add(dto);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBClose();
		}
		return dtos;
	}
	
	public int count(){
		sql = "select count(*) from board";
		int count = 0;
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
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
	
	public int max(){
		sql = "select max(num) from board";
		int count = 0;
		try{
		con = DriverManager.getConnection(url, uid, upw);
		pstmt = con.prepareStatement(sql);
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
}
