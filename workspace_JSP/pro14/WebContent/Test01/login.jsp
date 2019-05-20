<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login 입력창</title>
</head>
<body>
	<form action="result.jsp">
		ID : <input type="text" size="20"><br>
		PW : <input type="password" size="20"><br>
		<input type="submit" value="Login">
		<input type="reset" value="Reset">
	</form>
	<br><br>
	
	<%-- 1. 직접 컨텍스트 이름을 입력해 요청하는 경우
	<a href="http://localhost:8090/pro14/Test01/MemberForm.jsp">Join</a>
	 --%>
	 
	<%-- 2. request의 getcontextpath()메소드를 이용해 컨텍스트 이름을 가져와 요청하는 경우
	<a href="<%=request.getContextPath()%>/Test01/MemberForm.jsp">Join</a> 
	 --%>
	 
	<%-- 3.자바코드를 사용하지 않고 pageContext객체의 속성인 request하위의 contextPath속성으로 컨텍스트 이름을 가져와 요청하는 경우--%>
	 <a href="${pageContext.request.contextPath}/Test01/MemberForm.jsp">Join</a><BR>
	 param : ${param}<BR>
	 requestScope : ${requestScope}<BR>
	 pageContext : ${pageContext}<BR>
	 pageContext.request : ${pageContext.request}<BR>
	 pageContext.request.contextPath : ${pageContext.request.contextPath}<BR>
	 
</body>
</html>