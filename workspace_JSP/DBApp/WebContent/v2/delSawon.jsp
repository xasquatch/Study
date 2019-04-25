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
	

	String url = "jdbc:mysql://localhost:3306/jspbeginner";
	String id = "jspid", pw = "jsppass";
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(url,id,pw);
		
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
		if(con!=null) con.close();
		if(pstmt!=null) pstmt.close();
	}
	
 %>