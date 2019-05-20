<%@page import="mybean.MemberDao"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>delete_pro</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	String password = request.getParameter("password");
	MemberDao dao = new MemberDao();
	
	int check = dao.deleteMember(id,password);
	if(check==1){
		session.invalidate(); //모든 세션정보 삭제
%>	
	<script type="text/javascript">
		alert("탈퇴 완료!");
		location.href="../bootstrap/index.jsp";
	</script>
<% 		
	}else{
%>
	<script type="text/javascript">
		alert("비밀번호를 확인해주세요!");
		history.back();
	</script>
<%		
	}
%>

</body>
</html>