<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name_pw");
String id = request.getParameter("id_pw");
String email = request.getParameter("email_pw");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String url = "jdbc:mysql://localhost:3306/project";
String uid = "sungkuk";
String upw = "sungkuk";


String str = "";

con = DriverManager.getConnection(url, uid, upw);
String sql = "select * from member where name=? and id=? and e_mail=?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1, name);
pstmt.setString(2, id);
pstmt.setString(3, email);
rs = pstmt.executeQuery();

if(rs.next()){
	out.print(rs.getString("pass_q"));
	}else{
	out.print(str);
}
%>