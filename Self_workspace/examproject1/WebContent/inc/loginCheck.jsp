<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if((String)session.getAttribute("id") == null) {
	%>
	<script>
		alert("로그인 후 이용해주세요.");
		history.back();
	</script>
	<%
}
%>