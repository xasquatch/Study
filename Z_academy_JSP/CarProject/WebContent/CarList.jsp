<<<<<<< HEAD
<%@page import="controller.CarListBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--JSTL라이브러리에 속한 태그들중.. core라이브러리에 속한 태그를 사용하기 위해 링크 설정 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
>>>>>>> b9ef8822e2255ad8aba4dd407bfa2dcfca103469
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img src="img/cis.jpg"> <%-- <차량정보 보기> 이미지 적용--%>	
		
		<%--검색한 실제 전체차량의 이미지 및 차량에관한 정보 출력 --%>
		<table width="1000" height="470">
			
			<c:set var="j" value="0"/>
		
			<c:forEach var="carlistbean" items="${requestScope.vector}">
				<!-- 4열씩 자동차 이미지, 내용 출력하기 위해 4번마다 tr을 열어준다 -->
				<c:if test="${j%3 == 0}">
					<tr align="center">
				</c:if>
						<td>
							<a href="CarInfoController.do?carno=${carlistbean.carno}">
								<img src="img/${carlistbean.carimg}" width="220" height="180">
							</a>
							<br>
							차량명 : ${carlistbean.carname} <br>
							대여금액 : ${carlistbean.carprice}
						</td>	
				<!-- j변수값을 1씩 증가 -->
				<c:set var="j" value="${j+1}"/>
			</c:forEach>
					</tr>	
								
					<tr height="70">
						<td colspan="4" align="center">
							<form action="CarCategoryController.do" method="post">
							차량검색 : <select name="carcategory">
										<option value="Small">소형</option>
										<option value="Mid">중형</option>
										<option value="Big">대형</option>
									</select>
									&nbsp;&nbsp;&nbsp;
									<input type="submit" value="차량검색">
							</form>
						</td>
					</tr>			
		</table>
	</center>

</body>
</html>





