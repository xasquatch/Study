<%@page import="mymember.MemberDto"%>
<%@page import="java.util.Hashtable"%>
<%@page import="mymember.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("id");
String pass = request.getParameter("pass");

MemberDao dao = new MemberDao();
boolean check = dao.checkUser(id, pass);

if(check) {
	MemberDto dto = new MemberDto();
	dao.closeAccount(id, dto); //null값을 전달
	
	//해당 맴버가 작성한 진행중 게시물 삭제 (구현안됨)
	
	//로그아웃 시키고 원래 페이지로 이동
	session.invalidate();
	%>
	<script>
		alert("회원탈퇴 성공");
		location.href = "../index.jsp";
	</script>
	<%
} else {
	%>
	<script>
		alert("비밀번호가 틀립니다. 다시 입력해 주세요.");
		history.back();
	</script>
	<%
}
%>