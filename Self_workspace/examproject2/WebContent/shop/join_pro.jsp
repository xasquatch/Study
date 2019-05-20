<!-- 커넥션풀 역할을 하는 DBConnectionMgr클래스를 사용하기 위해 import선언  -->
<%@page import="dbcp.DBConnectionMgr" %>
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
<title>회원가입 완료!!</title>
</head>
<%
	// request영역을 전달받아 request영역의 데이터 중 한글이 있다면 한글 인코딩 처리하기
	// 한글 깨짐 방지 처리
	request.setCharacterEncoding("UTF-8");
	/* 순서1. addSawon.jsp페이지 form태그에서 입력한 회원가입 내용 전달 받기 */	
%>
	<%-- addSawon.jsp에서 입력한 회원가입 정보를 아래의 DTO객체에 저장하기위한 객체 생성 
		  객체 생성 후 모든 SawonDto객체의 모든 setter메소드를 호출하여 SawonDto객체의 모든 변수에 우리가 입력한 값 저장 --%>
    <jsp:useBean id="dto" class="mybean.MemberDto"/>	
    <jsp:setProperty property="*" name="dto"/> 
    
    <%-- insert DB작업을 위해 DAO객체 생성--%>
    <jsp:useBean id="dao" class="mybean.MemberDao"/>

<%	// insert 작업할 메소드 호출 시 우리가 입력한 회원정보를 저장하고 있는 SawonDto객체 전달!
	dao.setMember(dto);
%>
	<script type="text/javascript">
		alert("회원가입 완료!");
		location.href="../bootstrap/index.jsp";
	</script>

<body>
</body>
</html>