<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

String realFolder = getServletContext().getRealPath("/upload");

File file = new File(realFolder);
//디렉토리 존재하지 않을경우 디렉토리 생성
if(!file.exists()) {
    file.mkdirs();
}

int max = 10 * 1024 * 1024;
MultipartRequest multi = 
			new MultipartRequest(
					request, 
					realFolder, 
					max, 
					"UTF-8", 
					new DefaultFileRenamePolicy());

Enumeration e = multi.getFileNames();

if(e.hasMoreElements()) {
	String name = (String)e.nextElement();
	String sysName = multi.getFilesystemName(name);
	%>
	<script>
		var mainImg = opener.document.getElementById("main_img");
		mainImg.innerHTML = "<img src='../upload/<%=sysName %>'/>";
		
		var img_input = opener.document.getElementById("main_img_input")
		img_input.value = "../upload/<%=sysName %>";
		window.close();
	</script>
	<%
} else {
	
}
%>