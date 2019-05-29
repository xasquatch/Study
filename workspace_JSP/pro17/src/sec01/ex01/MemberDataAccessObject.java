package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				System.out.println("listMembers close Exception!"+e2.getMessage());
			}
		}
		
		
		
		
		
		
		
			
		return list;
	}

}
