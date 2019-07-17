package controller;

import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

//상품에 내용을 ArrayList에 저장하고
//또는 카트에 기존 상품이 존재 한다면 수량만 증가 시키는 클래스,
//카트에 저장된 상품을 삭제하는 기능과 모든 상품을 카트에서 삭제 시키는 클래스
public class Cart {//참고 : 수작업공구 뿐만 아니라 전동공구에 동시에 사용할수 있기떄문에
				   //     일부러 하나의 Cart클래스를 만듬

	//여러개의 SuCartBean상품(수작업공구상품 또는 전동공구상품)을 저장하기 위한
	//용도의? ArrayList객체생성
	//참고! 이 ArrayList객체를 포함하고 있는 Cart객체는 나중에 session영역에 저장된다.
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();
	
	//ArrayList객체를 반환하는 메소드
	public List<SuCartBean>  getItemlist(){
		return itemlist;
	}
	
	//메소드 설명!!
	//SuJakInfo.jsp페이지에서 "카드담기"버튼을 눌렀을떄..
	//ShoppingController.java의  
	//sutoolCart(SuCartBean cartbean, HttpSession sesion)메소드의...
	//인자로 전달받은 cartbean객체를 다시!! 아래의 push(SuCartBean cartbean)메소드의
	//인자로 전달 받아... ArrayList객체에 상품을 추가시키는 메소드임.
	//하는일:
	//   기존에 ArrayList공간에 SuCartBean상품객체 정보가 존재한다면..
	//   수량만 증가 시키고, 기존에 상품객체 정보가 존재하는지 존재하지 않는지 알아내는
	//   플래그값을 활용함.
	public void push(SuCartBean cartbean) {
		//기존에 상품이 있는지를 알아내기 위한 변수
		boolean alreadysutool = false;
		
		//ArrayList itemlist에 저장되어 있는 SuCartBean객체의 개수 만큼 반복
		for(SuCartBean suCartBean  : itemlist) {
			
			//ArrayList에 저장되어 있는 SuCartBean객체의 수작업공구번호와
			//push메소드의 매개변수로 전달받는 SuCartBean객체의  수작업공구번호와
			//비교하여 같으면...
			if(cartbean.getSuno() == suCartBean.getSuno()) {
				//동일한 상품이 존재 하기에 수량만 증가
				suCartBean.setSuqty(suCartBean.getSuqty() 
									+ cartbean.getSuqty());
				//기존에 상품이 존재 하면  true변경
				alreadysutool = true;
				break;
			}//if
		}//for
		//기존에 상품이 없는 경우에는 상품을 추가 시켜 주어야 합니다.
		if(alreadysutool == false) {
			//ArrayList객체에 새로운 SuCartBean상품객체 추가
			itemlist.add(cartbean);
		}
		
	}//push메소드 끝
	
}//Cart클래스 끝




