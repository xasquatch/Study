<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
<%
	String url = "jdbc:mysql://localhost:3306/project";
	String uid = "sungkuk";
	String upw = "sungkuk";
	
	Connection con1 = null;
	ResultSet rs1 = null;
	PreparedStatement pstmt1 = null;
	
	Connection con2 = null;
	ResultSet rs2 = null;
	PreparedStatement pstmt2 = null;
	
	Connection con3 = null;
	ResultSet rs3 = null;
	PreparedStatement pstmt3 = null;
	
	con1 = DriverManager.getConnection(url, uid, upw);
	String sql = "select * from point_game1";
	pstmt1 = con1.prepareStatement(sql);
	rs1 = pstmt1.executeQuery();
	
	con2 = DriverManager.getConnection(url, uid, upw);
	String sql2 = "select count(*) from point_game1 where disabled=1 and result=1";
	pstmt2 = con2.prepareStatement(sql2);
	rs2 = pstmt2.executeQuery();
	
			
	%>
		
	<%
	
%>
	<%while(rs1.next()){
	%>
	<input type="submit" class="num" name="puzzle" value=<%if(rs1.getInt("disabled") == 1){%> 뽑힘 <%}else{ %> '<%=rs1.getInt(1)%>' <%} %>  <%if(rs1.getInt("disabled") == 1){ %>disabled="disabled"<%} %>><%}
	if(rs1 != null){rs1.close();}
	if(pstmt1 != null){pstmt1.close();}
	if(con1 != null){con1.close();}
%>