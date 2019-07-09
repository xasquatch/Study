package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/*
MVC��  C������ �ϴ� Ŭ����
�߿�! action-servlet.xml ���� ������ userMethodNameResolver ������Ƽ�� ����Ϸ���
�ݵ�� MultiActionControllerŬ������ ��� �޾Ƽ� ����Ͽ��� �Ѵ�.
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
		
		return mav;//dispatcherServlet���� ModelAndView ��ü ����
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userID = "";
		String passWD = "";
		
		request.setCharacterEncoding("UTF-8");
		/*
		 * - ���䵥���͸� View�������� �����ϱ� ���� ModelAndView��ü�� ���� - ModelAndView��ü�� JSP�� ������ ����
		 * ���ε� �� �� �ִ�. - ModelANdView��ü�� �̿��ϸ� ���̻� request���尴ü�� ���ε��ؼ� ������ �� �ʿ䰡 ����, ���ڿ�
		 * �̿��� �ٸ� ��ü�鵵 ModelANdView��ü�� ���ε� �� �� �ִ�.
		 * ���� ModelAndView��ü�� setViewName()�޼ҵ带 ȣ���� ���ڰ����� JSP�̸��� ������
		 */
		ModelAndView mav = new ModelAndView();
		
		userID = request.getParameter("userID");
		passWD = request.getParameter("passWD");
		
		//mav��ü�� request�Ķ���Ͱ� ����
		mav.addObject("userID", userID);
		mav.addObject("passWD", passWD);

		//������ View������ �̸� Ȯ���ڸ��� ������ ���ϸ� ����
		mav.setViewName("result");
		
		return mav; 
	}
	
	
}
