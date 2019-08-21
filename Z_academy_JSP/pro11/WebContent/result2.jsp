<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>	
<%!
	//login2로 전달할 오류 메시지를 저장
	String msg = "아이디를 입력하라굿";
%>
<%
	//로그인시 입력한 이름을 가져옴
	String userID = request.getParameter("userID");
	
	if(userID.length()==0){
%>
		<jsp:forward page="login2.jsp">
			<jsp:param value="<%=msg%>" name="msg"/>
		</jsp:forward>
<%
	}	
%>
		<h1>환영합니다 <%=userID%>님</h1>