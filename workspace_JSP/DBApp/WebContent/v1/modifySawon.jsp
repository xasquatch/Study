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
		
		String no = request.getParameter("no");
		
		//전달받은 수정할 직원 번호에 해당하는 레코드 검색
		String sql = "SELECT * FROM tblsawon WHERE no="+no; 
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		/*연결할 DB주소, DB접속 id, DB접속 PW 저장*/	
		String url = "jdbc:mysql://localhost:3306/jspbeginner";
		String id = "jspid", pw = "jsppass";
		
		//수정하기 전 직원정보를 검색하여 저장할 변수를 (굳이 할필욘 없음)
		String s_id = null,
				s_name = null ,
				s_pw = null ,
				s_addr = null,
				s_age = null,
				s_extension = null,
				s_dept = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,id,pw);
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				s_id = rs.getString(2);
				s_name = rs.getString(3);
				s_pw = rs.getString(4);
				s_addr = rs.getString(6);
				s_age = String.valueOf(rs.getInt("age"));	//int
				s_extension = rs.getString(7);
				s_dept = rs.getString("dept");
			
			}
			
		}catch(Exception e){
			System.out.println("modifySawon.jsp page error");
		}finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
	%>
	<form action="modifySawon_proc.jsp" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th>ID</th>
					<td><input type="text" name = "s_id" value="<%=s_id %>">  </td>
				</tr>
				<tr>	
					<th>NAME</th>
					<td><input type="text" name = "s_name" value="<%=s_name %>"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="text" name = "s_pw" value="<%=s_pw %>"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" name = "s_age" value="<%=s_age %>"></td>
				</tr>
				<tr>
					<th>근무지</th>
					<td>
						<select name = "s_addr">
							<option value="서울" <%if(s_addr.equals("서울")){%>selected<%}%>>서울</option>
							<option value="경기" <%if(s_addr.equals("경기")){%>selected<%}%>>경기</option>
							<option value="인천" <%if(s_addr.equals("인천")){%>selected<%}%>>인천</option>
							<option value="수원" <%if(s_addr.equals("수원")){%>selected<%}%>>수원</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>부서</th>
					<td>
						<select name = "s_dept">
							<option value="영업부" <%if(s_dept.equals("영업부")){%>selected<%}%>>영업부</option>
							<option value="기술부" <%if(s_dept.equals("기술부")){%>selected<%}%>>기술부</option>
							<option value="기획부" <%if(s_dept.equals("기획부")){%>selected<%}%>>기획부</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>내선번호</th>
					<td><input type="text" name = "s_extension" value="<%=s_extension %>"></td>
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