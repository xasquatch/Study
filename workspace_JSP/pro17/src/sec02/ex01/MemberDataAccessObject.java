package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDataAccessObject { 
	
	private Connection con = null;
	private PreparedStatement pstmt = null;	
	private DataSource ds = null;
	private ResultSet rs = null;	
	
	public MemberDataAccessObject() {//커넥션풀(datasource) 얻기
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			//커넥션풀 <resource> 태그의 JNDI 이름으로 찾아 받아오기
			ds = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("dao create Exception!"+e.getMessage());	
		}
	}

	public int addMember(MemberValueObject vo){
		int result = 0;
		String sql = "INSERT INTO t_member(id, pwd, name, email, joindate) VALUES(?,?,?,?,?)"; 

			try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("addMember connection Exception!"+e.getMessage());
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				System.out.println("addMember connection close Exception!"+e2.getMessage());
			}
		}
		return result;
	}
	
	
	public List listMembers() {
		List list = new ArrayList();
		String sql = null;
		try {
			sql = "SELECT * FROM t_member ORDER BY joindate DESC"; 
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");

				MemberValueObject vo = new MemberValueObject(id,pwd,name,email,joindate);
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("listMembers Exception!"+e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				System.out.println("listMembers connection close Exception!"+e2.getMessage());
			}
		}
		return list;
	}

	public int delmember(String id) {
		int result = 0;
		String sql = null;
		try {
			sql="DELETE FROM t_member WHERE id=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("delmembers connection Exception!"+e.getMessage());
		} finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e2) {
				System.out.println("delmembers connection close Exception!"+e2.getMessage());
			}
		}
		return result;
	}

}
