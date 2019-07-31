package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {

	@RequestMapping(value = {"/test/loginForm.do","/test/loginForm2.do"}, method = {RequestMethod.GET, RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav =new ModelAndView();
		mav.setViewName("loginForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/test/login.do", method = {RequestMethod.GET, RequestMethod.GET})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav =new ModelAndView();
		mav.setViewName("result");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		mav.addObject("userID",userID);
		mav.addObject("userName",userName);
		return mav;
	}
	
	
}
