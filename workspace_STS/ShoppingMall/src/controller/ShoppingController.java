package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.MemberBean;
import model.ShoppingDAO;
import model.SuBean;

public class ShoppingController {

	ShoppingDAO shoppingDAO;

	public void setShoppingDAO(ShoppingDAO shoppingDAO) {
		this.shoppingDAO = shoppingDAO;
	}

	@RequestMapping("/sujak.do")
	public ModelAndView sujak(String num) {//�Ķ���� num�� : left������ �����޴� ���� Ű��
		
		ModelAndView mav = new ModelAndView();
		
		//left�������� �����޴� �� � �޴��� ������ ��û�� ���Դ����� ����  num���� ��� �Ǵ�
		if (num == null) {
			
			/*DB�� �����Ͽ� �˻��� ��� ���۾������� �����;� �Ѵ�.
			 *�׷��⿡ �ռ� DTO������ �ϴ� Ŭ���� ���� �� subeanŬ���� ����(DTO)
			 */
			
			/*DB�� �����Ͽ� �˻��� ��� ���۾�����(SuBean)�� List�� ��Ƽ� ��ȯ�ޱ�*/
			List<SuBean> list = shoppingDAO.getAllSutool();
			
			mav.addObject("list",list);
			
		}else {

		}
		//centerȭ������ "SujakCenter.jsp"���ڿ� �����͸�
		//�Ʒ��� ShoppingMain.jsp�� �����ֱ� ���� new ModelAndView��ü�� ���
		mav.addObject("center","SujakCenter.jsp");
		
		//leftȭ������ "SujakLeft.jsp"���ڿ� �����͸�
		//�Ʒ��� ShoppingMain.jsp�� �����ֱ� ���� new ModelAndView��ü�� ���
		mav.addObject("left","SujakLeft.jsp");
		
//		�̵��� ���������� �� ShoppingMain.jsp �� Ȯ���ڸ��� ���� ����
		mav.setViewName("ShoppingMain");
		return mav;
	}

	@RequestMapping("/index.do") // index.do��� �ּҷ� ��û�� ������ �Ʒ��� �޼ҵ� ����
	public ModelAndView index(HttpSession session) {// ���� : ȸ������������ ����ϱ� ���Ͽ� ������ ���޹���

		// ������ ������ + view���� ������ �뵵�� ��ü ����
		ModelAndView mav = new ModelAndView();

		// ȸ�����ɸ� ����ϱ� ���� ���ǿ������� memberbean��ü�� ���
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");

		if (mbean == null) {

			mav.addObject("mbean", null);// �����͸� �Ʒ��� ShoppingMain.jsp �� �����ֱ�����

			mav.setViewName("ShoppingMain");

		} else {
			mav.addObject("mbean", mbean);
			mav.setViewName("ShoppingMain");// Ȯ���ڸ��� ����

		}
		return mav;
	}
}
