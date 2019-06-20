<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--JSTL라이브러리에 속한 태그들중.. core라이브러리에 속한 태그를 사용하기 위해 링크 설정 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%-- 선터 영역 공간은 사용자로부터 요청을 받아 화면이 바뀌는 부분임 --%>
		<c:set var="center" value="${param.center}"/>
		
		<c:out value="${center}"/>
		
		
		<%--처음 CarMain.jsp페이지를 실행하면 당연히.. 
			center변수값은 null임 --%>
		<c:if test="${center == null}">
			<c:set var="center" value="Center.jsp"/>
		</c:if>
		
		<center>
			<table width="1000" height="700">
				<tr align="center">
					<td>
						<jsp:include page="Top.jsp"/>
					</td>
				</tr>
				<tr>
					<td height="500">
						<jsp:include page="${center}"/>
					</td>
				</tr>
				<tr>
					<td>
						<jsp:include page="Bottom.jsp"/>
					</td>
				</tr>		
			</table>
		</center>
</body>
</html>






