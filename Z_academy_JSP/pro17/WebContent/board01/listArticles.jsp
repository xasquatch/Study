<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<%-- 컨텍스트 주소를 얻어 변수에 저장 --%>
<c:set var="contextPath" 
	   value="${pageContext.request.contextPath}"/>
<%
	//한글처리
	request.setCharacterEncoding("utf-8");
%>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		.cls1{text-decoration: none;}
		.cls2{text-align: center; font-size: 30px;}
	
	</style>
</head>
<body>
		<table align="center" border="1" width="80%">
			<tr height="10" align="center" bgcolor="lightgreen">
				<td>글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
<c:choose>
	<%-- BoardController.java서블릿으로 부터 전달 받은 
		 request영역에 articleList속성으로 바인딩된 ...
		 ArrayList객체가 저장되어 있지 않다면?
	 --%>
	<c:when test="${articlesList == null }">
			<tr height="10">
				<td colspan="4">
					<p align="center">
						<b>
							<span style="font-size: 9pt">등록된 글이 없습니다.</span>
						</b>
					</p>
				</td>
			</tr>
	</c:when>
	
	<%-- BoardController.java서블릿으로 부터 전달받은 
	     request영역에 articlesList속성이름으로 바인딩된..
	     ArrayList객체가 저장되어 있다면~~ --%>
	<c:when test="${articlesList != null}">
			
		<%-- 서블릿으로 부터 전달 받은 
		      request영역에 저장되어 있는 ArryList크기(검색한 글의 갯수) 만큼 반복 하여
			   검색한 글정보(AtricleVO객체)들을 ArrayList객체 내부의 
			   각인덱스 위치로 부터 차례대로 꺼내와 글목록을 표시함.      
		--%>
		<c:forEach var="article" 
				   items="${articlesList}" 
				   varStatus="articleNum">
			  <tr align="center">	  	
			  	<td width="5%">${articleNum.count}</td> <%--varStatus의 count속성을 이용해 글번호를 1부터 자동으로  표시함 --%>		  	
			  	<td width="10%">${article.id}</td> <%--ArticleVO객체(검색한 글하나의정보)의 id변수값(작성자id)출력 --%>
			  	<td width="35%" align="left">
			  		<span style="padding-right: 30px"></span> <%--왼쪽으로 30px만큼 여백을 준 후 글제목을 표시할 목적으로 여백을 줌  --%>
			  		<c:choose>
			  			<%--조건 : <forEach>태그 반복시 각글의 level 값이 1보다 크면? 답글(자식글)이므로.. --%>
			  			<c:when test="${article.level > 1 }">
			  				<%--다시 내부 <forEach>태그를 이용하여 1부터 level값까지 반복하면서 
			  				       부모글 밑에 공백으로 들여쓰기하여 답글(자식글)임을 표시함 --%>
			  				 <c:forEach begin="1" end="${article.level}" step="1">
			  				 	<span style="padding-left: 20px"></span>
			  				 </c:forEach>      
			  				 	<%--공백 다음에 자식글을 표시 합니다. --%>
			  				     <span style="font-size: 12px;">[답변]</span>
			  				     <a class="cls1" href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNo}">${article.title}</a>
			  			</c:when>
			  			
			  			<%--조건 : 이때 level값이 1보다 크지 않으면 부모글이므로 공백 없이 표시 합니다. --%>
			  			<c:otherwise>
			  					 <a class="cls1" href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNo}">${article.title}</a>
			  			</c:otherwise>
			  		</c:choose>
			  	</td>
			  	<td width="10%">
			  		<fmt:formatDate value="${article.writeDate}"/>
			  	</td>
			  </tr>
		</c:forEach>
	</c:when>
</c:choose>				
		</table>
		<a class="cls1" href="${contextPath}/board/articleForm.do"> 
			<p class="cls2">글쓰기</p> 
		</a>
		
</body>
</html>






