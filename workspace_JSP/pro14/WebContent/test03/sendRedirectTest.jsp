<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sendRedirectTest</title>
</head>
<body>
<%--
	<c:redirect>태그
	-> response.sendRedirect()기능을 대체함
	
	<c:redirect>형식
		<c:redirect url="redirect할 URL">
			<c:param name="매개변수 이름" value="전달값"></c:param>
		</c:redirect>
		
	예제 주제 : <c:redirect>태그를 이용해 회원정보 출력창으로 리다이렉트 합니다.
			리다이렉트하면서 회원정보를 매개변수로 전달합니다.
 --%>
	<c:redirect url="/Test01/Member1.jsp">
		<!-- 리다이렉트할 페이지로 전달할 매개변수 값을 설정 -->
		<c:param name="id" value="hong"/>
		<c:param name="pwd" value="${'1234'}"/>
		<c:param name="name" value="${'홍길동'}"/>
		<c:param name="email" value="hong@test.com"/>
	</c:redirect>



</body>
</html>