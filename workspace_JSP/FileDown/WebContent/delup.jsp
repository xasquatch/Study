<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.io.*" %>
<%
 String fileName = request.getParameter("fileName");
 new File("c:/test/"+fileName).delete();
 out.print("���� ���� �Ϸ�!");
%>

