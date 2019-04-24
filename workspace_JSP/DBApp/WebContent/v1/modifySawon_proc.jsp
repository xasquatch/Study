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
						+" id = '"+s_id
						+"', name = '"+s_name
						+"', pass = '"+s_pw
						+"', age = "+s_age
						+", addr = '"+s_addr
						+"', extension = '"+s_extension
						+"', dept = '"+s_dept
						+"' WHERE no = "+no;
		
		Connection con = null;
		Statement stmt = null;
		
		
		String url = "jdbc:mysql://localhost:3306/jspbeginner";
		String id = "jspid", pw = "jsppass";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,id,pw);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
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
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
	
		
%>