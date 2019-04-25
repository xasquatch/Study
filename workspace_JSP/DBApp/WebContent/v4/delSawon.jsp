<%@page import="dbcp.DBConnectionMgr"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	
	String sql = "DELETE FROM tblsawon WHERE no=?";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	

	DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	try{
		
		con = pool.getConnection();
		
		pstmt = con.prepareStatement(sql);
				
			pstmt.setString(1, no);
		
		
		
		pstmt.executeUpdate();
		%>
		<script type="text/javascript">
			alert("삭제완료");
			location.href = "index.jsp";
		</script>
		<%
	}catch(Exception e){
		System.out.println("del error-"+e);
	}finally{
		pool.freeConnection(con, pstmt);
		
	}
	
 %>