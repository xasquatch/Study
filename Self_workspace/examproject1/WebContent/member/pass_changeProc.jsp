<%@page import="mymember.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("id");
String curr_pass = request.getParameter("curr_pass");
String pass = request.getParameter("pass");
if(id != null) {
	MemberDao dao = new MemberDao();
	boolean check = dao.checkUser(id, curr_pass);
	
	if(check) {
		dao.updatePass(id, pass);
		%>
		<script>
			alert("비밀번호 변경 성공!");
			location.href = "pass_check.jsp";
		</script>
		<%
	} else {
		%>
		<script>
			alert("현재 비밀번호가 틀립니다. 다시 입력해주세요.");
			history.back();
		</script>
		<%
	}
} else {
	%>
	<script>
		alert("로그인 후 다시 이용해주세요.");
		location.href = "../index.jsp";
	</script>
	<%
}
%>