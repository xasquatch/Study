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
<link type="text/css" rel="stylesheet" href="../css/write.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 게시판 ▒</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String search = request.getParameter("search");

	// DB작업 객체 생성
	BoardDAO boardDAO = new BoardDAO();

	// 전체 글 개수
	int count = boardDAO.getBoardCount();
	
	// 하나의 화면마다 보여줄 글 개수 
	int pageSize = 8;
	
	// 현재 보여질 페이지 번호 가져오기
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null||pageNum.isEmpty()){
		pageNum = "1";
	}
	
	// 현재 보여질 페이지 번호 "1"을 정수 1로 변경
	int currentPage = Integer.parseInt(pageNum);
	
	// 각 페이지마다 맨 위에 첫번째로 보여질 시작 글번호
	int startRow = (currentPage-1)*pageSize;

	// 게시판 글 객체 저장
	List<BoardBean> list = null;
	
	if(count>0){
		list = boardDAO.getBoardList(startRow,pageSize);
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd");
%>
<body>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<!-- 게시판 -->
	<div class="container" style="text-align:center;">
	<article>
		Notice [ 전체 글 개수 : <%=count %> ]
		<table id="notice" align="center">
			<tr style="background-color: white; cursor: default;">
				<th class="tno">No.</th>
				<th class="ttitle">Title</th>
				<th class="twrite">Writer</th>
				<th class="tdate">Date</th>
				<th class="tread">Read</th>
			</tr>
			<%
			if(count>0){
				for(int i=0;i<list.size();i++){
					BoardBean bean = list.get(i);
		%>	<tr style="cursor: default;">
				<td><%=bean.getNum() %></td>
				<td class="left">
				<%
					// 답변글에 대한 들여쓰기 값 저장
					int wid = 0;				
					
					// 들여쓰기 값이 0보다 클 경우
					if(bean.getRe_lev()>0){
						wid = bean.getRe_lev()*10;	
				%>
					<img src="../img/null.gif" width="<%=wid%>" height="15">
					<img src="../img/reply_icon.gif">
				<%	
					}
				%>	<a href="content.jsp?num=<%=bean.getNum()%>&pageNum=<%=pageNum%>">
						<%=bean.getSubject() %>
					</a>
					</td>
				<td><%=bean.getName() %></td>
				<td><%=sdf.format(bean.getDate()) %></td>
				<td><%=bean.getReadcount() %></td>
			</tr>
			<% 		
				}
			}else{	
			%>
			<tr>
				<td colspan="5">게시판 글 없음</td>
			</tr>
			<%
			}
		%>
		</table><br>
		<div id="table_search" style="float:inherit;">
			<form action="boardSearch.jsp">
				<input type="text" name="search"> 
				<input type="submit" value="search" class="board_btn01">
				<%
					String id = (String) session.getAttribute("id");
					if (id != null) {
				%>
				<span id="table_search" style="float: none;">
					<input class="board_btn01" type="button" value="글쓰기" onclick="location.href='write.jsp'">
				</span>
				<%
						}
				%> 
			</form>	
		</div>
		<div class="clear"></div>
		<%
			if(count>0){
				// 전체페이지 수 = 전체 글 / 한페이지 보여줄 글 수 +(전체글 수를 한페이지에 보여줄 글 수로 나눈 나머지)  
				int pageCount = count/pageSize+(count%pageSize==0?0:1);
				int pageBlock = 5;
				// 한 화면(블럭)에 보여줄 페이지 수 +1
				int startPage=((currentPage/pageBlock)-(currentPage%pageBlock==0?1:0))*pageBlock+1;
				
				int endPage = startPage+pageBlock-1;
				
				if(endPage>pageCount){ // 끝페이지 번호가 전체 페이지 수보다 클 때
					endPage = pageCount; // 끝페이지 번호를 전페 페이지 수로 저장
				}
				if(startPage>pageBlock){
			%>		<a href="board.jsp?pageNum=<%=startPage-pageBlock %>&search=<%=search%>">[이전]</a>
			<%	}
				for(int i=startPage;i<=endPage;i++){
			%>		<a href="board.jsp?pageNum=<%=i %>">[<%=i %>]</a>
			<%	}
				if(endPage<pageCount){
			%>		<a href="board.jsp?pageNum=<%=startPage+pageBlock %>&search=<%=search%>">[다음]</a>		
			<% }
			}
		%>
	</article>
	</div><!-- 게시판 끝 -->
	<div style="height: 100px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>