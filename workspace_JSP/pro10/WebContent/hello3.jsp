<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
	선언문 태그영역에 name변수를 선언하고 이순신문자열 저장
	getName()메소드를 선언하고 name변수값을 리턴하게끔 선언
--%>
<%--
	웹브라우저를 이용해서 요청값 age값을 request영역에서 꺼내와서 String age변수에 저장

 --%>
<%!
	String name = "이순신";
	public String getName() {
		return name;
		
}%>
<%
	String age = request.getParameter("age");

%>	

<%--표현식을 이용한 출력결과
	안녕하세요 이순신님!!
	나이는 22살입니다.
	키는 180cm입니다.
	나이+10은 32살 입니다.
--%>
	안녕하세요 <%=name %>님!!<BR>
	나이는 <%= age %>살입니다.<BR>
	키는 <%=180 %>cm입니다.<BR>
	나이+10은 <%= Integer.parseInt(age)+10 %>살 입니다.<BR> <%--numberformatexception --%>
