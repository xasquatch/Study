<%@page import="com.bean.board.BoardDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에덴밸리 보드 동호회</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	//처음으로 링크를 클릭했을때 호출되는 함수 
	function fnList() {
		//form태그의  action속성의 값을 List.jsp로 설정
		document.list.action = "List.jsp";
		//form태그의 submit이벤트 설정
		document.list.submit();
	}
	
	//현재 글제목을 클릭했을때.. 글번호를 인자로 넘겨 받아 
	//form태그내부의  input태그의 value속성값을 지정함.
	//지정후 form전송.
	function fnRead(num) {
		document.read.num.value = num;
		document.read.submit();
	}



	function check(){
		if(document.search.keyWord.value == ""){
			alert("검색어를 입력하세요.");
			document.search.keyWord.focus();
			return;
		}
		document.search.submit();
	}
</script>
</head>
<body>
<%@ include file="../inc/top.jsp"%>


<center><br>

<h2>자유게시판</h2>

<%--순서1. DB작업을 하기위해 BoardDaoImpl객체 생성 --%>
<jsp:useBean id="dao" class="com.bean.board.BoardDaoImpl"  />

<%--순서2 검색기준값 , 검색어를 저장할 변수 선언 및 조건 판단 하여 검색기준값, 검색어 받기 --%>
<%!
	String keyWord = "", keyField = "";

//[1]. 페이징을 위한 변수 선언
	int totalRecord = 0; //게시판에 저장된 전체 글의 갯수 [2]
	int numPerPage = 5; //한페이지당 보여질 글의 갯수 
	int pagePerBlock = 3; //한블럭당 묶여질 페이지 갯수 
	int totalPage = 0; //전체 페이지갯수 저장할 변수 [4]
	int totalBlock = 0;//전체 블럭수를 저장할 변수 [9]
	int nowPage = 0; //현재 보여질 페이지 번호 저장할 변수 [7]
	int nowBlock = 0; //현재 보여질 페이지 번호가 속해 있는 
					  //블럭 위치값을 저장할 변수[8]
							  
	int beginPerPage = 0;//각페이지의 시작 글번호를 저장할 변수 
