<%@page import="mymember.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
MemberDao dao = new MemberDao();
boolean check = dao.checkUser(id);
out.println(check);
%>