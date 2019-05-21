<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ConnectTest.jsp</title>
</head>
<body>
<%
	// JSP페이지에서  DB에 연결하는 방법
	
	// 1단계 (JDBC드라이버를 JSP에 로딩)
	// Class클래스의  forName("문자열로 주어진  Driver클래스명")메소드는
	// Driver.class를  Driver객체로 리턴하여 DriverManager클래스에 등록한다.
	Class.forName("com.mysql.jdbc.Driver");
	
	// DriverManager클래스의 역할
	// - Driver객체(JDBC드라이버)를 통하여 Connection객체(DBMS와 접속한 객체)를 만드는 역할
	// - DriverManager클래스는  Connection인터페이스의 구현객체를 생성하는데
	//   getConnection()메소드를 사용한다.
	
	// 2단계 MysqlDB와 연결한 Connection객체 얻기
	Connection con =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/bjb_db", "bjb", "1234"); 
	
	if(con != null){
		out.println("연결 성공");
	}else{
		out.println("연결 실패");
	}


%>

</body>
</html>




