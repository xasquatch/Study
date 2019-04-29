<%@page import="com.bean.board.BoardDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");
	int num = Integer.parseInt(request.getParameter("num"));
	
%>
<jsp:useBean id="dao" class="com.bean.board.BoardDAOImpl"></jsp:useBean>
<%
	BoardDTO dto = dao.getBoard(num);

%>


<br><br>
<table align=center width=70% border=0 cellspacing=3 cellpadding=0>
 <tr>
  <td bgcolor=9CA2EE height=25 align=center class=m>글읽기</td>
 </tr>
 <tr>
  <td colspan=2>
   <table border=0 cellpadding=3 cellspacing=0 width=100%> 
    <tr> 
	 <td align=center bgcolor=#dddddd width=10%> 이 름 </td>
	 <td bgcolor=#ffffe8><%=dto.getName()%></td>
	 <td align=center bgcolor=#dddddd width=10%> 등록날짜 </td>
	 <td bgcolor=#ffffe8><%= dto.getRegdate()%></td>
	</tr>
    <tr>
	 <td align=center bgcolor=#dddddd width=10%> 메 일 </td>
	 <td bgcolor=#ffffe8 ><%=dto.getEmail()%></td> 
	 <td align=center bgcolor=#dddddd width=10%> 홈페이지 </td>
	 <td bgcolor=#ffffe8 ><a href="http://" target="_new">http://<%=dto.getHomepage()%></a></td> 
	</tr>
    <tr> 
     <td align=center bgcolor=#dddddd> 제 목</td>
     <td bgcolor=#ffffe8 colspan=3><%=dto.getSubject()%></td>
   </tr>
   <tr> 
    <td colspan=4><%=dto.getContent()%></td>
   </tr>
   <tr>
    <td colspan=4 align=right>
     <%=dto.getIp()%>로 부터 글을 남기셨습니다./  조회수 : <%=dto.getCount()%>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align=center colspan=2> 
	<hr size=1>
	[ <a href="javascript:list()">목 록</a> | 
	<a href="Update.jsp?num=<%=dto.getNum()%>">수 정</a> |
	<a href="Delete.jsp?num=<%=dto.getNum()%>">삭 제</a>] <br>
  </td>
 </tr>
</table>
</body>
</html>
