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
		//웹브라우저에서 접속시에는 msg값을 가져와서 표시하고
		//최초 접속시에는 null이므로 아무것도 표시하지 않습니다.
		String msg = request.getParameter("msg");
		
		if(msg != null){
%>
			<h1><%=msg%></h1>
<%	
		}
%>
	<img src = "colorfulimg/uh.jpg"><BR>
	<form action="result2.jsp" method = "POST">
		아이디 <input type="text" name = "userID"><BR>
		비밀번호 <input type="password" name = "userPw"><BR>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
	
</body>
</html>