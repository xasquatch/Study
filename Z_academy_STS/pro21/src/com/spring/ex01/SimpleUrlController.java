package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*

1. action-servlet.xml���� ������ ��û�� ó���ϱ� ���� �ݵ��
	controller�������̽��� �����ؾ� �ϸ�
2. SimpleUrlController���� Ŭ������ ��û��
	ModelAndView��ü�� �����Ͽ� Ŭ���̾�Ʈ���� ������ JSP������ �̸��� index.jsp�� �����Ͽ� ��ȯ��
	
*/
public class SimpleUrlController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		
		//�۾��� ��ģ �� �����ϱ� ���� ���̸��� ModelAndView��� ��ü�� �����Ͽ� index.jsp�̸��� �����Ͽ�
		//DispatcherServlet���� ��ȯ
		return new ModelAndView("index.jsp");
	}
	
	
}