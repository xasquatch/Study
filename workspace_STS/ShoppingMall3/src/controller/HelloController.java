package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController {

	//hello.do��� ��û�� URL�� ���Ͽ� ��� ������.. �Ʒ��� �޼ҵ带 ���� ��Ű�ÿ�.
	@RequestMapping("/hello.do")
	public ModelAndView printHello() {
		
		//JSP�������� �Ѱ��� ���䵥���� �����
		String data = "Hello World~";
		
		//������ �����ӿ�ũ���� �����ϴ� View��������� �����ҵ����͸� ������ �뵵��? ��ü 
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data",data);    //������ �����͸� ModelAndView��ü�� ����
		mav.setViewName("HelloPrint"); //������ JSP�������� �� ModelAndView��ü�� ����
		
		return mav;
		
	}
	
	
}



