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

/*CarReserveResult.jsp���������� ������ư�� Ŭ��������..
  ����� ������ �ֹ� id, ����� ������ �̹������� ���޹޴� ����*/
@WebServlet("/CarConfirmUpdateController.do")
public class CarConfirmUpdateController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			/*1.Ŭ���̾�Ʈ�� ��û�� ���޹ޱ�*/
			//CarReserveResult.jsp���������� ������ �ϳ��� ������ ���Ͽ�..
			//�����ϱ� ��ư�� ������.. �����ؿ��� carimg, orderid �� �ޱ�
			String carimg = request.getParameter("carimg");
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			
			/*2. orderid�� ���ؼ� ������ �ϳ��� ���������� �˻��ؿ������� DB�۾��� ��*/
			CarDAO cdao = new CarDAO();
			//������ id�� �����Ͽ� �ϳ��� �ֹ������� ������ �޼ҵ� ȣ��!
			CarConfirmBean cbean = cdao.getOneOrder(orderid);
			//���� �̹������� �߰�
			cbean.setCarimg(carimg);
			
			/*3. View��������  CarConfirmBean��ü�� �����ϱ����� ���� request��ü������ ����*/
			request.setAttribute("cbean", cbean);
			
			/*4. View������ ��������!! request���� ����*/
			RequestDispatcher dis = 
			request.getRequestDispatcher("CarMain.jsp?center=CarConfirmUpdate.jsp");
			dis.forward(request, response);
		
		}
	
	
	
	
	
}




