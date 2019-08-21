<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//appTest1.jsp에서 <a>링크를 클릭했을 때 현재 페이지인 appTest2.jsp로 이동해옴
	//중요 포인트 → 같은 웹브라우저를 사용, session영역 유지 
	//중요 포인트 → 같은 웹어플리케이션(웹프로젝트)내에서 톰캣이 중지되기 전까지는 application영역 유지

	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");


	System.out.println(name+address);
	out.println(name+" "+address);
	System.out.println(name+address);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
</body>
</html>