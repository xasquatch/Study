package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import model.MemberBean;
import model.ShoppingDAO;
import model.SuBean;
import model.SuCartBean;

public class ShoppingController {

	ShoppingDAO shoppingDAO;

	public void setShoppingDAO(ShoppingDAO shoppingDAO) {
		this.shoppingDAO = shoppingDAO;
	}

	@RequestMapping("/sutoolbuy.do")
	public ModelAndView sutoolbuy(SuCartBean bean, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");

		if (mbean != null) {
			mav.addObject("subean", bean);
			mav.addObject("center", "Sutoolbuy.jsp");
			mav.addObject("left", "SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		} else {
			mav.addObject("center", "loginForm.jsp");
			mav.addObject("left", "SujakLeft.jsp");
			mav.setViewName("ShoppingMain");

		}

		return mav;
	}

	@RequestMapping("/loginproc.do")
	public ModelAndView loginProc(HttpSession session, MemberBean mbean) {

		ModelAndView mav = new ModelAndView();

		int result = shoppingDAO.getloginproc(mbean);

		if (result == 1) {
			session.setAttribute("mbean", mbean);
			session.setMaxInactiveInterval(30 * 60);
			return new ModelAndView(new RedirectView("index.do"));
		} else {
			mav.addObject("center", "loginForm.jsp");
			mav.addObject("left", "SujakLeft.jsp");
			mav.addObject("login", "1");
			mav.setViewName("shoppingMain");

		}

		return mav;
	}

	// �α׾ƿ� ó�� �޼ҵ�
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {

		MemberBean mbean = (MemberBean) session.getAttribute("mbean");

//		session.setAttribute("mbean", null);
//		session.invalidate();
		session.removeAttribute("mbean");

		return new ModelAndView(new RedirectView("index.do"));
	}

	@RequestMapping("/joinproc.do")
	public ModelAndView joinproc(MemberBean mbean, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		/*
		 * �����ͺ��̽��� �����ؼ� �ش� ���̵� �����ϴ����� �н����尡 �´��� �񱳸� ���� getlogin()�޼ҵ� ȣ�� �� ���ڷ�
		 * memberbean��ü�� ������ getlogin()�޼ҵ��� ��ȯ���� 1�̸� �ش���̵� DB�� �����Ѵٴ� �ǹ�
		 */
		int result = shoppingDAO.getLogin(mbean);

		if (result == 1) {
			mav.addObject("result", 1);
			mav.addObject("center", "joinForm.jsp");
			mav.addObject("left", "SujakLeft.jsp");
			mav.setViewName("ShoppingMain");

			/*
			 * �Ű������� �־�� memberbean��ü�� getter�޼ҵ带 ȣ���Ͽ� ��й�ȣ �Է¶��� ��й�ȣ Ȯ�� �Է¶��� ���� ��ġ���� ���ǰ˻�
			 */
		} else if ((result == 0) && mbean.getMempasswd1().equals(mbean.getMempasswd2())) {
			/* DB�� ȸ���� �߰��ϱ� ���� insertmember�޼ҵ� ȣ��� memberbean��ü ���� */
			shoppingDAO.insertMember(mbean);
			// ȸ������ �Ϸ� �� ���ǿ� ����(�α���ó��)
			session.setAttribute("mbean", mbean);
			// ���ǿ��� �ִ� �����ð� ����
			session.setMaxInactiveInterval(60 * 30);// 30��

			return new ModelAndView(new RedirectView("index.do"));

		} else {
			mav.addObject("result", 2);
			mav.addObject("center", "joinForm.jsp");
			mav.addObject("left", "SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		}

		return mav;
	}

	@RequestMapping("/login.do")
	public ModelAndView login() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("center", "loginForm.jsp");
		mav.addObject("left", "SujakLeft.jsp");
		mav.setViewName("ShoppingMain");

		return mav;
	}

	@RequestMapping("/joinForm.do")
	public ModelAndView joinform() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("center", "joinForm.jsp");
		mav.addObject("left", "SujakLeft.jsp");
		mav.setViewName("ShoppingMain");

		return mav;
	}

	@RequestMapping("/sucartdel.do")
	public ModelAndView sucartdel(int suno, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");

		cart.deleteCart(suno);

		ModelAndView mav = new ModelAndView();

		mav.addObject("cart", cart);
		mav.addObject("center", "SuCartResult.jsp");
		mav.addObject("left", "SujakLeft.jsp");
		mav.setViewName("ShoppingMain");

		return mav;
	}

	@RequestMapping("/sutoolcart.do")
	public ModelAndView sutoolCart(SuCartBean cartbean, HttpSession session) {

//		������ cart��ü�� ����ϱ� ���ؼ� session�� ����Ǿ� �ִ�
//		cart��ü ��������
//		���� 1 : cartŬ���� ���ο��� arraylist��ü�� �����Ѵ�.
//		���� 2 : ó������ session������ cart��ü�� �������� �ʾƼ� null�� ��ȯ����

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();

			session.setAttribute("cart", cart);
		}

//		�Ű������� ���޹޴� sucartbean��ǰ��ü�� push�޼ҵ� ȣ�� �� �ٽ� �����Ͽ�
//		SuCartBean��ǰ��ü�� cartŬ������ arraylist�� �߰�
		cart.push(cartbean);

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", cartbean.getSuname() + "�� ��ǰ�� " + cartbean.getSuqty() + "�� �߰��߽��ϴ�.");

		mav.addObject("cart", cart);
		mav.addObject("center", "SuCartResult.jsp");
		mav.addObject("left", "SujakLeft.jsp");

		mav.setViewName("ShoppingMain");

		return mav;
	}

