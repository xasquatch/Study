<%@page import="java.util.ArrayList"%>
<%@page import="sec03.brd01.ArticleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String Path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.cls1{text-decoration: none;}
		.cls2{text-align: center; font-size: 30px;}
	
	</style>
</head>
<body>
    <table border="1">
        <tr style="background-color: aqua;">
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        <%
        if (request.getAttribute("articlesList") == null) {
            %>
            <tr>
                <td colspan="4">
                    등록된 글이 없습니다.
                </td>
            </tr>   
            <%
        } else {
            
            int count = 1;
            
            for (ArticleVO vo : (ArrayList<ArticleVO>)request.getAttribute("articlesList")) {
                %>
                    <tr>
                    <th width="5%"><%=vo.getArticleNo()%></th> <%-- 또는 count++ --%>
                    <th width="10%"><%=vo.getId()%></th>
                    <td width="50%">
                <%
                
                if (vo.getLevel() > 1) {
                    
                    for (int i = 0; i < vo.getLevel(); i++) {
                        %>
                        <span style="padding-left:20px"></span>
                        <%
                    }
                    %>
                    <span style="font-size: 12px;">[답변]</span><a class="cls1" href="<%=Path %>/board/viewArticle.do?articleNo=<%=vo.getArticleNo()%>"><%=vo.getTitle() %></a>
                    <%
                    
                } else {
                    %>
                    <a class="cls1" href="<%=Path %>/board/viewArticle.do?articleNo=<%=vo.getArticleNo()%>"><%=vo.getTitle() %></a>
                    <%
                }
                
                %>
                    </td>
                    <th width="*">
                        <%=vo.getWriteDate() %>
                    </th>
                </tr> 
                <%
                
            }
        }
        
        %>
    </table>
    <p class="cls2"><a class="cls2" href="#">글쓰기</a></p>
</body>
</html>