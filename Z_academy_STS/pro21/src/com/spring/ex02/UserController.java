package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/*
MVC중  C역할을 하는 클래스
중요! action-servlet.xml 설정 파일의 userMethodNameResolver 프로퍼티를 사용하려면
반드시 MultiActionController클래스를 상속 받아서 사용하여야 한다.
*/
public class UserController extends MultiActionController{

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		
		mav.setViewName("memberInfo");
		
		return mav;//dispatcherServlet으로 ModelAndView 객체 리턴
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userID = "";
		String passWD = "";
		
		request.setCharacterEncoding("UTF-8");
		/*
		 * - 응답데이터를 View페이지로 전달하기 위해 ModelAndView객체에 저장 - ModelAndView객체에 JSP에 전달할 값을
		 * 바인딩 할 수 있다. - ModelANdView객체를 이용하면 더이상 request내장객체에 바인딩해서 포워딩 할 필요가 없고, 문자열
		 * 이외의 다른 객체들도 ModelANdView객체에 바인딩 할 수 있다.
		 * 따라서 ModelAndView객체의 setViewName()메소드를 호출해 인자값으로 JSP이름을 설정함
		 */
		ModelAndView mav = new ModelAndView();
		
		userID = request.getParameter("userID");
		passWD = request.getParameter("passWD");
		
		//mav객체에 request파라미터값 저장
		mav.addObject("userID", userID);
		mav.addObject("passWD", passWD);

		//응답할 View페이지 이름 확장자명을 제외한 파일명만 기재
		mav.setViewName("result");
		
		return mav; 
	}
	
	
}
