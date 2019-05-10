<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="model1.Board" %>
<%@ page import="model1.BoardDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD LIST(모델1 방식)</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<h1>BOARD LIST(모델1 방식)</h1>
<%
	// boardList.jsp페잊는 currentPage라는 매개변수가 넘어와야 하는데
	// 매개변수가 안 넘어오는 경우 currentPage를 1이 대입된다.
	int currentPage = 1;
	if(request.getParameter("currentPage") != null) {
	    currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	BoardDao boardDao = new BoardDao();
	// 전체 게시글의 수를 구하는 코드
	int totalRowCount = boardDao.getBoardCount(); 
%>
	<div>전체행의 수 : <%=totalRowCount%></div>
<%    
	
%>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>boardTitle</th>
                <th>boardUser</th>
                <th>boardDate</th>
            </tr>
        </thead>
        <tbody>
<%
		int pagePerRow = 10; // 페이지당 보여줄 글의 목록을 10개로 설정
		ArrayList<Board> list = boardDao.getBoardList(currentPage, pagePerRow);
		for(Board b : list) {
%>
	        <tr>
	            <td><a href="<%=request.getContextPath()%>/model1_board/boardView.jsp?boardNo=<%=b.getBoardNo()%>"><%=b.getBoardTitle()%></a></td>
	            <td><%=b.getBoardUser()%></td>
	            <td><%=b.getBoardDate()%></td>
	        </tr>
<%        
    	}
%>
        </tbody>
    </table>
<%
	// 마지막 페이지는 전체글의수를 pagePerRow로 나누었을때 나누어 떨어지면 몫이 마지막 페이지 
	// ex) 전체글이 50개 / 10개씩 -> 마지막 페이지는 5페이지
	// 나누어 떨어지지 않으면
	// ex) 전체글이 51개 / 10개씩 -> 마지막 페이지는 6페이지
	int lastPage = totalRowCount/pagePerRow;
    if(totalRowCount % pagePerRow != 0) {
        lastPage++;
    }
%>
    <ul class="pager">
<%
        if(currentPage>1) { // 현재 페이지가 1보다 클때면 이전페이지 링크를 추가
%>
            <li class="previous"><a href="<%=request.getContextPath()%>/model1_board/boardList.jsp?currentPage=<%=currentPage-1%>">이전</a></li>
<%
        }
        if(currentPage < lastPage) { // 현재 페이지가 마지막 페이지보다 작으면 다음페이지 링크를 추가
%>
            <li class="next"><a href="<%=request.getContextPath()%>/model1_board/boardList.jsp?currentPage=<%=currentPage+1%>">다음</a></li>
<%
        }
%>
    </ul>
    <div>
        <a class="btn btn-default" href="<%=request.getContextPath()%>/model1_board/boardAddForm.jsp">게시글 입력</a>
    </div>
</div>
</body>
</html>