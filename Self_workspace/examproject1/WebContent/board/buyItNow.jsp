<%@page import="java.sql.Timestamp"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int no = Integer.parseInt(request.getParameter("no"));
String id = (String)session.getAttribute("id");

if(id == null) {
	%>
	<script>
		alert("로그인후 이용해주세요.");
		history.back();
	</script>
	<%
} else {
	BoardDto dto = new BoardDto();
	BoardDao dao = new BoardDao();
	dto = dao.getBoard(no);
	
	if(dto.getStatus() != 1) {
	if(!id.equals(dto.getId())) {
	dto.setStatus(1);
	dto.setEnd_time(new Timestamp(System.currentTimeMillis()));
	dao.updateBoard(dto);
	dao.insertBuyer(no, id);
	%>
	<script>
		alert("구입 완료");
		location.href="../index.jsp";
	</script>
	<%
	} else {
		%>
		<script>
			alert("본인 아이템은 구입 불가능합니다.");
			history.back();
		</script>
		<%
	}
	} else {
		%>
		<script>
			alert("이미 판매된 상품입니다.");
			history.back();
		</script>
		<%
	}
}
%>