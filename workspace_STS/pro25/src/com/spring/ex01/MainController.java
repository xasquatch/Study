package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/test")
@Controller("mainController")
public class MainController {

//TODO:이따가 .do 빼고 해보자
	@RequestMapping(value = "/main1.do", method = RequestMethod.GET)
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1");
		mav.setViewName("main");
		
		return mav;
	}

	@RequestMapping(value = "/main2.do", method = RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2");
		mav.setViewName("main");
		
		return mav;
	}
}
