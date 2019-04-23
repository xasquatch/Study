<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: "Gabriola";
	font-color : "RED";
}
</style>
</head>
<body>
<%
	//검색기능 <form> 태그에서 요청받은 파라미터 한글처리
	request.setCharacterEncoding("utf-8");
	
	//검색기능 <form> 태그에서 요청받은 검색 기준값, 검색어를 받아 저장
	String search = request.getParameter("search");
	String searchText = request.getParameter("searchText");
%>


	<h2>직원 정보 리스트</h2>

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
			/*DB작업을 위한 java.sql패키지에 있는 삼총사 객체를 담을 변수 선언 */
				//DB연결 객체를 저장할 변수 선언
				Connection con = null;
				//DB연결 후 DB에 SQL쿼리 전달 및 실행할 객체를 저장한 변수 선언
				Statement stmt = null;
				//ResultSet객체를 저장할 변수 선언
				//	- DB로부터 검색된 결과값을 임시로 저장하는 객체
				ResultSet rs = null;
				
			/*연결할 DB주소, DB접속 id, DB접속 PW 저장*/	
			String url = "jdbc:mysql://localhost:3306/jspbeginner";
			String id = "jspid", pw = "jsppass";
			
			/*실행할 SQL문을 저장할 변수 선언*/
			String sql = "";
			
			try{
				if(searchText.isEmpty()){
					sql = "SELECT * FROM tblSawon";
				}else{
					sql = "SELECT * FROM tblSawon WHERE "+ search +" LIKE '%"+ searchText +"%'";
				}
			}catch(NullPointerException e){
				sql = "SELECT * FROM tblSawon";
			}
			
			
			/*DB연결 부분*/
			try{
				//1. JDBC 드라이버 로딩
				Class.forName("com.mysql.jdbc.Driver");
				
				//2. DB연결 시도(접속)
				con = DriverManager.getConnection(url,id,pw);
				
				//3. DB에 sql쿼리 전달 및 실행할 statement객체 반환
				stmt = con.createStatement();
				
				//4. DB에 select sql쿼리 전달 및 실행 후 그 결과 받아오기
				rs = stmt.executeQuery(sql);
				
				//5. select실행 후 테이블 형식의 구조로 결과를  ResultSet객체에 받아오므로
				//  ResultSet객체에 레코드가 존재하는 동안 반복 출력
				while(rs.next()){
					/*검색된 하나의 직원정보를 ResultSet에서 꺼내오기*/
					int s_no = rs.getInt("no");						//TEST
// 					String s_no = String.valueOf(rs.getInt("no"));	//DB에서 int타입의 no필드
					String s_id = rs.getString(2);
					String s_name = rs.getString("name");
					String s_pw = rs.getString("pass");
// 					String s_age = String.valueOf(rs.getInt("age"));
					int s_age = rs.getInt("age");
					String s_addr = rs.getString("addr");
					String s_extension = rs.getString("extension");
					String s_dept = rs.getString("dept");
					
		%>
					<tr>
						<td><%=s_id %></td>
						<td><%=s_name %></td>
						<td><%=s_age %></td>
						<td><%=s_addr %></td>
						<td><%=s_dept %></td>
						<td><%=s_extension %></td>
						<td><a href="modifysawon.jsp?no=<%=s_no%>">수정</a></td>
						<td><a href="javascript:fnDel(<%=s_no%>)">삭제</a></td>
					</tr>
		<%
				}
			}catch(Exception e){
				System.out.println("index.jsp에서 오류 : "+ e);
			}finally{
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
					if(con != null)
						con.close();
			}
		%>
	</table>
</body>
</html>