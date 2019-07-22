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

	//로그아웃 처리 메소드
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		
		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
//		session.setAttribute("mbean", null);
//		session.invalidate();
		session.removeAttribute("mbean");
		
		return new ModelAndView(new RedirectView("index.do"));
	}
	
	@RequestMapping("/joinproc.do")
	public ModelAndView joinproc(MemberBean mbean, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		/*
		 * 데이터베이스에 접근해서 해당 아이디가 존재하는지와 패스워드가 맞는지 비교를 위해 getlogin()메소드 호출 시 인자로
		 * memberbean객체를 전달함 getlogin()메소드의 반환값이 1이면 해당아이디가 DB에 존재한다는 의미
		 */
		int result = shoppingDAO.getLogin(mbean);

		if (result == 1) {
			mav.addObject("result", 1);
			mav.addObject("center", "joinForm.jsp");
			mav.addObject("left", "SujakLeft.jsp");
			mav.setViewName("ShoppingMain");

			/*
			 * 매개변수로 넣어둔 memberbean객체의 getter메소드를 호출하여 비밀번호 입력란과 비밀번호 확인 입력란의 값이 일치한지 조건검사
			 */
		} else if ((result == 0) && mbean.getMempasswd1().equals(mbean.getMempasswd2())) {
			/* DB에 회원을 추가하기 위해 insertmember메소드 호출시 memberbean객체 전달 */
			shoppingDAO.insertMember(mbean);
			// 회원가입 완료 후 세션에 저장(로그인처리)
			session.setAttribute("mbean", mbean);
			// 세션영역 최대 유지시간 설정
			session.setMaxInactiveInterval(60 * 30);// 30분

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

//		기존의 cart객체를 사용하기 위해서 session에 저장되어 있는
//		cart객체 꺼내오기
//		참고 1 : cart클래스 내부에는 arraylist객체가 존재한다.
//		참고 2 : 처음에는 session영역에 cart객체가 존재하지 않아서 null을 반환받음

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();

			session.setAttribute("cart", cart);
		}

//		매개변수로 전달받는 sucartbean상품객체를 push메소드 호출 시 다시 전달하여
//		SuCartBean상품객체를 cart클래스의 arraylist에 추가
		cart.push(cartbean);

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", cartbean.getSuname() + "의 상품을 " + cartbean.getSuqty() + "개 추가했습니다.");

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
		// center화면으로.. "SuJakInfo.jsp"문자열 데이터를 ..
		// 아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("center", "SujakInfo.jsp");
		// left화면으로 "SujakLeft.jsp"문자열 데이터를..
		// 아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("left", "SujakLeft.jsp");
		// 이동할 뷰페이지명 -> ShoppingMain.jsp 중..확장자명을 뺸 ShoppingMain 담기
		mav.setViewName("ShoppingMain");
		return mav;
	}

	@RequestMapping("/sujak.do")
	public ModelAndView sujak(String num) {// 파라미터 num값 : left영역의 하위메뉴 전달 키값

		ModelAndView mav = new ModelAndView();

		// left영역에서 공구메뉴 중 어떤 메뉴를 눌러서 요청이 들어왔는지에 대한 num값을 얻어 판단
		if (num == null) {

			/*
			 * DB에 접근하여 검색한 모든 수작업공구를 가져와야 한다. 그러기에 앞서 DTO역할을 하는 클래스 생성 → subean클래스 생성(DTO)
			 */

			/* DB에 접근하여 검색한 모든 수작업공구(SuBean)을 List에 담아서 반환받기 */
			List<SuBean> list = shoppingDAO.getAllSutool();

			mav.addObject("list", list);

		} else {
			List<SuBean> list = shoppingDAO.getSelectSutool(num);

			mav.addObject("list", list);

		}
		// center화면으로 "SujakCenter.jsp"문자열 데이터를
		// 아래의 ShoppingMain.jsp로 보내주기 위해 new ModelAndView객체에 담기
		mav.addObject("center", "SujakCenter.jsp");

		// left화면으로 "SujakLeft.jsp"문자열 데이터를
		// 아래의 ShoppingMain.jsp로 보내주기 위해 new ModelAndView객체에 담기
		mav.addObject("left", "SujakLeft.jsp");

//		이동할 뷰페이지명 → ShoppingMain.jsp 중 확장자명을 뺀거 적어
		mav.setViewName("ShoppingMain");
		return mav;
	}

	@RequestMapping("/index.do") // index.do라는 주소로 요청이 들어오면 아래의 메소드 실행
	public ModelAndView index(HttpSession session) {// 세션 : 회원가입정보를 사용하기 위하여 세션을 전달받음

		// 응답할 데이터 + view명을 저장할 용도의 객체 생성
		ModelAndView mav = new ModelAndView();

		// 회원저옵를 사용하기 위해 세션영역에서 memberbean객체를 얻기
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");

		if (mbean == null) {

			mav.addObject("mbean", null);// 데이터를 아래의 ShoppingMain.jsp 로 보내주기위해

			mav.setViewName("ShoppingMain");

		} else {
			mav.addObject("mbean", mbean);
			mav.setViewName("ShoppingMain");// 확장자명은 제외

		}
		return mav;
	}
}
