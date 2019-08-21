<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%> <!-- ←다른 JSP페이지에서 예외발생 시 예외를 처리하는 예외처리하는 페이지로 지정하는 true값 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<%--exception내장객체를 이용해서 발생한 예외를 처리하도록 합니다. --%>
	<img src="./pr.jpg"><BR>
	==========================toString() 내용=============================<br>
	<%--exception내장객체를 사용해 예외처리를 합니다. --%>
	<h1><%= exception.toString()%></h1><BR>
	==========================getMessage() 내용=============================<br>
	<h1><%=exception.getMessage() %></h1><BR>
	==========================console창에 예외메시지 출력=============================<br>
	<h1><% exception.printStackTrace(); %></h1>
	<a href="add.html">다시하기</a>
</body>
</html>