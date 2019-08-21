<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//우선 첫번째 방법으로 getAttribute()메소드에 속성이름을 인자로 하여 값을 가져옵니다.
	//각 내장객체에 바인딩된 속성값들을 getAttribute()메소드를 이용해 가져옴
	
	String id = (String)request.getAttribute("id");
	String pwd = (String)request.getAttribute("pwd");
	String name = (String)session.getAttribute("name");
	String email = (String)application.getAttribute("email");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" style="background-color:black; color:white;">
			<td width="20"><b>ID</b></td>
			<td width="20"><b>PW</b></td>
			<td width="20"><b>NAME</b></td>
			<td width="20"><b>EMAIL</b></td>
		</tr>
		<tr align="center">
			<!-- 표현식 사용 -->
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
		</tr>
		<tr align="center">
			<!-- 자바코드 없이 바로 각내장객체 영역에 저장되어 있는 값을 꺼내어 EL태그로 출력 -->
			<td>${requestScope.id }</td>
			<td>${requestScope.pwd }</td>
			<td>${sessionScope.name }</td>
			<td>${applicationScope.email }</td>
		</tr>
		<tr align="center">
			<!-- 자바코드 없이 바로 각내장객체 영역에 저장되어 있는 값을 꺼내어 EL태그로 출력 -->
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${email }</td>
		</tr>
	</table>
</body>
</html>