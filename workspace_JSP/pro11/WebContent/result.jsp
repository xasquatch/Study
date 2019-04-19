<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	ID를 입력하지 않은 경우 자바의 requsetDispatcher를 사용하지 않고 -->
<!-- 	포워드 액션태그를 사용해 다시 로그인 창으로 이동하도록 result.jsp를 작성 -->
<%
		request.setCharacterEncoding("utf-8");
		
		String userID = request.getParameter("userID");
	
		if(userID.length() == 0){
			
// 			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
// 			dis.forward(request, response);
%>
			<jsp:forward page="login.jsp"></jsp:forward>

<%	
		}
%>
		<img src = "colorfulimg/gg.jpg"><BR>
		<h1>환영합니다 <%=userID+"님" %></h1>
	
</body>
</html>