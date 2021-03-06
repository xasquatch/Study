package controller;

import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

//상품에 내용을  ArrayList에 저장하고
//또는 카트에 기존 상품이 조재한다면 수량만 증가시키는 클래스
//카트에 저장된 상품을 삭제하는 기능과 모든 상품을 캌트에서 삭제 시키는 클래스
public class Cart {

//	여러개의 sucartbean상품(수작업 공구상품또는 전동공구상품)을 저장하기 위한
//	용도의 ArrayList객체 생성
//	참고 이 ArrayList객체를 포함하고 있는 Cart객체는 나중에  session영역에 저장된다
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();

	public List<SuCartBean> getItemlist() {
		return itemlist;
	}

//	메소드설명
//	sujakinfo.jsp페이지에서 카드담기 번튼을 눌렀을 떄
//	shoppingcontroller.java의 sutoolcart(sucartbean cartbean, httpsession session)메소드의
//	인자로 전달을 받은 cartbean객체를 다시 아래의 push(sucartbeam cartbean)메소드의
//	인자로 전달받아  arraylist객체에 상품을 추가시키는 메소드임
//	
//	기능 1: 기존 arraylist공간에 sucartbean상품객체 정보가 존재한다면
//			수량만 증가시키고, 기존에 상품객체 정보가 존재하는지 알아낼수있는 플래그값을  활용
//			
	public void push(SuCartBean cartbean) {

		boolean alreadysutool = false;

//		arraylist itemlist에 저장되어 있는 sucartbean객체의 개수만큼 반복
		for (SuCartBean suCartBean : itemlist) {

//			ArrayList에 저장되어 있는 sucartbean객체의 수작업 공구번호와
//			push메소드의 매개변수로 전달받은 sucartbean객체의 수작업공구번호와 비교하여 같으면
			if (cartbean.getSuno() == suCartBean.getSuno()) {

				suCartBean.setSuqty(suCartBean.getSuqty() + cartbean.getSuqty());

				alreadysutool = true;
				break;
			}

		}

		if (alreadysutool == false) {
			itemlist.add(cartbean);
		}

	}

	public void deleteCart(int suno) {

		for (SuCartBean suCartBean : itemlist) {

			if (suCartBean.getSuno() == suno) {
				itemlist.remove(suCartBean);
				break;
			}

		}

	}

}
