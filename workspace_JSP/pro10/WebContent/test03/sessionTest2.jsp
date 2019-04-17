<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 sessionTest2.jsp입니다.</h1>
	<%=session.getAttribute("sessionVal") %>
<!-- 	결론 -->
<!-- 	클라이언트 요청시 자동으로 생성되는 JSP페이지에서의 session객체메모리 영역은 -->
<!-- 	다시 다른 jsp페이지를 요청시 같은 웹브라우저가 닫기기전까지는 메모리가 유지됨 -->

</body>
</html>