//-------------------------------------------------[1]끝
%>
<%
	//현재  List.jsp페이지의 검색란에 검색어를 입력 했다면 한글처리
	request.setCharacterEncoding("UTF-8");

	//만약 검색어를 입력 했다면 
	if(request.getParameter("keyWord") != null){
		//검색 기준값 받아오기
		keyField = request.getParameter("keyField");
		//검색어 받아오기
		keyWord = request.getParameter("keyWord");
	}
	
	//[처음으로]링크를 클릭했을때(List.jsp페이지를 재요청했을때..)
	//input태그의 hidden으로 요청한 name속성의 값이 reload인 값이 존재 하고 
	if(request.getParameter("reload") != null){
		
		//만약 List.jsp페이지로 다시 요청 받은 값이 true와 같을떄..
		if(request.getParameter("reload").equals("true")){
			
			keyWord = "";//검색어를 비어 둔다.
		}
	}
		
	//게시판의 전체 글목록 리스트를 화면 뿌려주기 위해 
	//DB에 SELECT 작업을 위한 dao클래스의 메소드 호출
	//호출시~ 검색기준값, 검색어를 메소드의 인자로 전달하여..
	//DB로 부터 검색한 결과를? 백터에 저장하여 백터 자체를 반환 받음.
	Vector v = dao.getBoardList(keyField, keyWord);
	
	//[2] 게시판에 저장된 전체 글의 갯수 구하기
	totalRecord = v.size();
	
	//[4] 전체 페이지수 구하기 = 게시판에 저장된 전체 글개수 / 한페이지당 보여질 글개수
	
	//게시판에 저장된 전체 글의 개수가 26개 라고 가정 했을떄..
	//게시판의 전체 페이지 수는? 한페이지당 보여질 글개수가 5개 라고 가정한다면
	//전체 글개수(26)를 한페이지당 보여질 글개수(5)로 나눈 몫 -> 5페이지가 나오고..
	//나머지가 1개글이니.. 나머지 1개글을 출력하기 위해.. 1개의 페이지가 더필요 하므로...
	//총~ 6페이지가 나와야 한다.
	
	//(double)totalRecord / numPerPage 계산의 결과는 실수값이 나올것이다.
	// 26.0               / 5          = 5.2
	//1개의 페이지가 더 필요하므로.. 실수 5.2를 올림처리하여 6.0으로 만들어 준다
	//6.0을 int형으로 형변환 하여  6으로 만든후 저장 
	totalPage = (int)Math.ceil((double)totalRecord / numPerPage);
	
	//[9]전체 블럭수 구하기  = 전체페이지수 / 한블럭당 묶여질 페이지수
	totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);
	
	
	//[7] 현재 보여질 페이지 번호 구하기
	//(설명) 게시판 하단 부분에 보면     이전3개 < 1 2 3 4 5 > 다음3개  가 있는데..
	// 1  2  3  4  5 중  하나의 페이지번호를 선택하여 다시 List.jsp페이지를 요청하면?
	// 1  2  3  4  5 중  선택한 하나의 페이지번호가 List.jsp페이지로 넘어오면서..
	//nowPage변수(현재 선택한 페이지 번호)값을 얻는다.
	
	//조건문 : 만약에 ~  1  2  3  4  5 중.. 선택한 페이지 번호가 있을때만?
	if(request.getParameter("nowPage") != null){
		//1 2 3 4 5중 현재 선택한 페이지 번호를 얻어 저장
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	
	//[8] 현재 보여질 페이지 번호가 속한 블럭위치값 구하기
	//    ( < 1 2 3 4 5 > 화면에서  >를 누른게 몇번째 블럭인 구하기)
	if(request.getParameter("nowBlock") != null){
		nowBlock = Integer.parseInt(request.getParameter("nowBlock"));
	}
	
	//[10] 각 페이지마다 맨위에 ~ 첫번째로 보여질 시작 글번호 구하기
	//현재 보여질 페이지 번호 * 한페이지당 보여질 글의 개수
	beginPerPage = nowPage * numPerPage;
	//위의 변수의 값을 구하는 이유 : 각페이지마다 보여질 글들을 분할해서 보여주기 위함 	
%>


<table align=center border=0 width=80%>
<tr>			   <%--[3] 게시판에 저장된 전체 글의 갯수 출력 --%>
	<td align=left>Total : <%=totalRecord %>  
				        <%--[6] 현재 보여지는 페이지 번호   /  [5] 전체페이지수 출력 --%>
		Articles(<font color=red><%=nowPage + 1 %> / <%=totalPage%> Pages </font>)
	</td>
</tr>
</table>

<table align=center width=80% border=0 cellspacing=0 cellpadding=3>
<tr>
	<td align=center colspan=2>
		<table border=0 width=100% cellpadding=2 cellspacing=0>
			<tr align=center bgcolor=#D0D0D0 height=120%>
				<td> 번호 </td>
				<td> 제목 </td>
				<td> 아이디 </td>
				<td> 날짜 </td>
				<td> 조회수 </
				td>
			</tr>
			<%
				//날짜포맷 형식을 사용자가 지정 해서 출력 해줄수 있는 객체 생성
				SimpleDateFormat s = 
					new SimpleDateFormat("yyyy-MM-dd");
				
				//만약 백터 안에 검색한 BoardDto객체들이 하나라도 존재 하지 않으면
				if(v.isEmpty()){//비어 있다면?
			%>
			<tr>
				<td colspan="5" align="center">
					등록된 글이 없습니다.
				</td>
			</tr>
			<%		
				}else{//백터에 검색한 정보들인 BoardDto객체들이 존재 한다면
					//[11] 
					for(int cnt=beginPerPage; cnt<(beginPerPage+numPerPage); cnt++){
						
						if(cnt == totalRecord){
							break;
						}
						
						//백터에 저장된 BoardDto객체(하나의글) 얻기						
						BoardDto dto = (BoardDto)v.get(cnt);			
			%>
			<tr align=center>
				<td> <%=dto.getNum()%></td>
				<td align="left"> <%=dao.useDepth(dto.getDepth())%>
					<a href="Read.jsp" onclick="fnRead('<%=dto.getNum()%>'); return false;">
						<%=dto.getSubject() %>
					</a>
				</td>
				<td><a href="mailto:<%=dto.getEmail()%>"><%=dto.getName() %></a> </td>
				<td> <%= s.format(dto.getRegdate())%></td>
				<td> <%= dto.getCount() %></td>
			</tr>				
			
			<%		}//for 끝	
				}//else 끝
			%>
		</table>
	</td>
</tr>
<tr>
	<td><BR><BR></td>
</tr>
<tr>
	<td align="left">Go to Page
	
 <%		//게시판에 글이 하나라도 존재 하고 
 		if(totalBlock > 0){
 			//현재 블럭 위치가 적어도 0보다 클때..이전으로 이동할 블럭이 있다는 뜻이므로
 			//◀◀ 이전 링크를 나타나게 할수 있음
 			if(nowBlock > 0){
 %>
 			<a href="List.jsp?nowBlock=<%=nowBlock-1%>&nowPage=<%=(nowBlock-1)*pagePerBlock%>">
 				이전 <%=pagePerBlock%>개
 			</a>◀◀◀
 <%				
 			}//안쪽 if
 		} //바깥쪽 if
 %>
	
	
	<%-- 12-1 ~ 12-5 게시판 하단 Go to Page부분에 페이지 번호 출력
	 한블럭당 몇개의 페이지 번호를 출력 할것인가 기준을 잡아야 하는데..
	 int pagePerBlock = 3; //한블럭당 묶여질 페이지 수 ~ 라고 위쪽에 변수를 선언 해 놓았음
	 그러므로 한블럭당 ~ 3개의 페이지를 묶는다고 보면 됨.
	 한블럭당 3개의 페이지씩이니간..
	 1  2  3  <--- 0블럭
	 4  5  6  <--- 1블럭
	 7  8  9  <--- 2블럭
	 위와 같이 한블럭당 3페이지씩 출력되면 된다.
	 --%>
	 <%
	 	//[12-1] 한블럭당 3개의 페이지번호 출력
	 	for(int cnt=0;  cnt<pagePerBlock; cnt++){// 3번반복
	 		
	 		//[12-5] 현재 보여질 페이지 번호가  == 전체 페이지수와 같을때 
	 		//3번 반복 하지 않고 for를 빠져나감
	 		if((nowBlock * pagePerBlock) + cnt == totalPage){
	 			break;
	 		}
	%>
	 	<a href="List.jsp?nowBlock=<%=nowBlock%>&nowPage=<%=(nowBlock*pagePerBlock)+cnt%>">
	 		<%=(nowBlock * pagePerBlock) + 1  + cnt %>
	 	</a>
	 <%	
	 	//[12-4] 하나의 블럭당 [1p  2p  3p]..[4p  5p  6p] 쭉쭉 페이지를 묶을수 있는데
	 	// 총글의 갯수를 생각해 본다면 마지막 하나의 블럭에는 글의 갯수에 따라서 [7p]와 같이..
	 	// 1개의 페이지만 하나의 블럭에 묶여 질수도 있다.
	 	// 만약 마지막글(총글의 개수)만큼 왔을경우.. 위와 같이 for문에서 3번 반복하지 않아도 되므로
	 	// (총글의 개수) == 게시판에 저장된 전체 글개수 와 같다면?
	 		if(	((nowBlock*pagePerBlock) + 1 + cnt)	== totalRecord){
	 			break; // for반복문을 빠져나가라 
	 		}
	 		
	 	}//for문 끝
	 	
	 	
	 //더이상 이동할 블릭이 있을때.. ▶▶▶다음3개 <--링크 나오게 하기 
	 if(totalBlock > nowBlock + 1){
	 %>
	 ▶▶▶<a href="List.jsp?nowBlock=<%=nowBlock+1%>&nowPage=<%=(nowBlock+1)*pagePerBlock%>">
	 	 다음<%=pagePerBlock%>개 
	 	</a>
	 <%
	 }
	 %>
	
	
	</td>
	<td align=right>
		<a href="Post.jsp">[글쓰기]</a>
		<a href="#" onclick="fnList();">[처음으로]</a>
	</td>
</tr>
</table>
<BR>
<form action="List.jsp" name="search" method="post">
	<table border=0 width=527 align=center cellpadding=4 cellspacing=0>
	<tr>
		<td align=center valign=bottom>
			<select name="keyField" size="1">
				<option value="name"> 아이디
				<option value="subject"> 제목
				<option value="content"> 내용
			</select>

			<input type="text" size="16" name="keyWord" >
			<input type="button" value="찾기" onClick="check()">
			<input type="hidden" name="page" value= "0">
		</td>
	</tr>
	</table>
</form>
</center>	

	<%--
		현재 List.jsp페이지가 리로드 하는지 않하는지 구별하기 위한 값 true을 
		다시 ~  List.jsp에 요청 하는 form태그
	 --%>
	<form name="list" method="post">
	
		<input type="hidden" name="reload" value="true">
	
	</form>
	
	<%--
		게시판 글리스트 중에서.. 글제목을 클릭했을때...
		Read.jsp로 선택한 글번호, 
		글을 선택하기 위해 검색한 검색기준값,  
		글을 선택하기 위해 검색한 검색어 값 전달 ~  
	 --%>
	<form action="Read.jsp" method="post" name="read">
		<input type="hidden" name="num">
		<input type="hidden" name="keyField" value="<%=keyField%>">
		<input type="hidden" name="keyWord" value="<%=keyWord%>">
	</form>

<%@ include file="../inc/bottom.jsp"%>
</body>
</html>