<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%
    request.setCharacterEncoding("euc-kr");
%>
<%
    // C: ����̺꿡 �̸� test��� ������ ����� ��������
			String savePath = "c:/test/"; // ������ ���丮 (������)
			int sizeLimit = 10 * 1024 * 1024; // 10�ް����� ���� �Ѿ�� ���ܹ߻�
			String fileName = "";
			String originalFileName = "";
			try {
				MultipartRequest multi = 
				        new MultipartRequest(request, savePath, sizeLimit, "euc-kr",
											 new DefaultFileRenamePolicy());
				Enumeration formNames = multi.getFileNames(); // ���� �̸� ��ȯ
				String formName = (String) formNames.nextElement(); // �ڷᰡ ���� ��쿣 while ���� ���
				fileName = multi.getFilesystemName(formName); // ������ �̸� ���
				originalFileName = multi.getOriginalFileName(formName); //���� �̸� ��������
				String userName = "";

				if (fileName == null) { // ������ ���ε� ���� �ʾ�����
					out.print("���� ���ε� ���� �ʾ���");
				} else { // ������ ���ε� �Ǿ�����
					userName = multi.getParameter("userName");
					out.print("�ø� ��� : " + userName + "<br>");
					out.print("file �±� �̸� : " + formName + "<br>");
					out.print("����� ���ϸ� : " + fileName + "<br>");
					out.print("���� ���ϸ� : " + originalFileName + "<br>");
				} //else ��
			} catch (Exception e) {
				out.print("���� ��Ȳ �߻�..! ");
			} //catch
%>

<html>
<head>
<script language="javascript">
	function delfile() {
		document.myform.action = './delup.jsp'
		document.myform.submit();
	}

	function down() {
		document.myform.action = './down.jsp'
		document.myform.submit();
	}
</script>
</head>
<body>
	<form name="myform" method=post>
		<input type="text" value="<%=fileName%>" name="fileName"> 
		<input type=button value='���ϻ���' size=30 onClick="delfile()"> 
		<input type=button value='���ϴٿ�' size=30 onClick="down()">
	</form>
</body>
</html>


