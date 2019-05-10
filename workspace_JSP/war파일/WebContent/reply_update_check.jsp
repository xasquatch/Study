<%@page import="com.willtoto.dto.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
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
int num = Integer.parseInt(request.getParameter("num"));
int replyNum = Integer.parseInt(request.getParameter("replyNum"));
int check = Integer.parseInt(request.getParameter("check"));

String str = null;

con = DriverManager.getConnection(url, uid, upw);
String sql = "select * from reply where id=? and num=? and replyNum=?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setInt(2, num);
pstmt.setInt(3, replyNum);
rs = pstmt.executeQuery();

if(rs.next()){
	if(check == 1){
%>
	<input type="text" name="update_reply_write" id="update_reply_write" class="reply_write_update" maxlength="99" value="<%=rs.getString("replyWrite")%>">
<%}else if(check == 2){%>
	<label id=""><%=rs.getString("replyWrite")%></label>
<%}else{
	str = "NO";
	out.print(str);
}
}
%>