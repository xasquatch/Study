<%@page import="java.util.Iterator"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member3</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<table border="1" align="center">
		<tr align="center">
			<td colspan="5"><img src="../popcorn.gif" Style="text-align:center;"></td>
		</tr>
		<tr align="center" bgcolor="powderblue">
			<td width="20"><b>ID</b></td>
			<td width="20"><b>PW</b></td>
			<td width="20"><b>NAME</b></td>
			<td width="20"><b>EMAIL</b></td>
			<td width="20"><b>JOIN DATE</b></td>
		</tr>
		<tr align="center">
		<!-- 표현언어에서 속성이름으로 arrayList에 접근한 후 인덱스를 이용해 첫번째 회원정보를 얻어 -->
			<td>${memberlist[0].id}</td>
			<td>${memberlist[0].pwd }</td>
			<td>${memberlist[0].name }</td>
			<td>${memberlist[0].email }</td>
			<td>${memberlist[0].joinDate }</td>
		</tr>
		<tr align="center">
			<td>${memberlist[1].id}</td>
			<td>${memberlist[1].pwd }</td>
			<td>${memberlist[1].name }</td>
			<td>${memberlist[1].email }</td>
			<td>${memberlist[1].joinDate }</td>
		</tr>
		<tr>
			<td colspan="5" align="center">▼JAVA CODING</td>
		</tr>
<%
	ArrayList list = (ArrayList)request.getAttribute("memberlist");
	for(int i = 0;i<list.size();i++){
		MemberBean bean = (MemberBean)list.get(i);
%>
		<tr>
			<td><%=bean.getId() %></td>
			<td><%=bean.getPwd() %></td>
			<td><%=bean.getName() %></td>
			<td><%=bean.getEmail() %></td>
			<td><%=bean.getJoinDate() %></td>
		</tr>
<%
}
%>	
<tr>
			<td colspan="5" align="center">▼Iterator</td>
		</tr>
<%
	Iterator it = list.iterator();
	while(it.hasNext()){
		MemberBean bean = (MemberBean)it.next();
%>
		<tr>
			<td><%=bean.getId() %></td>
			<td><%=bean.getPwd() %></td>
			<td><%=bean.getName() %></td>
			<td><%=bean.getEmail() %></td>
			<td><%=bean.getJoinDate() %></td>
		</tr>
<%
}
%>	
	</table>
	
</body>
</html>