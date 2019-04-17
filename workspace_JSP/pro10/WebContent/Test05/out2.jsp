<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<%
	if(name!= null || name.length() != 0){
		out.println("<h1>"+name+", "+age+"<h1>");
	}else{
		out.println("<h1>이름을 입력하세요</h1>");
	}
%>	
<%-- <% Ctrl+Shift+/
	if(name != null || name.length() != 0){//name변수값이 null이 아니거나, name변수값에 길이가 0이 아니라면
%>
	<h1><%=name %>, <%=age %></h1>
<%
	}else{
%>
	<h1>이름을 입력하세요</h1>
	
<%
	}
%> --%>