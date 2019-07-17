package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.MemberBean;
import model.ShoppingDAO;
import model.SuBean;
import model.SuCartBean;

public class ShoppingController {
	
	ShoppingDAO shoppingDao;
	
	public void setShoppingDao(ShoppingDAO shoppingDao) {
		this.shoppingDao = shoppingDao;
	}
	
	
	//SuJakInfo.jsp���������� "īƮ���"��ư�� ������ ȣ��Ǵ� �޼ҵ��
	//"ī����"��ư�� ������ ���޹޴� ������ �ڵ����� SuCartBeanŬ������ ��������
	//���εǾ� ����ǰԵ�.���� �Ű������� ���� �ް� ��.
	@RequestMapping("/sutoolcart.do")
	public ModelAndView sutoolCart(SuCartBean cartbean,
								   HttpSession session) {
		
		//������ Cart��ü�� ����ϱ� ���ؼ� session�� ����Ǿ� �ִ�
		//Cart��ü ��������!
		//����! CartŬ���� ���ο��� ArrayList��ü�� ���� �Ѵ�.
		//����! ó������ session������ Cart��ü�� �������� �ʾƼ� null�� ��ȯ ����
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null) {//���� session������ Cart��ü�� ���� ���� ������
			
			cart = new Cart();
			
			//���ǿ����� Cart��ü�� ����
			session.setAttribute("cart", cart);
		}
		
		//�Ű������� ���޹޴� SuCartBean��ǰ��ü�� push�޼ҵ� ȣ��� �ٽ� �����Ͽ�
		//SuCartBean��ǰ��ü�� CartŬ������ ArrayList�� �߰� 
		cart.push(cartbean);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", 
					  cartbean.getSuname() + "�� ��ǰ�� " 
		              + cartbean.getSuqty() + "�� �߰��߽��ϴ�.");
		mav.addObject("cart", cart);
		mav.addObject("center", "SuCartResult.jsp");
		mav.addObject("left", "SujakLeft.jsp");
		
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
		
	//SujakCenter.jsp���������� ���۾����� �̹��� �ϳ��� Ŭ��������..
	//������ȣ�� �޼ҵ��� �Ű������� ���޹޾�.. ������ȣ�� �ش��ϴ� ���۾�������
	//DB�κ��� �˻��ؼ� ��� ���� �޼ҵ� 
	@RequestMapping("/suinfo.do")
	public ModelAndView suInfo(int suno) {	
		SuBean sbean = shoppingDao.getOneSutool(suno);	
		ModelAndView mav = new ModelAndView();	
		mav.addObject("sbean", sbean);
		//centerȭ������.. "SuJakInfo.jsp"���ڿ� �����͸� ..
		//�Ʒ��� ShoppingMain.jsp�� �����ֱ� ����... new ModelAndView��ü�� ���
		mav.addObject("center", "SuJakInfo.jsp");	
		//leftȭ������ "SujakLeft.jsp"���ڿ� �����͸�..
		//�Ʒ��� ShoppingMain.jsp�� �����ֱ� ����... new ModelAndView��ü�� ���
		mav.addObject("left", "SujakLeft.jsp");	
		//�̵��� ���������� -> ShoppingMain.jsp ��..Ȯ���ڸ��� �A ShoppingMain ���
		mav.setViewName("ShoppingMain");
		return mav;	
	}
	
	
	
	
	
	@RequestMapping("/sujak.do") //���۾����� ȭ�� �����ּ���~
	public ModelAndView suJak(String num) {
		
		ModelAndView mav = new ModelAndView();
		
		//Left�������� �����޴��� � �޴��� ������ ��û�� ��� �Դ��� �� ���� num���� ��� �Ǵ�
		if(num == null) {//����ǰ�� �����ų� �Ǵ� top.jsp�������� �ִ� �޴���..���۾� ���� �޴��� �����ٸ�			
			//��������!
			//DB�������Ͽ�.. �˻��� ��� ���۾������� �����;� �Ѵ�.
			//�׷��⿡ �ռ� DTO������ �ϴ� Ŭ������ ������ -> SuBeanŬ���� ����� 
		
			//DB�� �����Ͽ� �˻��� ��� ���۾�������(SuBean��)�� List�� ��Ƽ� ��ȯ�ޱ�
			List<SuBean> list = shoppingDao.getAllSutool();
			
			mav.addObject("list", list);
			
		}else {//�ش� �޴��� ���ý� ���Ǵ� �ҽ� 
			
			//SujakLeft.jsp�������� ī�װ��� �޴� �� �ϳ��� ������ ���� �����Ͽ�
			//DB�� �˻��� ���۾�������(SuBean��ü��)��  List�� ��� ��ȯ �ޱ�
			List<SuBean> list = shoppingDao.getSelectSutool(num);
			
			mav.addObject("list", list);
		}
		//centerȭ������.. "SujakCenter.jsp"���ڿ� �����͸� ..
		//�Ʒ��� ShoppingMain.jsp�� �����ֱ� ����... new ModelAndView��ü�� ���
		mav.addObject("center", "SujakCenter.jsp");
		
		//leftȭ������ "SujakLeft.jsp"���ڿ� �����͸�..
		//�Ʒ��� ShoppingMain.jsp�� �����ֱ� ����... new ModelAndView��ü�� ���
		mav.addObject("left", "SujakLeft.jsp");
		
		//�̵��� ���������� -> ShoppingMain.jsp ��..Ȯ���ڸ��� �A ShoppingMain ���
		mav.setViewName("ShoppingMain");
		
		return mav;

	}
	
	
	
	@RequestMapping("/index.do")//index.do��� �ּҷ� ��û�� ������ �Ʒ��� �޼ҵ带 �����Ͻÿ�.
	public ModelAndView index(HttpSession session) {//ȸ������ ������ ����ϱ� ���Ͽ� ������ ���� ����
		
		//������ ������ + View���� ������ �뵵�� ��ü ����
		ModelAndView mav = new ModelAndView();
		
		//ȸ�������� ����ϱ� ���� ���ǿ������� ��� 
		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		//���ǿ����� MemberBean��ü�� ����Ǿ� �ֳ� ���Ŀ� ����.. �α���ó��
		if(mbean == null) {
			mav.addObject("mbean", null);//�����͸� �Ʒ��� ShoppingMain.jsp�� �����ֱ����� 
										 //������ ��� 
			mav.setViewName("ShoppingMain"); //Ȯ���ڸ��� �A ������ ���̸� ����
			
		}else {
			mav.addObject("mbean", mbean);//�����͸� �Ʒ��� ShoppingMain.jsp�� �����ֱ����� 
										  //������ ��� 
			mav.setViewName("ShoppingMain"); //Ȯ���ڸ��� �A ������ ���̸� ����
		}
		
		return mav;
	}
	
	
}




