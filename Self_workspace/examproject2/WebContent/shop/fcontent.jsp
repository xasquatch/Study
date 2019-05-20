<%@page import="java.util.List"%>
<%@page import="board.CommentDAO"%>
<%@page import="board.CommentDTO"%>
<%@page import="board.FileBoardDTO"%>
<%@page import="board.FileBoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 글 상세보기  ▒</title>
<style type="text/css">
.del:hover{
	cursor: pointer;
}

</style>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	// fboard.jsp페이지에서 글 제목 클릭 시 전달하여 넘어온 num, pageNum 가져오기
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	String id = (String) session.getAttribute("id");
	
	FileBoardDAO dao = new FileBoardDAO();
	
	// 조회 수 증가 메소드
	dao.updateReadCount(num);  
	
	// 글 번호를 넘겨서 DB로부터 글 정보 가져오기
	FileBoardDTO dto = dao.getBoard(num);
	
	int DBnum = dto.getNum(); // 글번호
	int DBReadcount = dto.getReadcount(); // 조회수
	String DBName = dto.getName(); // 작성자
	Timestamp DBDate = dto.getDate(); // 작성일
	String DBSubject = dto.getSubject(); // 글제목
	String DBFile = dto.getFile();
	String DBContent = ""; // 글 내용
	
	// 글 내용이 존재한다면
	if(dto.getContent() != null)
		DBContent = dto.getContent().replace("\r\n", "<br>");
	
	int DBRe_ref = dto.getRe_ref();
	int DBRe_lev = dto.getRe_lev();
	int DBRe_seq = dto.getRe_seq();
	
	//댓글 달기 객체 생성
	CommentDAO cdao = new CommentDAO();
	int count = dao.getBoardCount();
	
	
%>
<body>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<div class="container" style="text-align:center;">
		<article>
			File Notice Content
		<table id="notice" align="center">
			<tr>
				<td>글번호</td>
				<td><%=DBnum %></td>
				<td>조회수</td>
				<td><%=DBReadcount%></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=DBName %></td>
				<td>작성일</td>
				<td><%=DBDate %></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><%=DBSubject %></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>파일</td>
					<td>
						<%
							if (dto.getFile()==null) {
								out.print("첨부파일이 없습니다.");
							} else {
									if (id == null){
						%>				<%=dto.getFile()%>
						<%			}else{
						%>				<a href='fdown.jsp?fileName=<%=dto.getFile()%>'><%=dto.getFile()%></a>
						<%			}
							}
						%>
					</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><%=DBContent %></td>
				<td></td>
				<td></td>
			</tr>
		</table><br>
		<div align="center">
		<%
			List list = null;

			if (id != null) {
		%>
			<form action="comment_pro.jsp" method="post">
				<input type="hidden" name="ref" value="<%=dto.getNum()%>" > 
				<input type="hidden" name="page" value="<%=pageNum%>" > 
				<input type="hidden" name="id" value="<%=id%>">
				
				<table class="comment" style="width: 670px; align: center; padding: 15px;">
					<tr>
						<td align="center" width="174">댓글</td>
						<td colspan="2">
							<textarea name="content" rows="3" cols="60" style="margin: 10px 5px;"></textarea>
								<input type="submit" name="register" value="댓글입력" class="board_btn01"> 
						</td>
					</tr>
				</table>
			</form>
			<%
				}
			%>
			<div style="height: 20px;"></div>
			<%
			 if(count!=0){ 
				 list = cdao.getBoard(num);	
			%> 
				<table class="comment" style="width:670px; align:center; border: 1px solid gray;">
			<%
				for(int i=0; i<list.size();i++){
					CommentDTO cdto  = (CommentDTO)list.get(i);
					
					// fboard 테이블에 있는 num값과 comment table에있는 ref 값이 같다면	
					if(dto.getNum()==cdto.getRef()) {
			%>
						<tr style="border-bottom: 1px solid gray;">
							<td align="center" width="150" height="30" bgcolor="#efeff5">
								<%=cdto.getId() %>
							</td> 
							<td style="border-left: 1px solid gray;">&nbsp;&nbsp;<%=cdto.getContent()%>
							</td>
							<td width="30">
						<%
							// 게시판 글 작성자 or 댓글 작성자만 삭제 가능
							if (DBName.equals(id)||cdto.getId().equals(id)) {
						%>		<img src="../img/del.PNG" class="del" 
									 onclick="location.href='commentDelete_pro.jsp?commentNum=<%=cdto.getNum()%>&pageNum=<%=pageNum%>&num=<%=dto.getNum()%>'">
						<%
							}
						%>
							</td>
							<td align="center" width="100" bgcolor="#efeff5" style="border-left: 1px solid gray;">
								<%=cdto.getReg_date() %>
							</td>
						</tr>
					
			<%		}
				}
			%>
				</table>
			<% 
				} 
			%>
	<%-- <input type="button" value="답글쓰기" class="board_btn01" 
				onclick="location.href='freWrite.jsp?num=<%=DBnum%>&re_ref=<%=DBRe_ref%>&re_lev=<%=DBRe_lev%>&re_seq=<%=DBRe_seq%>'"> --%>
			<br>
			<div id="table_search">
				<%
					if (DBName.equals(id)) {
				%>
				<input type="button" value="글수정" class="board_btn01" 
						onclick="location.href='fupdate.jsp?pageNum=<%=pageNum%>&num=<%=DBnum%>'">
				<input type="button" value="글삭제" class="board_btn01" 
						onclick="location.href='fdelete.jsp?pageNum=<%=pageNum%>&num=<%=DBnum%>'">
				<%
				}
				%> 
				<input type="button" value="목록보기" class="board_btn01" 
						onclick="location.href='fboard.jsp?pageNum=<%=pageNum%>'">
			</div>
		</div> 
	</div>
	</article>

	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>