<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN.JSP</title>
</head>
<body>
	<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
	
	<form action="result.jsp">
		ID : <input type="text" size="20"><BR>
		PW : <input type="password" size="20"><BR>
		<input type="submit" value="LOGIN">
		<input type="reset" value="RESET">
	</form>
	<BR><BR>
	<a href="<%=request.getContextPath()%>/test01/memberForm.jsp">회원등록하기(JAVA)</a>
	<BR><BR>
			<!-- 먼저 JSP에서 <a>태그를 이용해 다른페이지로 이동하는 방법
			지금까지는 표현언어로 pageContext.request.contextPath했지만 
			코어셋으로 변수선언하여 EL로 사용가능(표현식에는 적용불가)
			-->
	<a href="${pageContext.request.contextPath}/test01/memberForm.jsp">회원등록하기(EL)</a>
	<BR><BR>
	<a href="${contextpath}/test01/memberForm.jsp">회원등록하기(core declaration 1)</a>
	<BR><BR>
<%-- 	<a href="${con}/test03/memberForm.jsp">회원등록하기(core declaration 2)</a>
		<a href="<%=contextpath %>/test03/memberForm.jsp">회원등록하기(core선언 to JAVA)</a>

	    !!!!!!!둘다 사용못함
--%>
	
	<c:out value="${contextpath}"/>

</body>
</html>