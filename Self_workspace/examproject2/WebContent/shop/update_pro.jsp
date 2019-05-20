<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>update_pro.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String pageNum = request.getParameter("pageNum");
	
%>
<jsp:useBean id="bBean" class="board.BoardBean"/>
<jsp:setProperty property="*" name="bBean"/>

<%	
	BoardDAO bdao = new BoardDAO();

	int check = bdao.updateBoard(bBean);
	
	if(check==1){
%>	
	<script type="text/javascript">
		alert("수정되었습니다~!");
		location.href="board.jsp?pageNum=<%=pageNum%>";
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