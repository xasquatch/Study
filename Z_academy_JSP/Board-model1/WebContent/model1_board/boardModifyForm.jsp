<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="model1.BoardDao" %>
<%@ page import="model1.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- bootstrap�� ����ϱ� ���� CDN�ּ� -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- jquery�� ����ϱ����� CDN�ּ� -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		$('#modifyButton').click(function(){
			if($('#boardPw').val().length <4) {
				alert('boardPw�� 4���̻� �̾�� �մϴ�');
				$('#boardPw').focus();
			} else if($('#boardTitle').val()=='') {
				alert('boardTitle�� �Է��ϼ���');
				$('#boardTitle').focus();
			} else if($('#boardContent').val()=='') {
				alert('boardContent�� �Է��ϼ���');
				$('#boardContent').focus();
			} else if($('#boardUser').val()=='') {
				alert('boardUser�� �Է��ϼ���');
				$('#boardUser').focus();
			} else {
				$('#modifyForm').submit();
			}
		});
	});
</script>
<title>BOARD MODIFY FORM(��1 ���)</title>
</head>
<body>
<div class="container">
	<h1>BOARD MODIFY FORM(��1 ���)</h1>
<%
	Board board = null;
	if(request.getParameter("boardNo") == null) {
	    response.sendRedirect(request.getContextPath()+"/model1_board/boardList.jsp");
	} else {
	    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	    //System.out.println("boardModify param boardNo:"+boardNo);
		BoardDao boardDao = new BoardDao();
		board = boardDao.getBoard(boardNo);
	}
%>    
    <form id="modifyForm" action="<%=request.getContextPath()%>/model1_board/boardModifyAction.jsp" method="post">
        <div class="form-group">boardNo :
        	<input class="form-control" name="boardNo" value="<%=board.getBoardNo()%>" type="text" readonly="readonly"/>
        </div>
        <div class="form-group">
			<label for="boardPw">��й�ȣ Ȯ�� :</label>
			<input class="form-control" name="boardPw" id="boardPw" type="password"/>
		</div>	
		<div class="form-group">
			<label for="boardPw">boardTitle :</label>
			<input class="form-control" value="<%=board.getBoardTitle()%>" name="boardTitle" id="boardTitle" type="text"/>
		</div>
        <div class="form-group">boardContent :
        	<textarea class="form-control" id="boardContent" name="boardContent" rows="5" cols="50"><%=board.getBoardContent()%></textarea>
        </div>
        <div>
            <input class="btn btn-default" id="modifyButton" type="button" value="�ۼ���"/>
            <input class="btn btn-default" type="reset" value="�ʱ�ȭ"/>
            <a class="btn btn-default" href="<%=request.getContextPath()%>/model1_board/boardList.jsp">�۸��</a>
        </div>
    </form>
</div>
</body>
</html>