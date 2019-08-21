<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>국어와 영여 점수의 평균</h1>
<%
	//1. 요청값 전달받기
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	
	//2. 요청값 이용해 응답값 만들기
	int avg = (kor+eng)/2;
	
	//3. 응답값을 이용해 클라이언트의 웹브라우저로 응답
%>
	당신의 평균은 <%=avg%>점 입니다.
	
</body>
</html>