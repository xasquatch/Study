<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
		try{
			//1.WAS서버와 연결된 boardApp프로젝트의 모든 정보를 가지고 있는 컨텍스트객체 생성
			Context init = new InitialContext();
			
			//2. 연결된 WAS서버에서 DataSource(커넥션풀) 검색해서 가져오기
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/jspbeginner");
			
			//3. DataSource(커넥션풀)에서 커넥션 얻기
			conn = ds.getConnection();
			
				if(conn != null){
					out.println("연결 성공");
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	
	%>
	

</body>
</html>