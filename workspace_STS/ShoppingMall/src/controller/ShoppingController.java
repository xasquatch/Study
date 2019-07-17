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
import model.SuCartBean;

public class ShoppingController {

	ShoppingDAO shoppingDAO;

	public void setShoppingDAO(ShoppingDAO shoppingDAO) {
		this.shoppingDAO = shoppingDAO;
	}

	
	@RequestMapping("/sutoolcart.do")
	public ModelAndView sutoolCart(SuCartBean cartbean, HttpSession session) {
		
		
//		기존의 cart객체를 사용하기 위해서 session에 저장되어 있는
//		cart객체 꺼내오기
//		참고 1 : cart클래스 내부에는 arraylist객체가 존재한다.
//		참고 2 : 처음에는 session영역에 cart객체가 존재하지 않아서 null을 반환받음
		
		Cart cart = (Cart)session.getAttribute("cart");
		
			if (cart == null) {
				cart = new Cart();
				
				session.setAttribute("cart", cart);
			}
				
//		매개변수로 전달받는 sucartbean상품객체를 push메소드 호출 시 다시 전달하여
//		SuCartBean상품객체를 cart클래스의 arraylist에 추가
		cart.push(cartbean);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", cartbean.getSuname()+"의 상품을 "+ cartbean.getSuqty()+"개 추가했습니다.");
		
		mav.addObject("cart", cart);
		mav.addObject("center","SuCartResult.jsp");
		mav.addObject("left","SujakLeft.jsp");
		
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	@RequestMapping("/suinfo.do")
	public ModelAndView suInfo(int suno) {	
		SuBean sbean = shoppingDAO.getOneSutool(suno);	
		ModelAndView mav = new ModelAndView();	
		mav.addObject("sbean", sbean);
		//center화면으로.. "SuJakInfo.jsp"문자열 데이터를 ..
		//아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("center", "SujakInfo.jsp");	
		//left화면으로 "SujakLeft.jsp"문자열 데이터를..
		//아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("left", "SujakLeft.jsp");	
		//이동할 뷰페이지명 -> ShoppingMain.jsp 중..확장자명을 뺸 ShoppingMain 담기
		mav.setViewName("ShoppingMain");
		return mav;	
	}
	
	@RequestMapping("/sujak.do")
	public ModelAndView sujak(String num) {//파라미터 num값 : left영역의 하위메뉴 전달 키값
		
		ModelAndView mav = new ModelAndView();
		
		//left영역에서 공구메뉴 중 어떤 메뉴를 눌러서 요청이 들어왔는지에 대한  num값을 얻어 판단
		if (num == null) {
			
			/*DB에 접근하여 검색한 모든 수작업공구를 가져와야 한다.
			 *그러기에 앞서 DTO역할을 하는 클래스 생성 → subean클래스 생성(DTO)
			 */
			
			/*DB에 접근하여 검색한 모든 수작업공구(SuBean)을 List에 담아서 반환받기*/
			List<SuBean> list = shoppingDAO.getAllSutool();
			
			mav.addObject("list",list);
			
		}else {
			List<SuBean> list = shoppingDAO.getSelectSutool(num);
			
			mav.addObject("list",list);
			
		}
		//center화면으로 "SujakCenter.jsp"문자열 데이터를
		//아래의 ShoppingMain.jsp로 보내주기 위해 new ModelAndView객체에 담기
		mav.addObject("center","SujakCenter.jsp");
		
		//left화면으로 "SujakLeft.jsp"문자열 데이터를
		//아래의 ShoppingMain.jsp로 보내주기 위해 new ModelAndView객체에 담기
		mav.addObject("left","SujakLeft.jsp");
		
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
