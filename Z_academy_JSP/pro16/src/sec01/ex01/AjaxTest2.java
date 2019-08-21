package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트페이지 ajax2.html페이지에서 Ajax기술로 메세지를 보내면
//처리를 하는 서블릿입니다.

@WebServlet("/ajaxtest2")
public class AjaxTest2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String result = "";
		PrintWriter out = response.getWriter();
		//응답할 도서정보를 XML파일 형식으로 작성한 후 클라이언트의 웹브라우저로 응답
		result ="<main><book>"+
				"<title><![CDATA[JAVA의 정석]]></title>"+
				"<writer><![CDATA[저자 | 남궁성]]></writer>"+
				"<image><![CDATA[http:localhost:8090/pro16/image/image1.jpg]]></image>"+
				"</book>"+
				"<book>"+
				"<title><![CDATA[JSP 2.3 & servlet 3.1]]></title>"+
				"<writer><![CDATA[저자 | 오정원]]></writer>"+
				"<image><![CDATA[http:localhost:8090/pro16/image/image2.jpg]]></image>"+
				"</book></main>";
		out.println(result);
		
		
		
	}

	
}
