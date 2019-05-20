<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/loginCheck.jsp" %>

<jsp:useBean id="dao" class="myboard.BoardDao"/>
<jsp:useBean id="dto" class="myboard.BoardDto"/>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:setProperty property="*" name="dto"/>

<%
if(request.getParameter("bin_price") == null) {
	dto.setBin_price(0);
}
if(request.getParameter("bid_price") == null) {
	dto.setBid_price(0);
}

String start_time = request.getParameter("st_time");
String end_time = request.getParameter("en_time");
String start_hour = request.getParameter("start_hour");
String start_minute = request.getParameter("start_minute");

String st = start_time + " " + start_hour + ":" + start_minute + ":00";
String et = end_time + " " + start_hour + ":" + start_minute + ":00";

dto.setStart_time(dao.stringToTimestamp(st));
dto.setEnd_time(dao.stringToTimestamp(et));
dao.updateBoard(dto);
%>

<script>
	alert("글 수정 완료");
	location.href = "../index.jsp";
</script>