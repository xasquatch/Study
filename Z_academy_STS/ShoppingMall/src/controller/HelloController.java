package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController{


	@RequestMapping("/hello.do")//!!!!!!!!!!!!!!!!!!
	public ModelAndView printHello() {
		//JSP�������� �Ѱ��� ���䵥���� �����
		String data = "Hello world";
		
	/*
	 * ������ �����ӿ�ũ���� �����ϴ� view������ �̸��� ���� �����͸� ������ �뵵�� ��ü ����
	 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",data);
		mav.setViewName("HelloPrint");//Ȯ���ڸ��� ����
		
		return mav;
	}
}