<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	<c:url>태그 정보
		JSP페이지에서 URL정보를 저장하는 기능
		
	<c:url>태그 형식
		<c:url context="" scope="유효범위" value="URL경로" var="변수명">
			<c:param name="매개변수 이름" value="전달 값"/>
		</c:url>
		
	상세
		var : url이 저장된 변수
		value : 생성할 URL
		scope : 변수의 접근 범위 (page, request, session, application) 중 하나
--%>

	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<%-- <c:url>태그를 이용하여 이동할 페이지 주소를 설정함 --%>
	<c:url var="url1" value="/Test01/Member1.jsp">
		<!-- 이동할 페이지로 전달할 데이터를 설정함 -->
		<c:param name="id" value="hong"/>
		<c:param name="pwd" value="1234"/>
		<c:param name="name" value="홍길동"/>
		<c:param name="email" value="hong@test.com"/>
	</c:url>
	<a href="${contextPath}/Test01/Member1.jsp">회원정보 출력(set방식)</a><BR><BR>
	
	<%-- <c:url>태그의 변수 이름을 간단하게 이용하여 member1.jsp로 이동시 값 전달 --%>
	<a href="${url1}">회원정보 출력 (url방식)</a>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


</body>
</html>