<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
/* 우리가 Main.jsp페이지를 실행한다는 말은?
 * 웹어플리케이션 서버가 켜져있는 상태에서 웹브라우저 주소창에
 * http://localhost:8090/main.jsp의 요청이 들어갔을 때
 * main.jsp에서는 response.sendRedirect()메소드를 이용해서
 * MemberController.java를 재요청하게 되는데
 * 재요청시~ 웹브라우저를 한번 더 거쳐서 재요청한다. 
*/

//재요청!(포워딩) 웹브라우저를 한번 더 거쳐서 포워딩
	response.sendRedirect("./member/listMembers.do");


%>