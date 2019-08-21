<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- 	다운로드할 파일이름을 hidden태그의 value속성의 값으로 설정해서 result.jusp에 다운로드 요청함 -->
<form action="result.jsp" method="POST">
							<input type="hidden" name="param1" value="colorpicker.gif">
							<input type="hidden" name="param2" value="duke.png">
	<input type="submit" value="파일 다운로드">
	
</form>
</body>
</html>