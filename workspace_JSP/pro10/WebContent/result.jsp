<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 출력창</title>
</head>
<body>
	<h1>결과 출력</h1>
	<%
		//login.html페이지에서 입력한 id와 비밀번호가 request객체영역에 저장되어
		//현재 페이지로 전달되어 왔습니다.
		//그러므로 request객체영역에 저장된 값(요청값)을 꺼내서 사용해야함
		/*요약 : 요청값 전달받기*/
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
	%>
	<%-- 	입력한 id와 비밀번호를 표현식을 사용하여 출력 --%>
	<h1>
		입력한 아이디 :
		<%=user_id%></h1>
	<h1>
		입력한 비밀번호 :
		<%=user_pw%></h1>

	<%
		//ID가 정상적으로 입력되었는지 체크합니다.
		if (user_id == null || user_id.length() == 0) {
	%>
		아이디를 입력하세요<BR>
		<a href="/pro10/login.html">로그인하기</a>
	<%
		}else if(user_id.equals("admin")){
			//ID가 admin인지 다시 체크

	%>
		<h1>관리자 로그인</h1>
		<form action="">
			<input type="button" value="회원정보 삭제하기">
			<input type="button" value="회원정보 수정하기">
		</form>
	<%	
		}else{
	%>
		<h1>환영합니다. <%=user_id%>님</h1>
	<%
		}
	%>
	

</body>
</html>