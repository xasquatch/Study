<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body{
		font-family : "Gabriola";
	}
</style>
</head>
<body>
	<h1>DB Connection Test</h1>
	<%
		//1단계 : JDBC드라이버 로드	
		//Class클래스의 forname메소드는
		//Driver클래스를 Driver객체로 생성하여 DriverManager클래스에 등록한다.
		Class.forName("com.mysql.jdbc.Driver");
		//DriverManager클래스의 역할
		// - Driver객체(jdbc드라이버)를 통하여 Connection객체(DB연결 정보를 담고 있는 객체)를 만드는 역할을 한다.
		// - DriverManager클래스는 Connection인터페이스 구현객체를 생성하는데
		//	getConnection()메소드를 사용한다.
		
		//2단계 : MySQL DBMS의 DB와 접속 DriverManager url 경로 →jdbc:mysql:// 자신의IP주소 : 포트번호 / 데이터베이스명
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspbeginner","jspid","jsppass");
		if(con != null){
			out.println("연결 성공");
		}else {
			out.println("연결 실패");
		}
	%>
</body>
</html>