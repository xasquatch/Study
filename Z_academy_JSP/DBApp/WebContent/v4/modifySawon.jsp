<%@page import="mybean.SawonDTO"%>
<%@page import="mybean.SawonDAO"%>
<%@page import="dbcp.DBConnectionMgr"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		SawonDAO dao = new SawonDAO();
		SawonDTO dto = dao.getSawon(no);
		
	%>
	
	
	
			
	<form action="modifySawon_proc.jsp" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th>ID</th>
					<td><input type="text" name = "id" value="<%=dto.getId() %>">  </td>
				</tr>
				<tr>	
					<th>NAME</th>
					<td><input type="text" name = "name" value="<%=dto.getName() %>"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="text" name = "pass" value="<%=dto.getPass() %>"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" name = "age" value="<%=dto.getAge() %>"></td>
				</tr>
				<tr>
					<th>근무지</th>
					<td>
						<select name = "addr">
							<option value="서울" <%if(dto.getAddr().equals("서울")){%>selected<%}%>>서울</option>
							<option value="경기" <%if(dto.getAddr().equals("경기")){%>selected<%}%>>경기</option>
							<option value="인천" <%if(dto.getAddr().equals("인천")){%>selected<%}%>>인천</option>
							<option value="수원" <%if(dto.getAddr().equals("수원")){%>selected<%}%>>수원</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>부서</th>
					<td>
						<select name = "dept">
							<option value="영업부" <%if(dto.getDept().equals("영업부")){%>selected<%}%>>영업부</option>
							<option value="기술부" <%if(dto.getDept().equals("기술부")){%>selected<%}%>>기술부</option>
							<option value="기획부" <%if(dto.getDept().equals("기획부")){%>selected<%}%>>기획부</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>내선번호</th>
					<td><input type="text" name = "extension" value="<%=dto.getExtension()%>"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="변경사항 저장">&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소">
						<input type="hidden" name = "no" value="<%=no %>">
					</td>
				</tr>
			</table>
		</div>
	</form>
	
</body>
</html>