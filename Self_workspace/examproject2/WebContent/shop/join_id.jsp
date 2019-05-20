<%@page import="mybean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>▒ 아이디 중복 확인 ▒</title>
<style type="text/css">
div.total {
	margin: 20px auto;
	padding: 15px;
	width: 280px;
}
</style>
<script type="text/javascript">
	function ok() {
		var id = document.wfr.userid.value;
		opener.document.f.id.value = id;
		window.close();
	}
</script>
</head>
<body>
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// String userid = 파라미터값 불러오기
		String userid = request.getParameter("userid");

		// MemberDAO 객체 생성
		// check가 1일 경우 사용가능한 아이디
		MemberDao mdao = new MemberDao();
		int check = mdao.JoinCheck(userid);
	%>
	<div class="total">
		<form action="join_id.jsp" method="post" name="wfr">
			<input type="text" name="userid" value="<%=userid%>"> 
			<input type="submit" value="중복확인" style="text-align: center; font-weight: bold;">
		</form>
		<%
			if (check == 1){
				out.println("<br>사용 가능한 아이디입니다.");
		%>
		<input type="button" value="사용하기" style="font-weight: bold;" onclick="ok()">
		<%
			} else if (check == 0){
				out.println("<br>중복된 아이디입니다.");
			}
		%>
	</div>
</body>
</html>