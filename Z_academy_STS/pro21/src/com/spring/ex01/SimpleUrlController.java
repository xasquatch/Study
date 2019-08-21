package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*

1. action-servlet.xml설정 파일의 요청을 처리하기 위해 반드시
	controller인터페이스를 구현해야 하며
2. SimpleUrlController서블릿 클래스로 요청시
	ModelAndView객체를 생성하여 클라이언트에게 응답할 JSP페이지 이름인 index.jsp로 설정하여 반환함
	
*/
public class SimpleUrlController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		
		//작업을 마친 후 응답하기 위해 뷰이름을 ModelAndView라는 객체를 생성하여 index.jsp이름을 저장하여
		//DispatcherServlet으로 반환
		return new ModelAndView("index.jsp");
	}
	
	
}