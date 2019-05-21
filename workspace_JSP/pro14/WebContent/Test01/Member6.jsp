<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="sec01.ex02.MemberBean" />
<jsp:setProperty property="*" name="bean"/>

<jsp:useBean id="addr" class="sec01.ex02.Address"></jsp:useBean>
<!-- address빈을 생성한 후 도시 이름(city)와 우편번호(zipcode)를 설정 -->
<jsp:setProperty property="city" name="addr" value="서울"/>
<jsp:setProperty property="zipcode" name="addr" value="07654"/>
<%
	//memberbean객체의 addr변수의 address빈을 설정합니다.
	bean.setAddr(addr);
	bean.setJoinDate(new Date(System.currentTimeMillis()));	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="powderblue">
			<td width="20"><b>ID</b></td>
			<td width="20"><b>PW</b></td>
			<td width="20"><b>NAME</b></td>
			<td width="20"><b>EMAIL</b></td>
			<td width="20"><b>ZIPCODE</b></td>
			<td width="20"><b>ADDRESS</b></td>
			<td width="20"><b>JOIN DATE</b></td>
		</tr>
		<tr>
			<td>${bean.id }</td>
			<td>${bean.pwd }</td>
			<td>${bean.name }</td>
			<td>${bean.email }</td>
			<td><%=bean.getAddr().getZipcode()%></td>
			<td><%=bean.getAddr().getCity()%></td>
			<td>${bean.joinDate }</td>
		</tr>
		<tr>
			<td>${bean.id }</td>
			<td>${bean.pwd }</td>
			<td>${bean.name }</td>
			<td>${bean.email }</td>
			<td>${bean.addr.zipcode }</td>
			<td>${bean.addr.city }</td>
			<td>${bean.joinDate }</td>
		</tr>
	</table>
</body>
</html>