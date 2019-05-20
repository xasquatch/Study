<%@page import="mybean.MemberDto"%>
<%@page import="mybean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>modify_pro</title>
</head>
<body>
<%
	// request영역을 전달받아 request영역의 데이터 중 한글이 있다면 한글 인코딩 처리하기
	// 한글 깨짐 방지 처리
	request.setCharacterEncoding("UTF-8");
%>

	<jsp:useBean id="member" class="mybean.MemberDto"/>
	<jsp:setProperty property="*" name="member"/>

<%
	String id = request.getParameter("id");
	member.setId(id);
	
	// 수정할 회원정보를 담고있는 MemberDto을 DAO로 전달하여 회원정보 수정을 한다.
	MemberDao dao = MemberDao.getInstance();
    dao.updateMember(member); // 회원정보메서드 

%>	
<script type="text/javascript">
	alert("수정 완료!");
	location.href="../bootstrap/index.jsp";
</script>


</body>
</html>