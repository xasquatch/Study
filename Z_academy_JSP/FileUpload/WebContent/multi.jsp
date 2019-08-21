<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<script type="text/javascript">
	//[2번 form]태그에서 업로드 버튼을 클릭했을 때 호출되는 함수로
	//유효성을 체크하는 함수
		function check(form) {
			//2번 form태그에 접근하여 form태그 내부에 있는 모든 input,태그의 개수 구하기
			//forms[] 배열 : <form>태그에 접근방법
			//elements : <form>태그 안에 있는 모든 <input>태그들을 말함
			//length : 개수, 길이
			var cnt = form.elements.length;
			//위 cnt변수에 들어갈 <input>태그의 개수에 대한 설명
			// → 2번 form태그에 고정된 <input type="hidden"> 3개 및 버튼인풋태그 1개 총 4개
			var filecnt = 1;
			/*
				1번 form태그에서 업로드될 파일개수를 사용자에 의해서 동적으로 입력받기 때문에
				2번 form태그 안의 for문을 이용해 <input type="file">태그가 동적으로 만들어짐
					동적으로 만들어진	<input type="file">태그 중에서 업로드할 파일경로를 지정하지않은
					<input type="file">태그가 있다면 "x번 째 파일 정보가 누락되었습니다"라고 경고메시지창 호출
			*/
			//for반복문을 이용하여
			//2번 <form>태그안에 있는 모든 <input>태그 개수만큼 반복하는데
			for(i=0;i<=cnt;i++){
				//만약 2번form태그 내부의 type속서값이 file과 같고,
				//태그 중에서 업로드할 파일을 선택하지않고 비어있다면
				if(form.elements[i].type == "file" && form.elements[i].value == ""){
					//x번째 파일정보가 누락되었습니다.
					var msg = filecnt + "번째 파일 정보가 누락되었습니다 \n 올바른 입력을 해주세요"
					
					alert(msg);
					form.focus();
					return;

					
				}
				filecnt++;
			}
			
			form.submit();
		}
	</script>
	
	
<%
	//순서4. 
	//[1번 form]태그에서 요청한 값이 저장되어 있는 request객체를 통해서 얻어온다.
	//얻어온 값을 다시 ~ [1번 form]태그내부의 <input>태그에 데이터 출력해준다.
	request.setCharacterEncoding("utf-8");
	
%>
<%!
	//[1번 form]태그 input태그의 value=""에서 호출하는 메소드 만들기
	public String getParam(HttpServletRequest request, String param){
		if(request.getParameter(param)!=null){
			return request.getParameter(param);
		}else{
			return "";	
		}
		
				
	}
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 	여러개의 파일을 업로드 할 수 있도록 여러개의 <input>태그를 만드는데
		정해진 개수를 만드는 것보다 내가 원하는 개수만큼 늘려서 파일을 업로드
		
		[1번 form태그] form태그 추가할 파일수를 multi.jsp에 전달하는 역할
		[2번 form태그] 업로드할 파일 수를 전달 받아 업로드할 파일 개수만큼 for문을 이용하여 <input type="file">태그를 만들어서
					2번 form태그를 이용하여 파일업로드를 multi_pro.jsp페이지에 요청한다.
 -->


<h2>다중 파일 업로드</h2>
<!-- <순서1> -->
<form action="multi.jsp">	<!-- [1번 form태그] -->
	이름 : <input type="text" name="name" value="<%=getParam(request, "name")%>"><BR>
	주소 : <input type="text" name="addr" value="<%=getParam(request, "addr")%>"><BR><BR>
	하고 싶은 말 : <br>
	<textarea rows="12" cols="35" name="note" value="<%=getParam(request, "note")%>" style="background-image : url('img.jpg'); color: white;">
	</textarea><BR>
	추가할 파일수 입력 : <input type="text" name="add" size="2">
	<input type="submit" value="확인">
</form>
<!-- <순서2> -->
<%
	//추가할 파일 개수를 저장할 변수
	int filecnt = 0;

	//[1번 form]태그의 name속성값이 add인 <input>태그의 요청값이 있으면
	if(request.getParameter("add")!=null){
		//추가할 파일개수를 받아온다
		filecnt = Integer.parseInt(request.getParameter("add"));
	}
%>
<!-- <순서2> -->
<form action="multi_pro.jsp" enctype="multipart/form-data" method="POST"><!-- [2번 form태그] -->
	
	<input type="hidden" name="name" value="<%=getParam(request, "name")%>">
	<input type="hidden" name="addr" value="<%=getParam(request, "addr")%>">
	<input type="hidden" name="note" value="<%=getParam(request, "note")%>">
<%	
	for(int i= 1; i<= filecnt ; i++){
	%><%=i %>번째 파일 선택 : <input type="file" name="file<%=i%>"><BR><%	
	}
%>	
	<input type="submit" value="전송" onclick="check(this.form);">
	
	
</form>

</body>
</html>