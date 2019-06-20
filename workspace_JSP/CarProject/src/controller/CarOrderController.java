package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarListBean;
import db.CarOrderBean;

/*CarOrder.jsp페이지에서 결제하기 버튼을 클릭했을떄.. 요청정보를 전달 받는 서블릿*/
@WebServlet("/CarOrderController.do")
public class CarOrderController extends HttpServlet {

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
			//요청데이터 한글 처리
			request.setCharacterEncoding("UTF-8");
			
			//CarOrder.jsp페이지에서 전달받은 요청데이터를 자바빈 역할을 하는 CarOrderBean에 저장
			CarOrderBean cbean = new CarOrderBean();
			cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
			cbean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
			cbean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
			cbean.setCarbegindate(request.getParameter("carbegindate"));
			cbean.setCarins(Integer.parseInt(request.getParameter("carins")));
			cbean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));
			cbean.setCarnave(Integer.parseInt(request.getParameter("carnave")));
			cbean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
			cbean.setMemberphone(request.getParameter("memberphone"));
			cbean.setMemberpass(request.getParameter("memberpass"));
			
			//insert 예약 작업을 할 CarDAO객체 생성
			CarDAO cdao = new CarDAO();
			/*먼저 할일!*/
			//CarDAO클래스에 주문현황을 DB에 추가하는 일을 하는 메소드를 만들자
			//메소드이름 : insertCarOrder(CarOrderBean bean)
			
			//예약 현황을 DB에 저장하는 메소드 호출시...
			//자바빈역할을 하는 CarOrderBean객체 전달하여 insert
			cdao.insertCarOrder(cbean);
			
			//디스패치 방식으로  CarList.jsp로 포워딩 하여 이동
			RequestDispatcher dis = 
					request.getRequestDispatcher("CarListController.do");
			dis.forward(request, response);
				
	}
	
}






