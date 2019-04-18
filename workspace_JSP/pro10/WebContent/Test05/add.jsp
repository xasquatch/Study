<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp"%>
<%-- 
	add.jsp페이지 page지시자 태그의 errpage속성에 예외처리담당 페이지명을 작성해서
	현재 페이지에서 예외가 발생하면 errpage속성에 작성한 페이지가 직접 예외처리 할 수 있도록함.
 --%>	
 <%
	 	int num = Integer.parseInt(request.getParameter("num"));
	 	int sum = 0;
	 	
	 	for(int i=1;i<=num;i++){
	 		sum = sum + i;
	 	}
 %>
	 	<h2>합계구하기</h2>
	 	<h1>1부터<%=num %>까지 합은 <%=sum %></h1>