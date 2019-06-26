<%@page import="java.sql.Timestamp"%>
<%@page import="com.bean.board.BoardDto"%>
<%@page import="com.bean.board.BoardDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//List.jsp페이지에서 글제목을 클릭했을떄...
	//읽을 글번호, 검색기준값, 검색어 를 전달 받아야함
	request.setCharacterEncoding("UTF-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	String keyField = request.getParameter("keyField");
	String keyWord = request.getParameter("keyWord");
	
	BoardDaoImpl dao = new BoardDaoImpl(); //DB작업 관련 객체 생성

	//DB로 부터 하나의 글을 검색하기 위해 메소드 호출시 글번호 전달
	BoardDto dto = dao.getBoard(num);
	
	//DB로부터 하나의 글을 검색한 정보는 BoardDto객체의 각변수에 저장되어 있으므로
	//getter메소드를 활용하여 응답값을 얻자
	String name = dto.getName();
	String email = dto.getEmail();
	String homepage = dto.getHomepage();
	String subject = dto.getSubject();
	Timestamp regdate = dto.getRegdate();
					//화면에 적은 엔터키값을 <br>로 처리하겠다 는 뜻
	String content = dto.getContent().replace("\n", "<br>");
	String ip = dto.getIp();
	int count = dto.getCount();
	
%>



<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">

	<script type="text/javascript">
		//목록 링크 클릭했을때..호출되는 함수로 아래쪽의 <form>태그 전송 담당
		function fnList() {
			document.list.submit();
		}
	
	</script>


</head>

<body>
<%@ include file="../inc/top.jsp"%>
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
	 <td bgcolor=#ffffe8><%=name%></td>
	 <td align=center bgcolor=#dddddd width=10%> 등록날짜 </td>
	 <td bgcolor=#ffffe8><%=regdate%></td>
	</tr>
  
    <tr> 
     <td align=center bgcolor=#dddddd> 제 목</td>
     <td bgcolor=#ffffe8 colspan=3><%=subject%></td>
   </tr>
   <tr> 
    <td colspan=4><%=content%></td>
   </tr>
   <tr>
    <td colspan=4 align=right>
     <%=ip%> 로 부터 글을 남기셨습니다./  조회수 : <%=count %> 
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align=center colspan=2> 
	<hr size=1>
	[ <a href="List.jsp" onclick="fnList(); return false;">목 록</a> | 
	<a href="Update.jsp?num=<%=num%>">수 정</a> |
	<%--답변 링크를 클릭했을떄..Reply.jsp페이지 요청시 3개의 값을 전달 --%>
	<a href="Reply.jsp?num=<%=num%>&keyField=<%=keyField%>&keyWord=<%=keyWord%>">답변</a> |
	
	<a href="Delete.jsp?num=<%=num%>">삭 제</a> ]<br>
  </td>
 </tr>
</table>
	
	<form action="List.jsp" name="list" method="post">
		<input type="hidden" name="keyField" value="<%=keyField%>">
		<input type="hidden" name="keyWord" value="<%=keyWord%>">
	</form>
	
<%@ include file="../inc/bottom.jsp"%>
</body>
</html>





