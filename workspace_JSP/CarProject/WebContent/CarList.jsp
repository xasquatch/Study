<%@page import="controller.CarListBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
	<center>
		<img src="img/cis.jpg">
		<table width="1000" height="470" border="1">
			<c:set var="j" value="0"/>
			<c:forEach items="${requestScope.vector }" var="v">
				<c:if test="${j%4 == 0 }">
					<tr align="center">
				</c:if>
					<td>
					<a href="CarInfoController.do?carno=${v.carno }">
						<img src="img/${v.carimg }" width="220" height="180">
					</a>
						carname : ${v.carname}<br>
						price : ${v.carprice}
					 </td>
				<c:set var="j" value="${j+1 }"/>
			</c:forEach>
<%--  		<%
			Vector<CarListBean> v = (Vector)request.getAttribute("vector");
			int j = 0;
			for(int i = 0 ; i < v.size() ; i++){
				if(j%4 == 0){
		%>
			<tr align="center">
		<%
				}
		%>
					<td>
						<img src="img/<%=v.get(i).getCarimg() %>" width="220" height="180">
						Carname : <%=v.get(i).getCarname() %><br>
						price : <%=v.get(i).getCarprice() %>
					</td>
		<%		
					j += 1;
			}
		%> --%>
 				<tr height="70">
					<td colspan="4" align="center">
						<form action="CarCategoryController.do" method="POST">
						차량검색 : <select name="carcategory">
									<option value="Small">소형</option>
									<option value="Mid">중형</option>
									<option value="Big">대형</option>
								</select>
								&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="차량검색">
						</form>
					</td>
				</tr>
		</table>
	</center>
	
	
	
</body>
</html>