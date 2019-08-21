package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarOrderBean;

//CarOption.jsp페이지 화면에서.. 선택한 옵션정보를 읽어드린 후 
//차량 기본금액 + 옵션총금액을 계산하여...
//자바빈클래스(OrderBean클래스)의 각 변수에 예약정보들을 모두 저장함.
/*
 CarOption.jsp(옵션선택화면)에서 [예약]버튼을 클릭했을떄...
  클라이언트의 요청을 받는 서블릿 
*/
@WebServlet("/CarOptionController.do")
public class CarOptionController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		//CarOption.jsp에서 전달한 금액 연산을위하여 데이터를 request영역에서 얻기
		int carqty = Integer.parseInt(request.getParameter("carqty")); //대여 수량 
		int carprice = Integer.parseInt(request.getParameter("carprice"));//대여금액
		int carreserveday = Integer.parseInt(request.getParameter("carreserveday"));//대여기간
				
		//보험비 적용여부 받기  = 보험적용 1일이면 : 값 1받기
		//보험비 적용여부 받기  = 보험 비적용이면 : 값 0받기
		int carins = Integer.parseInt(request.getParameter("carins"));
		
		//무선 WIFI 적용여부 받기  = 적용 1일이면 : 값 1받기
		//무선 WIFI 적용여부 받기  = 비적용이면 : 값 0받기
		int carwifi = Integer.parseInt(request.getParameter("carwifi"));
		
		//네비게이션 적용여부 받기  = 적용(무료) : 값 1받기
		//네비게이션 적용여부 받기  = 비적용이면 : 값 0받기
		int carnave = Integer.parseInt(request.getParameter("carnave"));
				
		//베이비시트 적용여부 받기  = 적용 1일이면 : 값 1받기
		//베이비시트 적용여부 받기  = 비적용이면 : 값 0받기
		int carbabyseat = Integer.parseInt(request.getParameter("carbabyseat"));
		
		//차량가액 = 수량 * 대여기간 * 차량가격
		int totalreserve = carqty * carreserveday * carprice;
		
		//옵션금액 = 각종 옵션에 대여기간과 수량을 곱해서 리턴
		int totaloption = 
		((carins * carreserveday) 
		 + (carwifi * carreserveday) 
		 + (carbabyseat * carreserveday)) * 10000 * carqty;
		
		//CarOrder.jsp쪽으로 선택했던 데이터들을 모두 넘겨 주어야함.
		//그러기에 앞서.. 위의 CarOption.jsp에서 전달한 데이터들을 담을
		//자바빈 클래스(CarOrderBean.java)를 만들자
		//-------> db패키지에 CarOrerBean.java 파일 생성
		
		//자바빈클래스 CarOrderBean에 대한 객체를 생성하여 CarOption.jsp에서 전달 받은 예약정보 담기
		CarOrderBean cbean = new CarOrderBean();
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));//예약차번호
		cbean.setCarqty(carqty);//대여수량
		cbean.setCarreserveday(carreserveday);//대여기간
		cbean.setCarwifi(carwifi);//WIFI적용여부값
		cbean.setCarins(carins);//보험적용 여부값
		cbean.setCarnave(carnave);//네베게이션 적용 여부값
		cbean.setCarbabyseat(carbabyseat);//베이비 시트 적용 여부값 
		cbean.setCarbegindate(request.getParameter("carbegindate"));//대여날짜 
		
		//CarOrder.jsp로 데이터를 넘기기위해 request내장객체영역에 저장하기 (탁자위에 올려 놓기)
		request.setAttribute("cbean", cbean);//자바빈 객체 저장
		request.setAttribute("totalreserve", totalreserve); //렌트(대여)차량 가액 저장
		request.setAttribute("totaloption", totaloption);//렌트(대여)차량 옵션 금액 저장
		
		//디스패치 방식으로 뷰로 포워딩 
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarOrder.jsp");
		dis.forward(request, response);
		
	}
}











