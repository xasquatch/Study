<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
	//컨텍스트 주소 얻기
// 	String contextPath = request.getContextPath();
%>    
   <c:set var="contextPath" 
   		  value="${pageContext.request.contextPath }"/>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%--Jquery 최신 CDN 링크 --%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	/*목록 보기 버튼 클릭시~*/
	// /listArtilces.do 요청주소에 의해 서블릿을 요청하여 
	// DB로 부터 글을 검색해서  최종적으로 listArticles.jsp뷰화면이 나오게 함.
	function backToList(obj){//아래에서 목록 보기 버튼을 클릭시 호출되는 함수로
							 //Form태그 객체를 매개변수로 전달 받음
							 
			obj.action="${contextPath}/board/listArticles.do";  
			obj.submit();//Form태그를 이용하여 글목록 화면을 요청함!	
		
	}
	
	
	//제이쿼리를 이용해 아래쪽의 <input type="file">태그에서
	//이미지 파일 첨부시 미리보기 기능을 구현하는 함수 
	function readURL(input){//<input type="file" ...>태그를 ??
							//매개변수로 전달 받음
		//크롬 웹브라우저의 F12개발자 모드로가서 console탭에 띄운 로그 메세지를 확인한다
		console.debug(input);
		console.debug(input.files);
		
		//참고:
		//<input type="file">인 태그 객체의  files속성을 호출하면..
		//FileList라는 배열이 생성되면서..FileList배열 내부의 0번째 인덱스 위치에..
		//아래에서 선택한 (업로드할) 파일정보들을 key:value쌍으로 저장한
		//File객체가 저장되어 있음
		
		//FilesList라는 배열이 존재하고...
		//FileList라는 배열의 0번쨰 인덱스 위치에 아래에서 파일업로드 하기 위해
		//선택한 File객체가 저장되어 있다면?
		//요약 : 아래의 <input type="file">태그에서 
		//	       업로드를 하기 위해 파일을 선택 했다면?
		 if(input.files && input.files[0]){
			 
			 //동적으로 <img>태그를 만들어 추가함
			 $("#tdImg").html("<img src='#' id='preview' wdith=200 height=200 />");
			 
			 //파일을 읽어올 객체 생성
			 var reader = new FileReader();
			 
		 	//지정한 img태그에 첫번째 파일 input에 첨부한 파일에 대한 
		 	//File객체의 내용을 읽어 드림
		 	reader.readAsDataURL(input.files[0]);
			 
		 	//파일을 모두 읽어 들였다면..
		 	reader.onload = function(ProgressEvent){
//읽어 들인 File객체 정보는 매개변수로 넘어오는 
//ProgressEvent객체내부의? 
//target속성에 대응되는 객체(JSON객체 데이터형식)로 저장 되어 있다
//또한 JSON객체 데이터 내부에는 result속성에 읽어들인 File객체 정보가 저장되어 있다.
				console.debug(ProgressEvent);	
				//id가  preview인 <img>태그에 attr메소드를 이용해
				//파일 첨부시 미리보기 이미지를 나타내기 위해..
				//src속성에 new FileReader()객체를 이용하여
				//읽어들인 첨부할 FIle객체 정보를 지정하여
				//추가함으로써 이미지 파일의 미리보기 기능이 가능한것임
				$('#preview').attr('src',ProgressEvent.target.result);


		 	}
		 	
			 
		 }
		
		
		
		
		
	}
		
	
	

</script>

</head>
<body>
	<h1 style="text-align: center;">새글 쓰기</h1>
	 
	<%-- action속성의 값을 /addArticle.do로 해서 '새글등록'을 요청합니다. --%>
	<form action="${contextPath}/board/addArticle.do" 
		  name="articleForm" 
		  method="post"
		  enctype="multipart/form-data">		
		
		<table border="0" align="center">
			<tr>
				<td align="right">글제목:</td>
				<td colspan="2">
					<input type="text" size="67" 
							maxlength="500" name="title">
				</td>
			</tr>
			<tr>
				<td align="right" valign="top"><br>글내용: </td>
				<td colspan="2">
					<textarea name="content" 
							  rows="10" 
							  cols="65" 
							  maxlength="4000">
					</textarea>
				</td>
			</tr>
			<tr>
				<td align="right">이미지 파일 첨부: </td>
				<td>
					<%--첨부할 다른 이미지 파일을 선택해서 변화가 일어나면
						readURL()함수 호출시 변화가 일어난? input태그 전달!
					 --%>
					<input type="file" 
					       name="imageFileName" 
					       onchange="readURL(this);">
				</td>
				<td id="tdImg"></td>
			</tr>
			<tr>
				<td align="right"> </td>
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="button" 
						   value="목록보기" 
					       onclick="backToList(this.form)">
				</td>
			</tr>		
		</table>
	</form> 
</body>
</html>





