<%@page import="com.bean.board.BoardDto"%>
<%@page import="com.bean.board.BoardDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../inc/top.jsp"%>
	<%
		//한글처리
		request.setCharacterEncoding("UTF-8");
	
		//Read.jsp페이지에서(글상세보기화면)답변 링크를 클릭했을때.. 전달받는 요청값 3가지 얻기
		int num = Integer.parseInt(request.getParameter("num")); //주글 번호
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		//DB에 저장된 주글정보를 검색해서 가져 오기 
		BoardDaoImpl dao = new BoardDaoImpl();
		//답변글을 작성하기 위해 몇가지 ~ 주글의 정보를 DB로 부터 검색하기 위해 getBoardInfo()메소드호출
		BoardDto dto = dao.getBoardInfo(num);
		//주글에 대한 제목 얻기
		String subject = dto.getSubject();
		//주글에 대한 글내용 얻기
		String content = dto.getContent().replace("\n", "<br>");
	%>
<center>
<br><br>
<table width=80% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=84F399 height=25 align=center>답변글쓰기</td>
 </tr>
</table>
<br>
<table width=80% cellspacing=0 cellpadding=3 align=center>
<form name=post method=post action="RplyProc.jsp" >

	<%--주글에 대한 답변글을 달기 위한 주글번호 전달 --%>
	<input type="hidden" name="num" value="<%=num%>">
	
	<%--주글을 검색하기 위해 사용했던 검색기준값, 검색어 같이 전달 --%>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	
	<%--추가1. 요청한 클라이언트의  ip정보를 PostProc.jsp에 요청 --%>
	<input type="hidden" name="ip" value="<%= request.getRemoteAddr()%>">
 <tr>
  <td align=center>
   <table border=0 width=100% align=center>
    <tr>
     <td width=10%>성 명</td>
     <td width=90%><input type=text name=name size=10 maxlength=8></td>
    </tr>
    <tr>
	 <td width=10%>E-Mail</td>
	 <td width=90%><input type=text name=email size=30 maxlength=30></td>
    </tr>
    <tr>
     <td width=10%>홈페이지</td>
     <td width=90%><input type=text name=homepage size=40 maxlength=30></td>
    </tr>
    <tr>
     <td width=10%>제 목</td>
     <td width=90%><input type=text name=subject size=50 maxlength=30 value="Re:<%=subject%>"></td>
    </tr>
    <tr>
     <td width=10%>내 용</td>
     <td width=90%><textarea name=content rows=10 cols=50><%=content%></textarea></td>
    </tr>
    <tr>
     <td width=10%>비밀 번호</td> 
     <td width=90% ><input type=password name=pass size=15 maxlength=15></td>
    </tr>
    <tr>
     <td colspan=2><hr size=1></td>
    </tr>
    <tr>
     <td><input type=submit value="등록" >&nbsp;&nbsp;
         <input type=reset value="다시쓰기">&nbsp;&nbsp;
     </td>
    </tr> 
   </table>
  </td>
 </tr>
</form> 
</table>
</center>
</body>
</html>