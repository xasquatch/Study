package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

//1.컨트롤러 역할을 하는 MemberControllerImpl클래스에서는
//memberService속성에 빈을 주입하기 위해  setter를 구현 합니다.
//2.상속 받는 MultiActionContriller클래스에서 제공하는 bind()메서드를 이용해
// 회원 가입 창에서 전송된 매개변수들을 편리하게 MemberVO객체의 각 속성에 설정 할수 있습니다.
//3. 그리고 ModelAndView를 뷰리졸버에 반환할때.. viewName을 
//"redirect:/member/listMembers.do"로 설정해 회원 목록창으로 리다이렉트되도록 합니다.   
public class MemberControllerImpl extends MultiActionController implements MemberController {
	
	private MemberService memberService;
	
	//MemberServiceImpl 빈을 주입받기 위해 setter메소드 구현
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		//조회한 회원정보를  ModelAndView의 addObject()메소드를 이용해 바인딩 합니다.
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		/*
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email = request.getParameter("email");
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		memberVO.setName(name);
		memberVO.setEmail(email);
		 */
		
		//회원 가입창에서 전송된 회원 정보를 bind() 메소드를 이용해 memberVO해당 속성에 자동으로 설정 함.
		bind(request, memberVO);
		int result = 0;
		result = memberService.addMember(memberVO);
		//회원 정보 추가후 ModelAndView 클래스의 redirect속성을 이용해 /member/listMembers.do로 
		//리다이렉트합니다.
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		System.out.println("삭제");
		int result =  memberService.removeMember(id);
		//회원정보를 삭제하고 회원 목록창으로 리다이렉트합니다.
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	//데이터베이스 연동 작업이 없는 입력창 요청 시 뷰이름만  ModelAndView로 반환합니다.
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
    
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}	

}
