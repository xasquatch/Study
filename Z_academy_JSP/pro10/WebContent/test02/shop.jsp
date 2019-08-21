<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	//index.jsp에서 로그아웃된 경우 쇼핑몰링크를 클릭했을 때도 마찬가지로
	//하나의 웹브라우저가 닫기기 전까지는 session객체 메모리 영역은 계속 유지가 된다.
	//그러므로 현재 shop.jsp로 넘어오면서 session객체 영역의 값을 이용하여
	//로그인여부를 판별
	String new_id = (String)session.getAttribute("id");
		if("master".equals(new_id)){
%>
			<h2><%=new_id %>, 즐거운 쇼핑되라</h2>
			<a href="logout.jsp">로그아웃</a>
			<a href="index.jsp">메인</a>
<%
		}else{
%>
			<script type="text/javascript">
				window.alert("로그인이 되지않았습\n 로그인페이지로 이동합니다");
				location.href = "login.jsp";
			</script>
<%
		}
%>
</body>
</html>