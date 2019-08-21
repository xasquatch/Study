<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
%>
<%--
	addSawon.jsp페이지에서 입력한 회원정보를 request객체 영역에서 꺼내어
	SawonDTO객체의 각 변수에 저장
 --%>
 	<jsp:useBean id="dto" class="mybean.SawonDTO"></jsp:useBean>
 	<jsp:setProperty property="*" name="dto"/>
 	
<!-- 	SawonDTO객체에 저장된 입력한 내용을 DB에 INSERT작업하기 위해 sawonDAO객체 생성 -->
 	
 	<jsp:useBean id="dao" class="mybean.SawonDAO"></jsp:useBean>
<%
	dao.setSawon(dto);
%>

			<h2>직원정보 추가 완료</h2>
			<a href="addSawon.jsp">회원가입 화면으로</a>
			<a href="index.jsp">메인화면으로</a>
