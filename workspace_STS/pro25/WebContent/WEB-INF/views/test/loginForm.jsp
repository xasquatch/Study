<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/test/login.do" method="get">
		<table width="400">
			<tr>
				<td>아이디 : <input type="text" name="userID" size="10"></td>
			</tr>
			<tr>
				<td>이름 : <input type="text" name="userName" size="10"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>