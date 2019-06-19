package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarOrderBean;

/*
  차량 예약 정보 수정페이지인? CarConfirmUpdate.jsp페이지에서.... 
  예약한 정보를 수정후 ~  비밀번호를 입력하고 수정버튼을 클릭시 수정요청받는 서블릿
*/
@WebServlet("/CarConfirmUpdateProcController.do")
public class CarConfirmUpdateProcController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		/*1. 수정할 내용(요청값) 전달 받기 */
		int orderid = Integer.parseInt(req.getParameter("orderid"));
		int carreserveday = Integer.parseInt(req.getParameter("carreserveday")); 
		int carqty = Integer.parseInt(req.getParameter("carqty"));
		int carins = Integer.parseInt(req.getParameter("carins"));
		int carwifi = Integer.parseInt(req.getParameter("carwifi"));
		int carbabyseat = Integer.parseInt(req.getParameter("carbabyseat"));
		String carbegindate = req.getParameter("carbegindate");
		String memberpass = req.getParameter("memberpass");	
		
		/*2. CarOrderBean객체를 이용하여 수정할 데이터들을 저장한후  DAO객체로 전달하여 수정DB작업을 함*/
		CarOrderBean bean = new CarOrderBean();
		//setter메소드를 이용하여 각변수에 저장
		bean.setOrderid(orderid);
		bean.setCarreserveday(carreserveday);
		bean.setCarbabyseat(carbabyseat);
		bean.setCarbegindate(carbegindate);
		bean.setCarqty(carqty);
		bean.setCarins(carins);
		bean.setCarwifi(carwifi);
		bean.setMemberpass(memberpass);
		
		/*3. CarDAO객체를 생성하여 수정시 입력한 예약정보(CarOrderBean객체정보)를 DB에 UPDATE  */
		CarDAO cdao = new CarDAO();
		cdao.carOrderUpdate(bean); //UPDATE작업
		
		/*4. UPDATE에 성공하면 다시 CarList.jsp화면을 재요청!하여 이동~ */
		RequestDispatcher dis = req.getRequestDispatcher("CarListController.do");
		dis.forward(req, resp);
		
	}
}











