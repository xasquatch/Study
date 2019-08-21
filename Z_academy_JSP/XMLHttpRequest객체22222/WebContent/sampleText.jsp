<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	
	out.println(userid + "\t" + passwd);//클라이언트의 웹브라우저로 응답

/*
	결과에서 [파일수신]버튼을 클릭하면 4.html은 지정된 파라마티를 가지고
	Ajax통신을 이용하여 서버측의 sampleText.jsp파일을 요청한다
	jsp로 요청 했기 때문에 서버에서는 동적인 데이터를 클라이언트로 반환하게 된다.
*/

%>