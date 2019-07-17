package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController {

	//hello.do라는 요청이 URL을 통하여 들어 왔을떄.. 아래의 메소드를 실행 시키시오.
	@RequestMapping("/hello.do")
	public ModelAndView printHello() {
		
		//JSP페이지로 넘겨줄 응답데이터 만들기
		String data = "Hello World~";
		
		//스프링 프레임워크에서 제공하는 View페이지명과 응답할데이터를 저장할 용도의? 객체 
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data",data);    //응답할 데이터를 ModelAndView객체에 저장
		mav.setViewName("HelloPrint"); //응답할 JSP페이지명 을 ModelAndView객체에 저장
		
		return mav;
		
	}
	
	
}



