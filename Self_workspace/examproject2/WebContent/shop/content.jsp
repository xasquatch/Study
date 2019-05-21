<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 글 상세보기 ▒</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	// board.jsp페이지에서 글 제목 클릭 시 전달하여 넘어온 num, pageNum 가져오기
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");

	BoardDAO dao = new BoardDAO();

	// 조회 수 증가 메소드
	dao.updateReadCount(num);

	// 글 번호를 넘겨서 DB로부터 글 정보 가져오기
	BoardBean boardBean = dao.getBoard(num);

	int DBnum = boardBean.getNum(); // 글번호
	int DBReadcount = boardBean.getReadcount(); // 조회수
	String DBName = boardBean.getName(); // 작성자
	Timestamp DBDate = boardBean.getDate(); // 작성일
	String DBSubject = boardBean.getSubject(); // 글제목
	String DBContent = ""; // 글 내용
	// 글 내용이 존재한다면
	if (boardBean.getContent() != null)
		DBContent = boardBean.getContent().replace("\r\n", "<br>");

	int DBRe_ref = boardBean.getRe_ref();
	int DBRe_lev = boardBean.getRe_lev();
	int DBRe_seq = boardBean.getRe_seq();
%>
<body>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 80px;"></div>

	<div class="container" style="text-align: center;">
		<article> Notice Content
		<table id="notice" align="center">
			<tr>
				<td>글번호</td>
				<td><%=DBnum%></td>
				<td>조회수</td>
				<td><%=DBReadcount%></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=DBName%></td>
				<td>작성일</td>
				<td><%=DBDate%></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><%=DBSubject%></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><%=DBContent%></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<br>
		<br>

		<div id="table_search">
			<%
				String id = (String) session.getAttribute("id");
				// 세션 id값이 글쓴 사람이랑 일치하면 글 수정, 글 삭제 버튼 보이기
				if (DBName.equals(id)) {
			%>
			<input type="button" value="글수정" class="board_btn01"
				onclick="location.href='update.jsp?pageNum=<%=pageNum%>&num=<%=DBnum%>'">
			<input type="button" value="글삭제" class="board_btn01"
				onclick="location.href='delete.jsp?pageNum=<%=pageNum%>&num=<%=DBnum%>'">
			<%
				}
			%>
			<input type="button" value="답글쓰기" class="board_btn01"
				onclick="location.href='reWrite.jsp?num=<%=DBnum%>&re_ref=<%=DBRe_ref%>&re_lev=<%=DBRe_lev%>&re_seq=<%=DBRe_seq%>'">
			<input type="button" value="목록보기" class="board_btn01"
				onclick="location.href='board.jsp?pageNum=<%=pageNum%>'">
		</div>
		</article>
	</div>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>


</body>
</html>