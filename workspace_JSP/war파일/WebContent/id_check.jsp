<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.willtoto.dto.MemberDTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
Class.forName("com.mysql.jdbc.Driver");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String url = "jdbc:mysql://localhost:3306/project";
String uid = "sungkuk";
String upw = "sungkuk";

String id = request.getParameter("id");
String str = null;

con = DriverManager.getConnection(url, uid, upw);
String sql = "select id from member where id=?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
rs = pstmt.executeQuery();

if(rs.next()){
	str = "YES";
	out.print(str);
}else{
	str = "NO";
	out.print(str);	
}
%>