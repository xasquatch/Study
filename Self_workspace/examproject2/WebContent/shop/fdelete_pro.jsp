<%@page import="board.FileBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fdelete_pro.jsp</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	String passwd = request.getParameter("passwd");
	
	FileBoardDAO fdao = new FileBoardDAO();
	
	int check = fdao.deletefBoard(num,passwd);
	if(check==1){
%>	
	<script type="text/javascript">
		alert("삭제되었습니다~!");
		location.href="fboard.jsp?pageNum=<%=pageNum%>";
	</script>
<% 		
	}else{
%>
	<script type="text/javascript">
		alert("비밀번호를 확인해주세요~");
		history.back();
	</script>
<%		
	}
%>

</body>
</html>