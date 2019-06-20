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
  ���� ���� ���� ������������? CarConfirmUpdate.jsp����������.... 
  ������ ������ ������ ~  ��й�ȣ�� �Է��ϰ� ������ư�� Ŭ���� ������û�޴� ����
*/
@WebServlet("/CarConfirmUpdateProcController.do")
public class CarConfirmUpdateProcController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		/*1. ������ ����(��û��) ���� �ޱ� */
		int orderid = Integer.parseInt(req.getParameter("orderid"));
		int carreserveday = Integer.parseInt(req.getParameter("carreserveday")); 
		int carqty = Integer.parseInt(req.getParameter("carqty"));
		int carins = Integer.parseInt(req.getParameter("carins"));
		int carwifi = Integer.parseInt(req.getParameter("carwifi"));
		int carbabyseat = Integer.parseInt(req.getParameter("carbabyseat"));
		String carbegindate = req.getParameter("carbegindate");
		String memberpass = req.getParameter("memberpass");	
		
		/*2. CarOrderBean��ü�� �̿��Ͽ� ������ �����͵��� ��������  DAO��ü�� �����Ͽ� ����DB�۾��� ��*/
		CarOrderBean bean = new CarOrderBean();
		//setter�޼ҵ带 �̿��Ͽ� �������� ����
		bean.setOrderid(orderid);
		bean.setCarreserveday(carreserveday);
		bean.setCarbabyseat(carbabyseat);
		bean.setCarbegindate(carbegindate);
		bean.setCarqty(carqty);
		bean.setCarins(carins);
		bean.setCarwifi(carwifi);
		bean.setMemberpass(memberpass);
		
		/*3. CarDAO��ü�� �����Ͽ� ������ �Է��� ��������(CarOrderBean��ü����)�� DB�� UPDATE  */
		CarDAO cdao = new CarDAO();
		cdao.carOrderUpdate(bean); //UPDATE�۾�
		
		/*4. UPDATE�� �����ϸ� �ٽ� CarList.jspȭ���� ���û!�Ͽ� �̵�~ */
		RequestDispatcher dis = req.getRequestDispatcher("CarListController.do");
		dis.forward(req, resp);
		
	}
}











