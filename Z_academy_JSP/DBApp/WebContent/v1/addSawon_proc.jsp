<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");	
	
	
	//순서 1. addSawon.jsp의 <form>태그에서 요청한 추가할 직원 정보 얻기
	//(요청값 얻기)
	String s_id = request.getParameter("s_id");
	String s_name = request.getParameter("s_name");
	String s_pw = request.getParameter("s_pw");
	String s_age = request.getParameter("s_age");
	String s_addr = request.getParameter("s_addr");
	String s_extension = request.getParameter("s_extension");
	String s_dept = request.getParameter("s_dept");
	
	
	//순서 2.
	String sql = "INSERT INTO tblSawon(id,name,pass,age,addr,extension,dept) "
				+"VALUES('"+s_id+"','"+s_name+"','"+s_pw+"','"+s_age+"','"+s_addr+"','"+s_extension+"','"+s_dept+"')";
	
	//순서 3. DB에 연결(con)하고 실행값 리턴(stmt)
		
		Connection con = null;
		Statement stmt = null;
		
		String url = "jdbc:mysql://localhost:3306/jspbeginner";
		String id = "jspid", pw = "jsppass";
		
		try{
			//1. JDBC드라이버
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. DB연결 시도
			con = DriverManager.getConnection(url,id,pw);
			
			//3. DB에 insert를 실행할 stmt객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 실행
			stmt.executeUpdate(sql);
%>
			<h2>직원정보 추가 완료</h2>
			<a href="addSawon.jsp">회원가입 화면으로</a>
			<a href="index.jsp">메인화면으로</a>
<%
		}catch(Exception e){
			System.out.println("INSERT 실패");
			e.printStackTrace();
		}finally{
			//자원해제
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		
		
		
%>