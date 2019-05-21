<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
	<!-- memberForm.jsp에서 입력한 회원정보를 request영역에서 꺼내와서
		memberbean객체의 각변수에 저장 -->
<jsp:useBean id="bean1" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="bean1"/>
<!-- MemberBean객체를 다시 저장할 ArrayList객체를 생성 -->
<jsp:useBean id="list" class="java.util.ArrayList" scope="page"></jsp:useBean>
<!-- 회원정보를 저장할 hashmap객체를 생성 -->
<jsp:useBean id="map" class="java.util.HashMap"></jsp:useBean>
<%
	//hashmap객체에 key, value 값을 쌍으로 회원정보를 저장합니다.
	map.put("id", "park2");
	map.put("pwd", "4321");
	map.put("name", "지성박");
	map.put("email", "park@test.com");
	map.put("date", new Date(System.currentTimeMillis()));
	
	/* 회원정보를 저장하는 memberbean객체를 자바코드로 생성 */
	MemberBean bean2 = new MemberBean("son","1234","son흥민","ultimate@SON.com",new Date(System.currentTimeMillis()));
	
	/* arraylist에 memberform.jsp에서 전송된 회원정보(memberbean객체)를 arraylist에 추가 */
	list.add(bean1);
	/* 자바코드로 생성한 memberbean객체도 추가 */ 
	list.add(bean2);
	
	//hashmap객체에 2명의 회원정보(memberbean객체들)을 저장하고 있는 arraylist추가
	map.put("memberlist", list);
	
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
			<td width="20"><b>JOIN DATE</b></td>
		</tr>
		<tr align="center">
			<!-- HashMap 이름 뒤에 .(마침표)연산자로 저장시 사용한 key를 사용하여 value를 가져옴 --> 
			<td>${map.id}</td>
			<td>${map.pwd}</td>
			<td>${map.name}</td>
			<td>${map.email}</td>
			<td>${map.date}</td>		
		</tr>
		<tr align="center">
			<!-- HashMap에 저장된 arraylist에 마침표로 접근한 후 다시 각각의 memberbean객체의 속성에 마침표로 다시 접근하여 첫번쨰 회원정보를 출력할 수 있다.--> 
			<td>${map.memberlist[0].id}</td>
			<td>${map.memberlist[0].pwd}</td>
			<td>${map.memberlist[0].name}</td>
			<td>${map.memberlist[0].email}</td>
			<td>${map.memberlist[0].joinDate}</td>		
		</tr>
		<tr align="center">
			<!-- HashMap에 저장된 arraylist에 마침표로 접근한 후 다시 각각의 memberbean객체의 속성에 마침표로 다시 접근하여 첫번쨰 회원정보를 출력할 수 있다.--> 
			<td>${map.memberlist[1].id}</td>
			<td>${map.memberlist[1].pwd}</td>
			<td>${map.memberlist[1].name}</td>
			<td>${map.memberlist[1].email}</td>
			<td>${map.memberlist[1].joinDate}</td>		
		</tr>
	</table>
	<%-- hashmap에 저장된 객체에 저장하는 방법
	${hishmap객체이름.키이름 } --%>
	
	\${map} :<BR> ${map}<BR><BR>
	\${map.memberlist[0]} :<BR> ${map}<BR><BR>
	\${map.memberlist[1]} :<BR> ${map}<BR><BR>
</body>
</html>