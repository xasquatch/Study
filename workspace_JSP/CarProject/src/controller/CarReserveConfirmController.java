package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarConfirmBean;
import db.CarDAO;
import db.CarListBean;

/*
 CarReserveConfirm.jsp <예약확인> 페이지에서 
 입력한 정보(전화번호,비밀번호)를 요청값으로 전달 받는 서블릿..
 */
@WebServlet("/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				   throws ServletException, IOException {
		requestPro(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				   throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) 
			   throws ServletException, IOException {
			
		//CarReserveConfirm.jsp 페이지에서 사용자로 부터 입력한 전화번호, 비밀번호 얻기
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		CarDAO cdao = new CarDAO();
		
		//예약 확인을 위해..
		//렌트 예약시 입력했던 비회원 전화번호와 , 패스워드를 메소드의 매개변수의 값으로 전달 하여..
		//조건1. 전화번호와 비밀번호를 기준으로 하여 검색 해야 한다.
		//조건2. 현재 날짜보다 이전날짜의  예약 현황은 보여 주지 말아라.
		
		//검색한 예약정보를 담고있는 백터를 반환 받음
		Vector<CarConfirmBean>  v = cdao.getAllCarOrder(memberphone,memberpass);
		
		//CarReserveResult.jsp(예약현황정보를 출력하여 확인 하는 View페이지)로...
		//백터를 전달 해야 하기 때문에..request객체영역에 백터를 저장!
		request.setAttribute("vector", v);
		
		//디스패치 방식으로 포워딩
		RequestDispatcher dis = 
			request.getRequestDispatcher("CarMain.jsp?center=CarReserveResult.jsp");
		dis.forward(request, response);
	}
	
}






