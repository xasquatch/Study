<%@page import="java.sql.Timestamp"%>
<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//1. join.jsp페이지에서 요청한 가입할 회원정보를 request내장객체 영역에 저장되어 있음
	// 만약 한글이 존재할 때는 한글 깨짐을 방지하기 위해 charset설정
	request.setCharacterEncoding("utf-8");
	
	//2. 입력한회원정보를 DB에 추가하기 위해
	// memberbean객체에 저장
	MemberBean bean = new MemberBean();
	
	bean.setId(request.getParameter("id"));
	bean.setPasswd(request.getParameter("passwd"));
	bean.setName(request.getParameter("name"));
	bean.setEmail(request.getParameter("email"));
	bean.setAddress(request.getParameter("address"));
	bean.setTel(request.getParameter("tel"));
	bean.setMtel(request.getParameter("mtel"));
	bean.setReg_date(new Timestamp(System.currentTimeMillis()));
	
	//3. memberBean객체에 저장되어있는 가입할(입력한) 회원정보를 DB와 연동해 member테이블에 추가 insert
	MemberDAO dao = new MemberDAO();
	//3-1. 가입할(입력한) 회원정보를 DB와 연동해 member테이블에 추가 insert하기위한 메소드 호출
	dao.insertMember(bean);
	
	
	
	
	response.sendRedirect("login.jsp");
	
	
%>