<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--requestTest1_proc.jsp페이지로 이동하면서 form태그의 데이터 전달 --%>	
	<form action="requestTest1_proc.jsp" method="POST">
		국어 : <input type="text" name="kor"><BR>
		영어 : <input type="text" name="eng">
		<input type="submit" value="평균">
	</form>
</body>
</html>