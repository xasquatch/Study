<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="com.bean.board.BoardDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check(){
		if(document.search.keyWord.value == ""){
			alert("검색어를 입력하세요.");
			document.search.keyWord.focus();
			return;
		}
		document.search.submit();
	}
	function fnRead(num) {
		document.Read.num.value = num;
		document.Read.submit();
		
	}
	
	function fnlist() {
		document.List.action = "List.jsp";
		//form태그의 submit이벤트 설정
		document.List.submit();
		
	}
</script>
<style>
table{
background-color : white;
}

</style>
<BODY style="background-image : url('d.gif');">
<center><br>
<img src="siva.gif" height="250"> <h1 style="display : inline; font-size : 200; font-family : 맑은 고딕; color:black; text-shadow : 0 0 2px #fff;">JSP Board</h1>

<%-- 순서1. DB작업을 하기 위해 BoardDAOimp1객체생성 --%>
<jsp:useBean id="dao" class="com.bean.board.BoardDAOImpl"></jsp:useBean>

<%-- 순서2. 검색기준 값, 검색어를 저장할 변수 선언 및 조건 판단하여 검색기준 값, 검색어 받기 --%>
<%!
	String keyWord = "", keyField = "";

	int totalRecord = 0;//게시판에 저장된 전체글의 개수
	int numPerPage = 5; //한 페이지당 보여질 글의 개수
	int pagePerBlock = 3; //한블럭당 묶여질 페이지 개수
	int totalPage = 0;	//전체 페이지 수 저장할 변수
	int totalBlock = 0; //전체블럭수를 저장할 변수
	int nowPage = 0; //현재 보여질 페이지 번호 저장할 변수
	int nowBlock = 0; //현재 보여질 페이지 번호가 속해있는 블럭 위치값을 저장할 변수
	int beginPerPage = 0; // 각 페이지의 시작 글번호를 저장
	String tlqkf="tlqkfshadk";
