<%@page import="board.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>commentDelete_pro</title>
</head>
<body>
<%
	int commentNum = Integer.parseInt(request.getParameter("commentNum"));
	int num = Integer.parseInt(request.getParameter("num"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	
	CommentDAO cdao = new CommentDAO();
	
	int check = cdao.deleteComment(commentNum);
	if(check==1){
%>	
	<script type="text/javascript">
		alert("댓글 삭제 완료!");
		location.href="fcontent.jsp?num=<%=num%>&pageNum=<%=pageNum%>";
	</script>
<% 		
	}else{
%>
	<script type="text/javascript">
		alert("댓글 삭제 실패");
		history.back();
	</script>
<%		
	}
%>

</body>
</html>