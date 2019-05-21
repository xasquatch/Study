<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dao" class="mymember.MemberDao"/>
<jsp:useBean id="dto" class="mymember.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String date = year + "-" + month + "-" + day;
dto.setBirth(date);
dto.setId((String)session.getAttribute("id"));

dao.updateMember(dto);
%>

<script>
	alert("회원정보 수정 성공!");
	location.href = "change_info.jsp";
</script>