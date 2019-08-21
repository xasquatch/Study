<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>여기는 footer.jsp의 내용</h2>
<div align="right">&Copyright reserved</div>
<BR>

<%
	//jsp include액션태그는
	//footer.jsp페이지와 index.jsp페이지에 int i;변수를 중복으로 선언가능
	//이유 : index.jsp → index.java, footer.jsp → footer.java로 변환되어
	//		index.java에서 footer.java
	int i = 20;
%>

i =
<%=i%>