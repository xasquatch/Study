<%@page import="java.sql.Date"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
	예제 설명
	<c:forEach>태그를 이용해 ArrayList에 저장된 회원 정보를 출력
	<c:forEach>태그를 이용하면 ArrayList에 저장된 객체에 편리하게 접근할 수 있습니다.
	<c:forEach>태그의 반복변수 i를 ArrayList의 인덱스 위치값으로 사용해서 저장된 회원정보를 차례대로 출력함
 --%>
<%
	request.setCharacterEncoding("utf-8");
	List<MemberBean> mlist = new ArrayList();
	MemberBean bean1 = new MemberBean("son","1234","손흥민","son@test.com",new Date(System.currentTimeMillis()));
	MemberBean bean2 = new MemberBean("ki","4213","기성룡","ki@test.com",new Date(System.currentTimeMillis()));
	MemberBean bean3 = new MemberBean("park","7895","박지성","park@test.com",new Date(System.currentTimeMillis()));
	mlist.add(bean1);
	mlist.add(bean2);
	mlist.add(bean3);
%> 	
<c:set value="<%=mlist%>" var="list" scope="page"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgray">
			<th width="7%">ID</th>
			<th width="7%">PW</th>
			<th width="7%">NAME</th>
			<th width="7%">EMAIL</th>
			<th width="7%">JOIN DATE</th>
		</tr>
			<c:forEach var="i" begin="0" end="2" step="1">
				<!-- 반복변수 i를 arraylist의 인덱스 위치값을 이용해 memberbean객체를 얻어 차례대로 출력 -->
				<tr align="center">
					<td>${list[i].id}</td>
					<td>${list[i].pwd}</td>
					<td>${list[i].name}</td>
					<td>${list[i].email}</td>
					<td>${list[i].joinDate}</td>
				</tr> 
			</c:forEach>
				<tr><th colspan="5">core forEach</th></tr>
			<c:forEach var="i" items="${list}" >
				<tr align="center">
					<td>${i.id}</td>
					<td>${i.pwd}</td>
					<td>${i.name}</td>
					<td>${i.email}</td>
					<td>${i.joinDate}</td>
				</tr> 
			</c:forEach>
				<tr><th colspan="5">JAVA CODE</th></tr>
				<%
					for(MemberBean ob : mlist){
				%>
					<tr align="center">
						<td><%=ob.getId()%></td>
						<td><%=ob.getPwd()%></td>
						<td><%=ob.getName()%></td>
						<td><%=ob.getEmail()%></td>
						<td><%=ob.getJoinDate()%></td>
					</tr>
				<%}
				%>	
	</table>
</body>
</html>