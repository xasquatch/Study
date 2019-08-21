<%@page import="sec02.ex01.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB로부터 검색해온 회원정보 출력창</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgray">
			<td width=7%><b>ID</b></td>
			<td width=7%><b>PW</b></td>
			<td width=7%><b>NAME</b></td>
			<td width=7%><b>email</b></td>
			<td width=7%><b>JOIN DATE</b></td>
		</tr>
			<%
				List<MemberBean> list = (List)request.getAttribute("list"); 
				for(int i = 0; i < list.size(); i++ ){
				%>
				<tr>
					<td><%=list.get(i).getId()%></td>
					<td><%=list.get(i).getPwd()%></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getEmail()%></td>
					<td><%=list.get(i).getJoindate()%></td>
				</tr>
			<%} %>
		<tr>
		<c:choose>
			<c:when test="${empty requestScope.list }">
				<tr>
					<td colspan="5">등록된 회원이 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${not empty requestScope.list }">
				<c:forEach items="${list}" var="mem">
					<tr align="center">
						<td>${mem.id }</td>
						<td>${mem.pwd }</td>
						<td>${mem.name }</td>
						<td>${mem.email }</td>
						<td>${mem.joindate }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
		
		
		
	</table>
	
	
	
</body>
</html>