<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="mymember.MemberDao"/>
<jsp:useBean id="dto" class="mymember.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

String date = year + "-" + month + "-" + day;

dto.setBirth(date);
dao.insertMember(dto);
%>

<script>
	alert("회원가입 성공");
	location.href="../index.jsp";
</script>