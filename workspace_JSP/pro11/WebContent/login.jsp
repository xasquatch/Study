<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<h1>아이디를 입력해 달라굿</h1>
	<img src = "colorfulimg/uh.jpg"><BR>
	<form action="result.jsp" method = "POST">
		아이디 <input type="text" name = "userID"><BR>
		비밀번호 <input type="password" name = "userPw"><BR>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
	
</body>
</html>