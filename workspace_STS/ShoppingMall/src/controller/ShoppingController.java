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
