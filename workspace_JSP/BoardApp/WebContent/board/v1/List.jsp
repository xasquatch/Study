<%@page import="com.bean.board.BoardDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check(){
		if(document.search.keyWord.value == ""){
			alert("검색어를 입력하세요.");
			document.search.keyWord.focus();
			return;
		}
		document.search.submit();
	}
</script>
<BODY>
<center><br>
<h2>JSP Board</h2>

<%-- 순서1. DB작업을 하기 위해 BoardDAOimp1객체생성 --%>
<jsp:useBean id="dao" class="com.bean.board.BoardDAOImpl"></jsp:useBean>

<%-- 순서2. 검색기준 값, 검색어를 저장할 변수 선언 및 조건 판단하여 검색기준 값, 검색어 받기 --%>
<%!
	String keyWord = "", keyField = "";
%>
<%
	//현재 List.jsp페이지의 검색란에 검색어를 입력했다면 한글처리
	request.setCharacterEncoding("utf-8");
	
	if(request.getParameter("keyWord") != null){
		//검색 기준값 받아오기
		keyField = request.getParameter("keyField");
		//검색어 받아오기
		keyWord = request.getParameter("keyWord");
	}
	//게시판의 전체 글 목록 리스트를 화면에 뿌려주기 위해
	//DB에 SELECT 작업을 위한 dao클래스의 메소드 호출
	//호출시 검색기준 값, 검색어를 메소드의 인자로 전달하여
	//DB로부터 검색한 결과를 벡터에 저장하여 벡터자체를 리턴 반환 받음
	
	Vector V = dao.getBoardList(keyField, keyWord);
	out.println(V.size());
	
%>

<table align=center border=0 width=80%>
<tr>
	<td align=left>Total :  Articles(
		<font color=red>  1 / 10 Pages </font>)
	</td>
</tr>
</table>

<table align=center width=80% border=0 cellspacing=0 cellpadding=3>
<tr>
	<td align=center colspan=2>
		<table border=0 width=100% cellpadding=2 cellspacing=0>
			<tr align=center bgcolor=#D0D0D0 height=120%>
				<td> 번호 </td>
				<td> 제목 </td>
				<td> 이름 </td>
				<td> 날짜 </td>
				<td> 조회수 </td>
			</tr>
			<%
				//날짜 포맷 형식을 사용자가 지정해서 출력해줄수 있는 객체 생성
				SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
				
				//만약 벡터안에 검색한 BoardDTO객체들이 하나라도 존재하지 않으면
				if(V.isEmpty()){

			%>		
					<td colspan="5" align="center">
						"등록된 글이 없습니다."
					</td>
			
			<%
				}else{
					Iterator it = V.iterator();
					while(it.hasNext()){
						BoardDTO dto = (BoardDTO)it.next();
			%>
					<tr align=center>
						<td> <%=dto.getNum() %> </td>
						<td><a href="Read.jsp?num=<%=dto.getNum()%>"><%=dto.getSubject() %></a></td>
						<td><a href="mailto:<%=dto.getEmail() %>"> <%=dto.getName() %> </a></td>
						<td> <%=s.format(dto.getRegdate()) %> </td>
						<td> <%=dto.getCount() %> </td>
					</tr>
			<%
					}
				}
			
			%>
			
			
		</table>
	</td>
</tr>
<tr>
	<td><BR><BR></td>
</tr>
<tr>
	<td align="left">Go to Page </td>
	<td align=right>
		<a href="Post.jsp">[글쓰기]</a>
		<a href="javascript:list()">[처음으로]</a>
	</td>
</tr>
</table>
<BR>
<form action="List.jsp" name="search" method="post">
	<table border=0 width=527 align=center cellpadding=4 cellspacing=0>
	<tr>
		<td align=center valign=bottom>
			<select name="keyField" size="1">
				<option value="name"> 이름
				<option value="subject"> 제목
				<option value="content"> 내용
			</select>

			<input type="text" size="16" name="keyWord" >
			<input type="button" value="찾기" onClick="check()">
			<input type="hidden" name="page" value= "0">
		</td>
	</tr>
	</table>
</form>
</center>	
</BODY>
</HTML>