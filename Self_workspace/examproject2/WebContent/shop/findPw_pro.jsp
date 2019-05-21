<%@page import="mybean.MemberDao"%>
<%@page import="mybean.MemberDto"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>비밀번호 찾기</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("mem_id");
	String email = request.getParameter("mem_email");

	MemberDto dto = new MemberDto();
	MemberDao dao = new MemberDao();
	String findPw = dao.findPw(id, email);
	
	if(findPw==null){
%>
	<script type="text/javascript">
		alert("입력한 정보를 찾을 수 없습니다.");
		history.back();
	</script>
<% 
	}else{
%>		
	<script type="text/javascript">
		alert("비밀번호는 <%=findPw%>입니다.");
		history.back();
	</script>
<% 
	}
%>		
<body>
</body>
</html>