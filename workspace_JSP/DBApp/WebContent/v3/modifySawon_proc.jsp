<%@page import="dbcp.DBConnectionMgr"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("utf-8");

	String no = request.getParameter("no");
	String s_id = request.getParameter("s_id");
	String s_pw = request.getParameter("s_pw");
	String s_name = request.getParameter("s_name");
	int s_age = Integer.parseInt(request.getParameter("s_age"));
	String s_addr = request.getParameter("s_addr");
	String s_dept = request.getParameter("s_dept");
	String s_extension = request.getParameter("s_extension");
		
	String sql = "UPDATE tblsawon SET"
									+" id = ?"
									+", name = ?"
									+", pass = ?"
									+", age = ?"
									+", addr = ?"
									+", extension = ?"
									+", dept = ?"
									+" WHERE no = ?";
//				+" id = '"+s_id
//				+"', name = '"+s_name
//				+"', pass = '"+s_pw
//				+"', age = "+s_age
//				+", addr = '"+s_addr
//				+"', extension = '"+s_extension
//				+"', dept = '"+s_dept
//				+"' WHERE no = "+no;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		try{
			
			pool.getConnection();
			
			pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, s_id);
				pstmt.setString(2, s_name);
				pstmt.setString(3, s_pw);
				pstmt.setInt(4, s_age);
				pstmt.setString(5, s_addr);
				pstmt.setString(6, s_extension);
				pstmt.setString(7, s_dept);
				pstmt.setString(8, no);
			
			
			pstmt.executeUpdate();
			%>
				<script>
				alert("수정에 성공하였습니다");
				location.href = "index.jsp";
				</script>
			<%
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("proc page error");
			
		}finally{
			pool.freeConnection(con, pstmt);
			
		}
	
		
%>