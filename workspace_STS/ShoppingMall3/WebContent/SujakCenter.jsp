<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body >
<table width="800" border="0" height="470">
	<c:set var="j" value="0"  />
	<c:forEach var="list" items="${list }">
		<c:if test="${j%4==0 }">
			<tr align="center">
		</c:if>
				<td width="200" height="300" valign="top">
					<a href="suinfo.do?suno=${list.suno }"> 
						<img alt="" src="img/${list.suimg }" width="190" height="180">
					</a><p>
					<font color="white" size="2"> 
					공구명 : ${list.suname } <br>
					판매 금액 : ${list.suprice } 원 
					</font>
				</td>
				<c:set var="j" value="${j+1 }" />
	</c:forEach>
			<tr/>
</table>

</body>
</html>