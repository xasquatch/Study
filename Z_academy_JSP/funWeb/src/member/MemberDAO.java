package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {//MYSQL DBMS의 DB에 접근하여 DB작업하는 클래스
	
	String sql = "";
	PreparedStatement pstmt = null; Connection con = null; ResultSet rs = null; 
	//Connection접속을 얻는 메소드
	private Connection getConnection() throws Exception{
		//커넥션을 담을 변수
		Context init = new InitialContext();
		//커넥션풀 얻기
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspbeginner");
		//커넥션 객체 얻기
		con = ds.getConnection();
		
		return con;
		}

	public void insertMember(MemberBean bean) {
		

		sql = "INSERT INTO member(id, passwd, name, email, address, tel, mtel, reg_date)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getId());
				pstmt.setString(2, bean.getPasswd());
				pstmt.setString(3, bean.getName());
				pstmt.setString(4, bean.getEmail());
				pstmt.setString(5, bean.getAddress());
				pstmt.setString(6, bean.getTel());
				pstmt.setString(7, bean.getMtel());
				pstmt.setTimestamp(8, bean.getReg_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (sql != "") sql = "";
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public int idcheck(String id) {
		//회원가입을 위해 사용자가 입력한 iod값을 매개변수로 전달받아
		//DB에 사용자가 입력한 id값이 존재하는지 select하여
		//만약 사용자가 입력한 id에 해당하는 회원레코드가 있으면
		//check변수값을 1로 저장 <--아이디 중복
		//없으면 0
		int check = 0;
		try {
			sql = "SELECT * FROM member WHERE id="+id;
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = 1;
			}else{
				check = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
					if(sql != null) sql="";
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return check;
	}
	
	public int userCheck(String id, String pass) {
		
		int check = -1;	//1 -> 아이디 비밀번호 맞음
						//0 -> 아이디맞음, 비밀번호 틀림
						//-1 -> 아이디틀림
		try {
			sql = "SELECT * FROM member WHERE id = "+id;
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (pass.equals(rs.getString("passwd"))) {
					check = 1; 
				}else{
					check = 0; 
				}
			}else{
				check = -1; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(sql != "") sql="";
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

