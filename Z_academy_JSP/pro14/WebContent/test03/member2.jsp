<%@page import="java.sql.Date"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="list" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="map" class="java.util.HashMap"></jsp:useBean>
<%
	map.put("id","park2");
	map.put("pwd","4321");
	map.put("name","박지성");
	map.put("email","park@test.com");
	map.put("joinDate",new Date(System.currentTimeMillis()));

	MemberBean m1 = new MemberBean("son","1234","손흥민","son@test.com",new Date(System.currentTimeMillis()));
	MemberBean m2 = new MemberBean("ki","1334","기성룡","ki@test.com",new Date(System.currentTimeMillis()));
	
	list.add(m1);
	list.add(m2);
	
	map.put("memberlist", list);
%>
	<%-- <c:set>태그를 이용해 hashmap에 저장되어 있는 arraylist에 접근하기 위해 사용하기 편리한 이름으로 변수에 저장 --%>
<c:set var="list" value="${map.memberlist}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr bgcolor="aqua" align="center">
			<th width="20">ID</th>
			<th width="20">PW</th>
			<th width="20">NAME</th>
			<th width="20">EMAIL</th>
			<th width="20">JOINDATE</th>
		</tr>
		<tr><th colspan="5" bgcolor="lightgray">HASHMAP (print for EL tag )</th></tr>
		<tr align="center">
			<td>${map.id }</td>
			<td>${map.pwd }</td>
			<td>${map.name }</td>
			<td>${map.email }</td>
			<td>${map.joinDate }</td>
		</tr>
		<tr><th colspan="5" bgcolor="lightgray">HASHMAP key = memberlist[0] (print for EL tag )</th></tr>
			<tr align="center">
			<td>${map.memberlist[0].id }</td>
			<td>${map.memberlist[0].pwd }</td>
			<td>${map.memberlist[0].name }</td>
			<td>${map.memberlist[0].email }</td>
			<td>${map.memberlist[0].joinDate }</td>
		</tr>
		<tr><th colspan="5" bgcolor="lightgray">HASHMAP key = memberlist[1] (print for EL tag )</th></tr>
		<tr align="center">
			<td>${map.memberlist[1].id }</td>
			<td>${map.memberlist[1].pwd }</td>
			<td>${map.memberlist[1].name }</td>
			<td>${map.memberlist[1].email }</td>
			<td>${map.memberlist[1].joinDate }</td>
		</tr>
		<tr><th colspan="5" bgcolor="lightgray">core set적용 (print for EL tag )</th></tr>
		<tr>
			<td>${list[0].id}</td>
			<td>${list[0].pwd}</td>
			<td>${list[0].name}</td>
			<td>${list[0].email}</td>
			<td>${list[0].joinDate}</td>
		</tr>
		<tr>
			<td>${list[1].id}</td>
			<td>${list[1].pwd}</td>
			<td>${list[1].name}</td>
			<td>${list[1].email}</td>
			<td>${list[1].joinDate}</td>
		</tr>
	</table>
</body>
</html>