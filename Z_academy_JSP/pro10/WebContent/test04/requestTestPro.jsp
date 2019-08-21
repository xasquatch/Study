<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청값의 한글 인코딩을 위해 request내장객체를 사용함
	request.setCharacterEncoding("utf-8");
	
	String num = request.getParameter("num");
	String name = request.getParameter("name");
	String grade = request.getParameter("grade");
	String subject = request.getParameter("subject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 정보</h2>
	<table border="1" width = "300">
		<tr>
			<td>학번</td>
			<td><%=num %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>학년</td>
			<td><%=grade %></td>
		</tr>
		<tr>
			<td>과목</td>
			<td><%=subject %></td>
		</tr>
	</table>
</body>
</html>