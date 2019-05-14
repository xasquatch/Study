<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- 스토리
	선언부에서 ArrayList객체를 선언해주고,
	이후 request객체에서 각각의 파라미터를 얻어와 적절히 합쳐서 ArrayList에 담은 후, 
	ArrayList안에 담긴 결과물을 jquery를 이용해 table에 append 시켜주어 테이블을 구성하도록 되어있음
	이렇게 구성된 JSP파일을 앞선  JSP페이지에서 읽어들여 div안에 표시하게 됨

 -->
<script type="text/javascript">
	<%!	ArrayList<String> arr = null; %>
	<%
		if(arr==null){
			arr = new ArrayList<String>();
		}
		//요청값(입력한 id의 이름)얻기
		String input_id = request.getParameter("input_id");
		String input_name = request.getParameter("input_name");
		
		arr.add(input_id + "/" + input_name);
		
	%>
	$(function() {
	<%
		for(String str : arr){
	%>
			$("#tab").append("<tr><td><%=str%></td></tr>");
	<%	
		}
	%>
	})
	
</script>
</head>
<body>
	<table id="tab" border="1">
	
	</table>
</body>
</html>