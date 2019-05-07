<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- multi.jsp의 2번 <form>태그에서 요청한 텍스트데이터+업로드할 파일 정보는?
request객체에 담겨있으므로
request객체에 담긴 모든 데이터 꺼내오기 -->

<%
	request.setCharacterEncoding("utf-8");
	/*업로드할 실제 서버경로 얻기*/
	String realFolder = getServletContext().getRealPath("Upload");
	//10mb로 최대 업로드크기 지정
	int max = 1024*1024*10;
	
	//인수1) form태그에서 요청한 request객체를 다시 전달
	//인수2) 업로드될 파일의 위치를 전달
	//인수3) 업로드할 파일의 최대 크기 전달
	//인수4) 업로드할 파일 인코딩 방식
	//인수5) 파일 이름 중복시 자동으로 변환하여 생성하는 기능(객체 생성하여 전달)
	MultipartRequest multi = new MultipartRequest(request,realFolder,max,"UTF-8",new DefaultFileRenamePolicy());
	
	String name = multi.getParameter("name");
	String addr = multi.getParameter("addr");
	String note = multi.getParameter("note");
	
	//서버에 시제로 업로드된 파일의"이름"을 저장할 컬렉션 객체 생성
	ArrayList saveFile = new ArrayList();
	
	//클라이언트가 업로드한 파일의 원본이름 하나하나씩 담을 컬렉션 객체 생성
	ArrayList originFiles = new ArrayList();
	
	//파일 업로드시 선택한 <input type="file">태그의 name속성값을 모두 얻어
	//Enumeration반복기에 담아
	//반복기 역할을 하는 객체 자체를 리턴받기
	
	Enumeration e = multi.getFileNames();
		
	while(e.hasMoreElements()){
		Object ob = e.nextElement();
		String filename = (String)ob;
		
		//서버에 실제로 업로드된 파일 이름을 하나씩 얻어 ArrayList에 담기
		saveFile.add(multi.getFilesystemName(filename));
		originFiles.add(multi.getOriginalFileName(filename));
		
		
		
	}
%>
	<ul>
		<li> 이름 : <%=name %></li>
		<li> 주소 : <%=addr %></li>
		<li> 하고싶은 말 : <%=note %></li>
	</ul><BR>
	<HR>
	업로드한 파일 목록<BR>
	<ul>
<%
		for(int i=0; i<saveFile.size();i++){
			%>
			<li>
				<a href="download.jsp?path=Upload&name=<%=saveFile.get(i)%>">
					<%=originFiles.get(i)%>
				</a>
			</li>
			<%
		}
	
%>
	</ul>
	
	
	
	
	
