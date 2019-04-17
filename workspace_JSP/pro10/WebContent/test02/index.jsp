<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이동</title>
</head>
<body>
	<h1>Welcome to mypage</h1>
<%
		//login.jsp페이지에서 넘겨받은 session객체 메모리 영역에 드러있는
		//"id"키에 해당하는 세션값을 꺼내서 변수에 저장
		String new_id = (String)session.getAttribute("id");
		if("master".equals(new_id)){
%>
			<h1><%=new_id%>님로그인 성공</h1>		
			<a href="logout.jsp">로그아웃</a><BR>
			<a href="shop.jsp">쇼핑몰</a>
<%		
		}else{
%>
			<h1>로그인 실패</h1>
			<a href="login.jsp">로그인창으로 이동</a><BR>
			<a href="shop.jsp">쇼핑몰</a>
<%
		}//end if
%>
</body>
</html>