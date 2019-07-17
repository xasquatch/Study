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
	
	
	//SuJakInfo.jsp페이지에서 "카트담기"버튼을 누르면 호출되는 메소드로
	//"카드담기"버튼을 누르면 전달받는 값들은 자동으로 SuCartBean클래스의 각변수에
	//맵핑되어 저장되게됨.또한 매개변수로 전달 받게 됨.
	@RequestMapping("/sutoolcart.do")
	public ModelAndView sutoolCart(SuCartBean cartbean,
								   HttpSession session) {
		
		//기존의 Cart객체를 사용하기 위해서 session에 저장되어 있는
		//Cart객체 꺼내오기!
		//참고! Cart클래스 내부에는 ArrayList객체가 존재 한다.
		//참고! 처음에는 session영역에 Cart객체가 존재하지 않아서 null을 반환 받음
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null) {//기존 session영역에 Cart객체가 존재 하지 않으면
			
			cart = new Cart();
			
			//세션영역에 Cart객체를 저장
			session.setAttribute("cart", cart);
		}
		
		//매개변수로 전달받는 SuCartBean상품객체를 push메소드 호출시 다시 전달하여
		//SuCartBean상품객체를 Cart클래스의 ArrayList에 추가 
		cart.push(cartbean);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", 
					  cartbean.getSuname() + "의 상품을 " 
		              + cartbean.getSuqty() + "개 추가했습니다.");
		mav.addObject("cart", cart);
		mav.addObject("center", "SuCartResult.jsp");
		mav.addObject("left", "SujakLeft.jsp");
		
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
		
	//SujakCenter.jsp페이지에서 수작업공구 이미지 하나를 클릭했을때..
	//공구번호를 메소드의 매개변수로 전달받아.. 공구번호에 해당하는 수작업공구를
	//DB로부터 검색해서 얻기 위한 메소드 
	@RequestMapping("/suinfo.do")
	public ModelAndView suInfo(int suno) {	
		SuBean sbean = shoppingDao.getOneSutool(suno);	
		ModelAndView mav = new ModelAndView();	
		mav.addObject("sbean", sbean);
		//center화면으로.. "SuJakInfo.jsp"문자열 데이터를 ..
		//아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("center", "SuJakInfo.jsp");	
		//left화면으로 "SujakLeft.jsp"문자열 데이터를..
		//아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("left", "SujakLeft.jsp");	
		//이동할 뷰페이지명 -> ShoppingMain.jsp 중..확장자명을 뺸 ShoppingMain 담기
		mav.setViewName("ShoppingMain");
		return mav;	
	}
	
	
	
	
	
	@RequestMapping("/sujak.do") //수작업공구 화면 보여주세요~
	public ModelAndView suJak(String num) {
		
		ModelAndView mav = new ModelAndView();
		
		//Left영역에서 공구메뉴중 어떤 메뉴를 눌러서 요청이 들어 왔는지 에 대한 num값을 얻어 판단
		if(num == null) {//신제품을 누르거나 또는 top.jsp페이지에 있는 메뉴중..수작업 공구 메뉴를 눌렀다면			
			//먼저할일!
			//DB에접근하여.. 검색한 모든 수작업공구를 가져와야 한다.
			//그러기에 앞서 DTO역할을 하는 클래스를 만들자 -> SuBean클래스 만들기 
		
			//DB에 접근하여 검색한 모든 수작업공구들(SuBean들)을 List에 담아서 반환받기
			List<SuBean> list = shoppingDao.getAllSutool();
			
			mav.addObject("list", list);
			
		}else {//해당 메뉴들 선택시 사용되는 소스 
			
			//SujakLeft.jsp페이지의 카테고리별 메뉴 중 하나를 선택한 값을 전달하여
			//DB에 검색한 수작업공구들(SuBean객체들)을  List에 담아 반환 받기
			List<SuBean> list = shoppingDao.getSelectSutool(num);
			
			mav.addObject("list", list);
		}
		//center화면으로.. "SujakCenter.jsp"문자열 데이터를 ..
		//아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("center", "SujakCenter.jsp");
		
		//left화면으로 "SujakLeft.jsp"문자열 데이터를..
		//아래의 ShoppingMain.jsp로 보내주기 위해... new ModelAndView객체에 담기
		mav.addObject("left", "SujakLeft.jsp");
		
		//이동할 뷰페이지명 -> ShoppingMain.jsp 중..확장자명을 뺸 ShoppingMain 담기
		mav.setViewName("ShoppingMain");
		
		return mav;

	}
	
	
	
	@RequestMapping("/index.do")//index.do라는 주소로 요청이 들어오면 아래의 메소드를 실행하시오.
	public ModelAndView index(HttpSession session) {//회원가입 정보를 사용하기 위하여 세션을 전달 받음
		
		//응답할 데이터 + View명을 저장할 용도의 객체 생성
		ModelAndView mav = new ModelAndView();
		
		//회원정보를 사용하기 위해 세션영역에서 얻기 
		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		//세션영역에 MemberBean객체가 저장되어 있냐 없냐에 따라서.. 로그인처리
		if(mbean == null) {
			mav.addObject("mbean", null);//데이터를 아래의 ShoppingMain.jsp로 보내주기위해 
										 //데이터 담기 
			mav.setViewName("ShoppingMain"); //확장자명을 뺸 나머지 뷰이름 저장
			
		}else {
			mav.addObject("mbean", mbean);//데이터를 아래의 ShoppingMain.jsp로 보내주기위해 
										  //데이터 담기 
			mav.setViewName("ShoppingMain"); //확장자명을 뺸 나머지 뷰이름 저장
		}
		
		return mav;
	}
	
	
}




