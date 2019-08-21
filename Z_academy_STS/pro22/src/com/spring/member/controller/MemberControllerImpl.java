package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;

@Controller
public class MemberControllerImpl extends MultiActionController implements MemberController {

	// memberService��ü�� ���Թ޾� ������ ���� ����
	@Autowired
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	/* ���������� �ּ�â�� /member/listmembers.do�� ��û�� ȣ��Ǵ� �޼ҵ� */
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//getViewName()�޼ҵ带 ȣ���� ��û���� Ȯ���ڸ� .do�� ������ ���̸��� �����ɴϴ�.
		String viewname = getViewName(request);
		
		ModelAndView mav = new ModelAndView(viewname);
		List memberList = memberService.listMembers();
		mav.addObject("memberList",memberList);
		
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