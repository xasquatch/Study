<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	<form action="result.jsp" method="POST" align="center">
		ID : <input type="text" name="userID"><BR>
		PW : <input type="password" name="userPW"><BR>
		<input type="submit" value="LOGIN"><input type="reset" value="RESET">
	</form>
</body>
</html>