<%@page import="java.sql.PreparedStatement"%>
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
				+"VALUES(?,?,?,?,?,?,?)";
	
	//순서 3. DB에 연결(con)하고 실행값 리턴(stmt)
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:mysql://localhost:3306/jspbeginner";
		String id = "jspid", pw = "jsppass";
		
		try{
			//1. JDBC드라이버
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. DB연결 시도
			con = DriverManager.getConnection(url,id,pw);
			
			//3. DB에 insert를 실행할 PreparedStatement객체 얻기
			//위의 insert구문 중에서 문자들을 제외한 나머지 insert구문을
			//preparedstatment객체에 저장해서 
			//preparedstatment객체 자체를 리턴받음
			pstmt = con.prepareStatement(sql);
			
			// ?문자의 값들을 변수의 값으로 치환
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_name);
			pstmt.setString(3, s_pw);
			pstmt.setInt(4, Integer.parseInt(s_age));
			pstmt.setString(5, s_addr);
			pstmt.setString(6, s_extension);
			pstmt.setString(7, s_dept);
			
			//4.쿼리 실행
			pstmt.executeUpdate();
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
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		
		
%>