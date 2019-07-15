package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.MemberBean;

public class ShoppingController {

	@RequestMapping("/sujak.do")
	public ModelAndView sujak(String num) {//�Ķ���� num�� : left������ �����޴� ���� Ű��
		
		ModelAndView mav = new ModelAndView();
		//left�������� �����޴� �� � �޴��� ������ ��û�� ���Դ����� ����  num���� ��� �Ǵ�
		if (num == null) {
			
			
			
		}else {
			switch (num) {
			case value:
				
				break;

			default:
				break;
			}
		}
		
		
		
		return mav;
	}
	
	
	@RequestMapping("/index.do")//index.do��� �ּҷ� ��û�� ������ �Ʒ��� �޼ҵ� ����
	public ModelAndView index(HttpSession session) {//���� : ȸ������������ ����ϱ� ���Ͽ� ������ ���޹���

		//������ ������ + view���� ������ �뵵�� ��ü ����
		ModelAndView mav = new ModelAndView();

		//ȸ�����ɸ� ����ϱ� ���� ���ǿ������� memberbean��ü�� ���
		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		if (mbean == null) {
			
			mav.addObject("mbean",null);//�����͸� �Ʒ��� ShoppingMain.jsp �� �����ֱ�����
			
			mav.setViewName("ShoppingMain");			
			
		}else {
			mav.addObject("mbean", mbean);
			mav.setViewName("ShoppingMain");//Ȯ���ڸ��� ����
			
		}
		return mav;
	}
}
