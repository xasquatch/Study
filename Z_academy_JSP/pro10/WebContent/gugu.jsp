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
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
	
	%>
	<table border="1" width="800">
		<tr align="center" bgcolor="yellow">
			<td colspan="2"><%=dan %>단 출력</td>
		</tr>
	<%
		for(int i= 1; i<=9; i++){
			if(i % 2 == 1){
	%>
		<tr align="center" bgcolor="#CCFF66">
	<%
			}else{
	%>
		<tr align="center" bgcolor="#CCCCFF">
	<%
			}
	%>
			<td width=400><%=dan %> × <%=i %></td>
			<td width=400><%=dan*i %></td>
		</tr>
	<%
		}
	%>
	</table>
	<a href="/pro10/gugu.html">돌아가기</a>
</body>
</html>