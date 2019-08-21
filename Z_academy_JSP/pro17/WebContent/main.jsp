<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//우리가 Main.jsp페이지를 실행한다라는 말은?
//웹어플리케이션서버가 켜져 있는 상태에서 웹브라우저 주소창에...
//http://localhost:8090/Main.jsp입력하고 Main.jsp를 요청을 했을때..
//Main.jsp에서는  response.sendRedirect()메소드를 이용해서
//MembeController.java를? 재요청하게 되는데 ...
//재요청시~ 웹브라우저를 한번더 거쳐서!! 
//mem.do로 MembeController.java서블릿을 재요청! 
		
	//리다이렉트 방식 의 포워딩 ~ 
	//재요청!(포워딩!)->웹브라우저를 한번더 거쳐서 포워딩!
	response.sendRedirect("./member/listMembers.do");
	
%>







