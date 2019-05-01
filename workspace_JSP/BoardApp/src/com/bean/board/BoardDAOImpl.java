package com.bean.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

public class BoardDAOImpl implements IBoardDAO {

	private DataSource ds; 
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//커넥션풀 얻는 생성자
	public BoardDAOImpl(){
		try {
//				1. WAS서버와 연결된 프로젝트의 모든 정보를 가지고 있는 객체 생성
			Context init = new InitialContext();
//				2. 연결된 WAS서버에서 DataSource(커넥션풀)검색해서 가져오기
			ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");
			
			
		} catch (Exception e) {
			System.out.println("커넥션풀 얻기 실패 : "+ e.getMessage());

		}
		
	}
	
	//리소스 반납(자원해제 메소드)
	public void freeResource(){
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con !=null) con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Vector<BoardDTO> getBoardList(String keyField, String keyWord, int start, int end) {
		Vector v = new Vector<>();
		
		String sql = "";
		
		try {
			//DataSource(커넥션풀)에서 DB연동객체(커넥션)가져오기
			con = ds.getConnection();
			//검색어를 입력하지 않았다면?
			if(keyWord == null || keyWord.isEmpty()){

				//가장 최신글이 위로 올라오게 num필드 값 기준으로 하여
				//내림차순 정렬
				sql = "SELECT * FROM tblboard ORDER BY num desc LIMIT "+start+" , "+end;

			//검색어를 입력했다면 (조건else)			
			}else{
			
				sql = "SELECT * FROM tblboard WHERE "+ keyField +" LIKE '%"+ keyWord +"%' ORDER BY num desc LIMIT "+start+" , "+end;
				//keyField(검색기준 필드)에 해당하는 글 검색시
				//앞뒤에 어떤 문자가 와도 상관 없이  keyword(검색어)를 가진 데이터를 검색함
				//num필드 기준으로 하여 내림차순 정렬하여 검색하는 sql구문 생성 
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//검색한 결과를 (ResultSet객체에 저장된 결과)를 뽑아내서
			//각각의 BoardDTO객체를 생성하여 저장 후
			//저장한 BoardDTO객체를 다시 벡터에 추가하여 담아
			while (rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("num"), rs.getString("name"), rs.getString("email"),
											rs.getString("homepage"), rs.getString("subject"), rs.getString("content"),
											rs.getString("pass"), rs.getInt("count"), rs.getString("ip"),
											rs.getTimestamp("regdate"), rs.getInt("pos"), rs.getInt("depth"));
				v.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getBoardList error!");
		} finally {
				freeResource();
		}
		return v;
	}
	
	
	//DB에 있는 글들을 검색해서 가져올 수 있는 메소드↓
	//List.jsp
	@Override
	public Vector getBoardList(String keyField, String keyWord) {
		Vector v = new Vector<>();
		
		String sql = "";
		
		try {
			//DataSource(커넥션풀)에서 DB연동객체(커넥션)가져오기
			con = ds.getConnection();
			//검색어를 입력하지 않았다면?
			if(keyWord == null || keyWord.isEmpty()){

				//가장 최신글이 위로 올라오게 num필드 값 기준으로 하여
				//내림차순 정렬
				sql = "SELECT * FROM tblboard ORDER BY num desc";

			//검색어를 입력했다면 (조건else)			
			}else{
			
				sql = "SELECT * FROM tblboard WHERE "+ keyField +" LIKE '%"+ keyWord +"%' ORDER BY num desc";
				//keyField(검색기준 필드)에 해당하는 글 검색시
				//앞뒤에 어떤 문자가 와도 상관 없이  keyword(검색어)를 가진 데이터를 검색함
				//num필드 기준으로 하여 내림차순 정렬하여 검색하는 sql구문 생성 
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//검색한 결과를 (ResultSet객체에 저장된 결과)를 뽑아내서
			//각각의 BoardDTO객체를 생성하여 저장 후
			//저장한 BoardDTO객체를 다시 벡터에 추가하여 담아
			while (rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("num"), rs.getString("name"), rs.getString("email"),
											rs.getString("homepage"), rs.getString("subject"), rs.getString("content"),
											rs.getString("pass"), rs.getInt("count"), rs.getString("ip"),
											rs.getTimestamp("regdate"), rs.getInt("pos"), rs.getInt("depth"));
				v.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getBoardList error!");
		} finally {
				freeResource();
		}
		return v;
	}

	


	@Override
	public BoardDTO getBoard(int num) {
		
		BoardDTO dto = new BoardDTO();
		String sql = "";

		try{
			
			sql = "UPDATE tblboard SET count = count + 1 WHERE num = "+num;
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "SELECT * FROM tblboard WHERE num = "+num;
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPass(rs.getString("pass"));
				dto.setCount(rs.getInt("count"));
				dto.setIp(rs.getString("ip"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setPos(rs.getInt("pos"));
				dto.setDepth(rs.getInt("depth"));
			
		}catch (Exception e){
			System.out.println("READ error!");
			e.printStackTrace();
		}finally {
			freeResource();
		}
	
		return dto;
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		
		try {
			String sql = "INSERT INTO tblboard(name, email, homepage, subject, content, regdate, pass, count, ip, pos, depth)"
								+ " VALUES(?, ?, ?, ?, ?, ?, ?, 0, ?, 0, 0)";
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHomepage());
			pstmt.setString(4, dto.getSubject());
			pstmt.setString(5, dto.getContent());
			pstmt.setTimestamp(6, dto.getRegdate());
			pstmt.setString(7, dto.getPass());
			pstmt.setInt(8, dto.getCount());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("insertBoard메소드 오류");
		} finally {
			try{
				pstmt.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		
		String sql = "";
		try {
			sql = "UPDATE tblboard SET name = ?, email = ?, subject = ?, content = ?, pass = ?,"
								+ " WHERE num = ?";
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getPass());
				pstmt.setInt(5, dto.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("또여 와나..");
		}finally {
			freeResource();
		}
		
	}

	@Override
	public void deleteBoard(int num) {
		
		
		try{
			String sql = "DELETE FROM tblboard WHERE num = "+num;
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			freeResource();
		}
		
		
	}

	@Override
	public void replayBoard(BoardDTO dto) {
		
		
		
	}

	
	
	public BoardDTO getBoardInfo(int num) {
		
		BoardDTO dto = new BoardDTO();
		
		try{
			
			
			String sql = "SELECT * FROM tblboard WHERE num = "+num;
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPass(rs.getString("pass"));
				dto.setCount(rs.getInt("count"));
				dto.setIp(rs.getString("ip"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setPos(rs.getInt("pos"));
				dto.setDepth(rs.getInt("depth"));
			
		}catch (Exception e){
			System.out.println("READ error!");
			e.printStackTrace();
		}finally {
			freeResource();
		}
	
		return dto;
	}

	
}
