<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("utf-8"); %>
<!-- Member_action.jsp페이지는 화면기능을 수행하지 않고
	데이터베이스 연동 기능만 수행
	입력한 회원정보를 DB에 추가한 후 다시 추가한 회원정보를 조회를 하고
	조회한 회원정보를 request내장객체 영역에 바인딩한 후 , memberList.jsp로 포워딩
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member_action</title>
</head>
<body>
	<jsp:useBean id="bean" class="sec02.ex01.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bean"/>
	<jsp:useBean id="dao" class="sec02.ex01.MemberDAO"></jsp:useBean>
	<%	dao.addMember(bean);
		List list = dao.listMember();
		request.setAttribute("list", list);
	%>
	<jsp:forward page="memberList.jsp"></jsp:forward>
	
</body>
</html>