%>
<%	
	//현재 List.jsp페이지의 검색란에 검색어를 입력했다면 한글처리
	request.setCharacterEncoding("utf-8");
	
	if(request.getParameter("keyWord") != null){
		//검색 기준값 받아오기
		keyField = request.getParameter("keyField");
		//검색어 받아오기
		keyWord = request.getParameter("keyWord");
	}

	if(request.getParameter("reload") != null){
		if(request.getParameter("reload").equals("true")){
			keyWord = "";
		}
	}
	/*현재 보여질 페이지 번호 구하기
	게시판 하단 부분에 보면 이전 3개 <1 2 3 4 5> 다음 3개가 있는데
	1 2 3 4 5 중 하나의 페이지 번호를 선택하여 다시 List.jsp페이지를 요청하면?
	1 2 3 4 5 중 선택한 하나의 페이지 번호가 List.jsp페이지로 넘어오면서
	//nowPage변수(현재 선택한 페이지 번호 값을 얻는다)
	
	//조건문 : IF 1 2 3 4 5 중 선택한 페이지 번호가 있을 때만
	*/if(request.getParameter("nowPage") != null){
		
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	
	//현재 보여질 페이지 번호가 속한 블럭위치값 구하기
	// < 1 2 3 4 5 > 화면에서 >를 누른게 몇번 쨰 블럭인 구하기
	if(request.getParameter("nowBlock") != null){
		
		nowBlock = Integer.parseInt(request.getParameter("nowBlock"));
	}
	
	//각 페이지마다 맨위에 첫번쨰로 보여질 시작 글번호 구하기
	//현재 보여질 페이지번호 * 한 페이지당 보여질 글의 개수
	beginPerPage = nowPage * numPerPage;
	//위의 변수의 값을 구하는 이유  : 각페이지마다 
	
	
	//게시판의 전체 글 목록 리스트를 화면에 뿌려주기 위해
	//DB에 SELECT 작업을 위한 dao클래스의 메소드 호출
	//호출시 검색기준 값, 검색어를 메소드의 인자로 전달하여
	//DB로부터 검색한 결과를 벡터에 저장하여 벡터자체를 리턴 반환 받음
	
	

	Vector <BoardDTO>V = dao.getBoardList(keyField, keyWord, beginPerPage, 5);
	
	totalRecord = dao.getBoardList(keyField, keyWord).size();
	totalPage = (int)Math.ceil((double)totalRecord / numPerPage);
	totalBlock = (int)Math.ceil((double)totalPage/pagePerBlock);

%>

<table align=center border=0 width=80%>
<tr>
	<td align=left>Total :  <%=totalRecord %>Articles(
		<font color=red>  <%=nowPage+1 %> / <%=totalPage %> Pages </font>)
	</td>
</tr>
</table>

<table align=center width=80% border=0 cellspacing=0 cellpadding=3>
<tr>
	<td align=center colspan=2>
		<table border=0 width=100% cellpadding=2 cellspacing=0>
			<tr align=center bgcolor=#D0D0D0 height=120%>
				<th> 번호 </th>
				<th> 제목 </th>
				<th> 내용 </th>
				<th> 이름 </th>
				<th> 날짜 </th>
				<th> 조회수 </th>
			</tr>
			<%
				//날짜 포맷 형식을 사용자가 지정해서 출력해줄수 있는 객체 생성
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				
				//만약 벡터안에 검색한 BoardDTO객체들이 하나라도 존재하지 않으면
				if(V.isEmpty()){

			%>		
					<td colspan="5" align="center">
						"등록된 글이 없습니다."
					</td>
			
			<%
				}else{
					
//case 1. for문 출력		for(int cnt = beginPerPage; cnt < (beginPerPage+numPerPage); cnt++){
					
// 						if(cnt == totalRecord){
// 							break;
// 						}
						
// 						BoardDTO dto = (BoardDTO)V.get(cnt);
//-----------------------------------------------------------------------------------					
//case 2. Iterator출력					
// 						Iterator it = V.iterator();
// 						while(it.hasNext()){
// 							BoardDTO dto = (BoardDTO)it.next();
//-----------------------------------------------------------------------------------
//case 3. foreach
						for(BoardDTO dto:V){
							
								
						
			%>
					<tr align=center>
						<td> <%=dto.getPos()+1 %> </td>	<!-- getnum에서 getpos+1로 수정함 -->
						<td style="width: 100; text-align : left;">
							<a href="javascript:fnRead(<%=dto.getNum()%>)"><%=dao.useDepth(dto.getDepth())+dto.getSubject() %></a>
						</td>
						<td style = "font-weight : bold; color : red; width: 250; height: 20;">
							<%
							String content = dto.getContent();			
							if(content.length()>20)
								content = content.substring(0, 19);
							%><%=content+"..." %>
						</td>
						
						<td><a href="mailto:<%=dto.getEmail() %>"> <%=dto.getName() %> </a></td>
						<td> <%=s.format(dto.getRegdate()) %> </td>
						<td> <%=dto.getCount() %> </td>
					</tr>
			<%
						}//end - for(BoardDTO dto:V) 
				}//end - if(V.isEmpty())
			%>
			
			
		</table>
	</td>
</tr>
<tr>
	<td><BR><BR></td>
</tr>
<tr>
	<td align="left">Go to Page</span><BR>
<!-- 	12-1 ~ 12-5 게시판 하단 go to Page부분에 페이지 번호 출력
		한 블럭당 몇개의 페이지 번호를 출력 할 것인가 기준을 잡아야함(=pagePerBlock)
		1	2	3	← 0블럭
		4	5	6	← 1블럭
		7	8	9	← 2블럭
		한 블럭당 3페이지씩 출력된다.
 -->
 <%
	if(totalBlock > 0 && nowBlock > 0){
		%><a href="List.jsp?nowBlock=<%=nowBlock-1 %>&nowPage=<%=(nowBlock-1)*pagePerBlock %>">
		&lt;prev <%=(nowBlock*3)%>&gt;
		</a><%
	}
 				
	 	for(int cnt = 0; cnt<pagePerBlock; cnt++){
	 		
	 		if(totalPage == (nowBlock * pagePerBlock)+cnt){
	 			break;
	 		}//end - if.1
		 		%>
		 		<a href="List.jsp?nowBlock=<%=nowBlock %>&nowPage=<%=(nowBlock * pagePerBlock)+ cnt %>">
					<%=(nowBlock * pagePerBlock) + 1 + cnt %>
		 		</a>
		 		<%
			if(totalRecord == ((nowBlock*pagePerBlock)+1+cnt)){
				break;
			}////end - if.2
	 		
		}//end - for
	
	if(totalBlock > nowBlock +1){
		%><a href="List.jsp?nowBlock=<%=nowBlock+1 %>&nowPage=<%=(nowBlock+1)*pagePerBlock %>">
			&lt;next <%=(nowBlock+1)*pagePerBlock+1%>&gt;
		</a><%
	}//end - if.3
	
	
	if(totalBlock > 0 && nowBlock > 0){
			%><BR><a href="List.jsp?nowBlock=0&nowPage=0">최신글로 이동</a><%
	}//end - if.4
 		%>
 	</td>
 	<td align=right>
		<a href="Post.jsp">[글쓰기]</a>
		<a href="javascript:fnlist()">[처음으로]</a>
	</td>
</tr>
</table>
<BR>
<form action="List.jsp" name="search" method="post">
	<table border=0 width=527 align=center cellpadding=4 cellspacing=0>
	<tr>
		<td align=center valign=bottom>
			<select name="keyField" size="1">
				<option value="name"> 이름
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
	
<!-- 	현재 List.jsp페이지가 리로드하는지 안하는지 구별하기위한 값 true를 다시 List.jsp에 요청하는 폼태그 -->
	<form name="List" method="POST">
		<input type="hidden" name="reload" value="true">
	</form>
	
	<form action="Read.jsp" name="Read" method="POST">
		<input type="hidden" name="num">
		<input type="hidden" name="keyField" value="<%=keyField%>">
		<input type="hidden" name="keyWord" value="<%=keyWord%>">
	</form>
	
</BODY>
</HTML>