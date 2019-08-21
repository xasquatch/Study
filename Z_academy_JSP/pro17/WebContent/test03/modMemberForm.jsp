<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
    
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<%
	request.setCharacterEncoding("UTF-8");
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;"> 회원 정보 수정창</h1>
	<%--
		회원정보 수정창에서 수정할 회원정보를 입력하고 수정하기 버튼을 클릭 했을때..
		action속성에 설정한 요청명 /member/modMember.do와 수정할 회원 ID를 MemberController로 전달
		해 수정을 요청하도록 구현 함. 
	--%>
	<form action="${contextPath}/member/modMember.do?id=${requestScope.memInfo.id}" 
		  method="post">
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
														  <%--조회한 회원정보를 텍스트박스에 표시 --%>
				<td width="400"><input type="text" name="id" value="${memInfo.id}" disabled></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</p></td>
																<%--조회한 회원정보를 텍스트박스에 표시 --%>
				<td width="400"><input type="password" name="pwd" value="${memInfo.pwd}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
															 <%--조회한 회원정보를 텍스트박스에 표시 --%>
				<td width="400"><input type="text" name="name" value="${memInfo.name}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="text" name="email" value="${memInfo.email}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가입일</p></td>
				<td width="400"><input type="text" name="joinDate" value="${memInfo.joinDate}" disabled></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">  
					<input type="submit" value="수정하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>


</body>
</html>





