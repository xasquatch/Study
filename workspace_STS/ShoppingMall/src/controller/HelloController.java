package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController{


	@RequestMapping("/hello.do")//!!!!!!!!!!!!!!!!!!
	public ModelAndView printHello() {
		//JSP페이지로 넘겨줄 응답데이터 만들기
		String data = "Hello world";
		
	/*
	 * 스프링 프레임워크에서 제공하는 view페이지 이름과 응답 데이터를 저장할 용도의 객체 생성
	 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",data);
		mav.setViewName("HelloPrint");//확장자명은 제외
		
		return mav;
	}
}