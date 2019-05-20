<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	request.setCharacterEncoding("utf-8");	%>
	
	<!-- 회원가입창(memberform.jsp)에서 입력한 요청값을 얻어 memberbean객체의 모든 속성에 저장 -->
	<jsp:useBean id="m1" class="sec01.ex01.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="m1"/>
	
	<!-- id속성값을 memberlist로 하는 arrayList객체를 생성 -->
	<jsp:useBean id="memberlist" class="java.util.ArrayList"></jsp:useBean>
	
	<%
		//자바코드로 새로운 회원정보를 저장하는 MemberBean객체 생성시 변수랑 세팅
		MemberBean m2 = new MemberBean("son","1234","손흥민","song@test.com",new Date(System.currentTimeMillis())); 
		//위 두개의 memberbean객체를 arraylist에 저장합니다.
		
		memberlist.add(m1);
		memberlist.add(m2);
		
	%>
	<table border="1" align="center">
		<tr align="center" bgcolor="aqua">
			<td width="20%"><b>ID</b></td>
			<td width="20%"><b>PW</b></td>
			<td width="20%"><b>NAME</b></td>
			<td width="20%"><b>EMAIL</b></td>
			<td width="20%"><b>DATE</b></td>
		</tr>
		<!-- ▽ArrayList에 접근하여 인덱스 위치가 0인 위치에 저장되어 있는 memberBean객체를 얻어
			memberbean객체의 속성값을 출력
		 -->
		<tr>
			<td>${memberlist[0].id}</td>
			<td>${memberlist[0].pwd}</td>
			<td>${memberlist[0].name}</td>
			<td>${memberlist[0].email}</td>
			<td>${memberlist[0].joinDate}</td>
		</tr>
		<tr>
			<td>${memberlist[1].id}</td>
			<td>${memberlist[1].pwd}</td>
			<td>${memberlist[1].name}</td>
			<td>${memberlist[1].email}</td>
			<td>${memberlist[1].joinDate}</td>
		</tr>
	</table>
	<br>
	${memberlist[0]}<br><br>
	
	${memberlist[1]}<br>
	
	<%
		String i = "";
		Iterator it = (Iterator)memberlist.iterator();
		while(it.hasNext()){
			i += it.next();
		}
	
	
	%>
	<br><BR>
	<%=i %>
	
	
</body>
</html>