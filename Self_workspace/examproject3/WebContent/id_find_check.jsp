<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.willtoto.dto.MemberDTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name_id");
String email = request.getParameter("email_id");

Class.forName("com.mysql.jdbc.Driver");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String url = "jdbc:mysql://localhost:3306/project";
String uid = "sungkuk";
String upw = "sungkuk";

String str = "";

con = DriverManager.getConnection(url, uid, upw);
String sql = "select id from member where name=? and e_mail=?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1, name);
pstmt.setString(2, email);
rs = pstmt.executeQuery();

if(rs.next()){
	str = rs.getString("id");
	out.print(str);
}else{
	out.print(str);	
}
%>