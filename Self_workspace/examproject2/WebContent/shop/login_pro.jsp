<%@page import="mybean.MemberDao"%>
<%@page import="javax.naming.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//로그인 요청시 입력한 값을  request영역으로 전달 받는다.
	String id = request.getParameter("id"); //입력한 id   
	String passwd = request.getParameter("passwd"); //입력한 pwd
	
	MemberDao dao = new MemberDao();
	
	int check = dao.userCheck(id, passwd);
	
	if(check==1){
		session.setAttribute("id", id);
		response.sendRedirect("../bootstrap/index.jsp");
	}else if(check==0){
%>	
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.back();
	</script>
<%
	}else{
%>	
	<script type="text/javascript">
		alert("존재하지 않는 아이디입니다.");
		history.back();
	</script>
<%	
	}
%>