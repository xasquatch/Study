package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarConfirmBean;
import db.CarDAO;

/*CarReserveResult.jsp페이지에서 수정버튼을 클릭했을때..
  예약된 차량의 주문 id, 예약된 차량의 이미지명을 전달받는 서블릿*/
@WebServlet("/CarConfirmUpdateController.do")
public class CarConfirmUpdateController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			/*1.클라이언트의 요청값 전달받기*/
			//CarReserveResult.jsp페이지에서 예약한 하나의 차량에 대하여..
			//수정하기 버튼을 누르면.. 전달해오는 carimg, orderid 값 받기
			String carimg = request.getParameter("carimg");
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			
			/*2. orderid를 통해서 수정할 하나의 예약정보를 검색해오기위해 DB작업을 함*/
			CarDAO cdao = new CarDAO();
			//예약한 id를 전달하여 하나의 주문정보를 얻어오는 메소드 호출!
			CarConfirmBean cbean = cdao.getOneOrder(orderid);
			//차량 이미지명을 추가
			cbean.setCarimg(carimg);
			
			/*3. View페이지로  CarConfirmBean객체를 전달하기위해 먼저 request객체영역에 저장*/
			request.setAttribute("cbean", cbean);
			
			/*4. View페이지 포워딩시!! request영역 전달*/
			RequestDispatcher dis = 
			request.getRequestDispatcher("CarMain.jsp?center=CarConfirmUpdate.jsp");
			dis.forward(request, response);
		
		}
	
	
	
	
	
}




