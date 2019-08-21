<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<%--
	JSP페이지에서 반복문을 수행하는 태그
	<c:forEach>태그
	▼ <c:forEach>태그 형식
		<c:forEach 	var="변수이름 : 반복할 변수 이름"
					items="반복할 객체이름"
					begin="시작값 : 반복 시작값 "
					end="마지막값 : 반복 종료값"
					step="증가값 : 한번 반복할 떄마다 반복 변수를 증가시킬 값"
					varStatus="반복상태변수이름 : 반복상태 속성"
		>
		</c:forEach>
/********************************************************
		varStatus 상세
		속성		값		설명
		index	int		item에서 정의한 항목을 가리키는 index번호
		count	int		몇번째 반복인지 나타냅니다. 1부터 시작
		first	boolean	첫 번째 반복인지 나타냄
		last	boolean	마지막 반복인지 나타냄
********************************************************/		
		
 --%>
<%--
	예제 전체 흐름:
	자바코드로 ArrayList객체를 생성하여 문자열을 저장후
	<c:foreach>태그에서 사용할 수 있도록 <c:set>태그로 변수 list에 재할당 합니다.
	그리고 varStatus의 loop속성을 이용하여 반복 횟수를 출력합니다.
	<c:forEach>태그의 items속성에 ArrayList를 설정한 후 반복문 수행시 ArrayList에 저장된
	문자열을 반복 변수 data에 한개씩 가져와서 출력
--%>	
<%
	List dataList = new ArrayList();
	dataList.add("Hello");
	dataList.add("world");
	dataList.add("안녕하세요");
%>
	<c:set var="list" value="<%=dataList%>" scope="page"/>	
	<%-- <c:forEach var="i" begin="0" end="9" step="1" varStatus="loop">
		i = ${i } &nbsp;&nbsp;&nbsp; 반복횟수 : ${loop.count } // ${loop.index } ${loop.first } ${loop.last }<BR>
		
	</c:forEach> --%>
	<%-- <c:forEach var="i" begin="1" end="10" step="2" varStatus="lo">
		5 × ${i} = &nbsp; ${5*i }<BR>
	</c:forEach> --%>
<!-- 중요!!! ArrayList같은 컬렉션객체에 저장된 데이터를 반복해서 꺼내와 반복변수 data에 하나씩 가져와 처리함-->
	<%-- <c:forEach var="data" items="${list}" varStatus="loop">
		${data }&nbsp;&nbsp;&nbsp;loop.count : ${loop.count }
				&nbsp;&nbsp;&nbsp;loop.index : ${loop.index }
				&nbsp;&nbsp;&nbsp;loop.first : ${loop.first }
				&nbsp;&nbsp;&nbsp;loop.last : ${loop.last }<BR>
	</c:forEach> --%>
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤"/>
<!-- ▼문자열을 split하여 배열로 출력하는 기능 -->
	<c:forTokens items="${fruits}" delims=", " var="i">
		${i}<BR>
	</c:forTokens>
	
	
	
	
	
	
	
	
	
	
</body>
</html>