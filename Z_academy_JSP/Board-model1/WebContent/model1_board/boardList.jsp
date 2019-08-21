<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="model1.Board" %>
<%@ page import="model1.BoardDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD LIST(��1 ���)</title>
<!-- bootstrap�� ����ϱ� ���� CDN�ּ� -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<h1>BOARD LIST(��1 ���)</h1>
<%
	// boardList.jsp���ش� currentPage��� �Ű������� �Ѿ�;� �ϴµ�
	// �Ű������� �� �Ѿ���� ��� currentPage�� 1�� ���Եȴ�.
	int currentPage = 1;
	if(request.getParameter("currentPage") != null) {
	    currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	BoardDao boardDao = new BoardDao();
	// ��ü �Խñ��� ���� ���ϴ� �ڵ�
	int totalRowCount = boardDao.getBoardCount(); 
%>
	<div>��ü���� �� : <%=totalRowCount%></div>
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
		int pagePerRow = 10; // �������� ������ ���� ����� 10���� ����
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
	// ������ �������� ��ü���Ǽ��� pagePerRow�� ���������� ������ �������� ���� ������ ������ 
	// ex) ��ü���� 50�� / 10���� -> ������ �������� 5������
	// ������ �������� ������
	// ex) ��ü���� 51�� / 10���� -> ������ �������� 6������
	int lastPage = totalRowCount/pagePerRow;
    if(totalRowCount % pagePerRow != 0) {
        lastPage++;
    }
%>
    <ul class="pager">
<%
        if(currentPage>1) { // ���� �������� 1���� Ŭ���� ���������� ��ũ�� �߰�
%>
            <li class="previous"><a href="<%=request.getContextPath()%>/model1_board/boardList.jsp?currentPage=<%=currentPage-1%>">����</a></li>
<%
        }
        if(currentPage < lastPage) { // ���� �������� ������ ���������� ������ ���������� ��ũ�� �߰�
%>
            <li class="next"><a href="<%=request.getContextPath()%>/model1_board/boardList.jsp?currentPage=<%=currentPage+1%>">����</a></li>
<%
        }
%>
    </ul>
    <div>
        <a class="btn btn-default" href="<%=request.getContextPath()%>/model1_board/boardAddForm.jsp">�Խñ� �Է�</a>
    </div>
</div>
</body>
</html>