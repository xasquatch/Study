<%@page import="mybean.SawonDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="mybean.SawonDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dbcp.DBConnectionMgr" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

	//직원 데이터 삭제시 한번 더 삭제할지 물어보는 함수
	function fnDel(no){
		
		var result = confirm("정말?");
		
		if(result){
			location.href = "delSawon.jsp?no="+no;
		}
		
	};
</script>

</head>
<body>
<%
	//검색기능 <form> 태그에서 요청받은 파라미터 한글처리
	request.setCharacterEncoding("utf-8");
	
	//검색기능 <form> 태그에서 요청받은 검색 기준값, 검색어를 받아 저장
	String search = request.getParameter("search");
	String searchText = request.getParameter("searchText");
	
	
%>
<!-- 	DB작업을 위한 메소드 호출용 dao객체생성 -->
	<jsp:useBean id="dao" class="mybean.SawonDAO"></jsp:useBean>
	
	
	
	<h2>직원 정보 리스트</h2>

	<img src="../짤/uh.jpg"><br>
	<a href="addSawon.jsp">직원추가(회원가입)</a>
	<form action="index.jsp" method="post">
		<select name="search">
			<option value="id">ID</option>
			<option value="addr">근무지</option>
			<option value="dept">부서명</option>
		</select>
		<input type="text" name = "searchText">
		<input type="submit" value = "검색">
	</form>
	<%--직원 정보 리스트--%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>나이</th>
			<th>근무지</th>
			<th>부서명</th>
			<th>내선번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<%
			//DB의 테이블 레코드를 검색하기 위해 위쪽에서 요청한
			//검색 기준값과 검색어를 getList()메소드 호출시 전달함.
			//그 결과 검색기준값과 검색어에 해당하는 레코드를 검색해 오는데
			//ArrayList에 담아서 받아온다.
			List list = dao.getList(search, searchText);
			Iterator it = list.iterator();
		
			while(it.hasNext()){
				SawonDTO dto = (SawonDTO)it.next();
			
		%>
			<tr>
				<td><%=dto.getId() %></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getAge() %></td>
				<td><%=dto.getAddr() %></td>
				<td><%=dto.getDept() %></td>
				<td><%=dto.getExtension() %></td>
				<td><a href="modifySawon.jsp?no=<%=dto.getNo() %>">수정</a></td>
				<td><a href="javascript:fnDel(<%=dto.getNo() %>)">삭제</a></td>
			</tr>
				
		<%		
				
			}
		%>




	</table>
</body>
</html>