	@RequestMapping("/suinfo.do")
	public ModelAndView suInfo(int suno) {
		SuBean sbean = shoppingDAO.getOneSutool(suno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("sbean", sbean);
		// centerȭ������.. "SuJakInfo.jsp"���ڿ� �����͸� ..
		// �Ʒ��� ShoppingMain.jsp�� �����ֱ� ����... new ModelAndView��ü�� ���
		mav.addObject("center", "SujakInfo.jsp");
		// leftȭ������ "SujakLeft.jsp"���ڿ� �����͸�..
		// �Ʒ��� ShoppingMain.jsp�� �����ֱ� ����... new ModelAndView��ü�� ���
		mav.addObject("left", "SujakLeft.jsp");
		// �̵��� ���������� -> ShoppingMain.jsp ��..Ȯ���ڸ��� �A ShoppingMain ���
		mav.setViewName("ShoppingMain");
		return mav;
	}

	@RequestMapping("/sujak.do")
	public ModelAndView sujak(String num) {// �Ķ���� num�� : left������ �����޴� ���� Ű��

		ModelAndView mav = new ModelAndView();

		// left�������� �����޴� �� � �޴��� ������ ��û�� ���Դ����� ���� num���� ��� �Ǵ�
		if (num == null) {

			/*
			 * DB�� �����Ͽ� �˻��� ��� ���۾������� �����;� �Ѵ�. �׷��⿡ �ռ� DTO������ �ϴ� Ŭ���� ���� �� subeanŬ���� ����(DTO)
			 */

			/* DB�� �����Ͽ� �˻��� ��� ���۾�����(SuBean)�� List�� ��Ƽ� ��ȯ�ޱ� */
			List<SuBean> list = shoppingDAO.getAllSutool();

			mav.addObject("list", list);

		} else {
			List<SuBean> list = shoppingDAO.getSelectSutool(num);

			mav.addObject("list", list);

		}
		// centerȭ������ "SujakCenter.jsp"���ڿ� �����͸�
		// �Ʒ��� ShoppingMain.jsp�� �����ֱ� ���� new ModelAndView��ü�� ���
		mav.addObject("center", "SujakCenter.jsp");

		// leftȭ������ "SujakLeft.jsp"���ڿ� �����͸�
		// �Ʒ��� ShoppingMain.jsp�� �����ֱ� ���� new ModelAndView��ü�� ���
		mav.addObject("left", "SujakLeft.jsp");

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
