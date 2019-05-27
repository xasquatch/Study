<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- JSTL 포맷팅 라이브러리에 속한 태그 사용을 위한 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- fmt:setLocale 태그를 이용해 표시할 언어르 영어로 지정 --%>

<%-- 			<fmt:setLocale value="en_US"/> --%>
			<fmt:setLocale value="ko_KR"/>
	

		<h1>회원정보<BR><BR>
			<%-- <fmt:bundle>태그를 이용해 resource패키지 아래의 member프로퍼티 파일을 읽어옴 --%>
			<fmt:bundle basename="resource.member">
				NAME : <fmt:message key="mem.name" /><BR> <!-- 이 태그의 키 속성에 프로퍼티 파일의 키를 지정해서 값(value)을 얻어서 출력 -->
				ADDRESS : <fmt:message key="mem.address" /><BR>
				JOB : <fmt:message key="mem.job" /><BR>
			</fmt:bundle>
		</h1>
</body>
</html>