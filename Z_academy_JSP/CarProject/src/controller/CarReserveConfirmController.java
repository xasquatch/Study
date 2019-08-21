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
 CarReserveConfirm.jsp <����Ȯ��> ���������� 
 �Է��� ����(��ȭ��ȣ,��й�ȣ)�� ��û������ ���� �޴� ����..
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
			
		//CarReserveConfirm.jsp ���������� ����ڷ� ���� �Է��� ��ȭ��ȣ, ��й�ȣ ���
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		CarDAO cdao = new CarDAO();
		
		//���� Ȯ���� ����..
		//��Ʈ ����� �Է��ߴ� ��ȸ�� ��ȭ��ȣ�� , �н����带 �޼ҵ��� �Ű������� ������ ���� �Ͽ�..
		//����1. ��ȭ��ȣ�� ��й�ȣ�� �������� �Ͽ� �˻� �ؾ� �Ѵ�.
		//����2. ���� ��¥���� ������¥��  ���� ��Ȳ�� ���� ���� ���ƶ�.
		
		//�˻��� ���������� ����ִ� ���͸� ��ȯ ����
		Vector<CarConfirmBean>  v = cdao.getAllCarOrder(memberphone,memberpass);
		
		//CarReserveResult.jsp(������Ȳ������ ����Ͽ� Ȯ�� �ϴ� View������)��...
		//���͸� ���� �ؾ� �ϱ� ������..request��ü������ ���͸� ����!
		request.setAttribute("vector", v);
		
		//����ġ ������� ������
		RequestDispatcher dis = 
			request.getRequestDispatcher("CarMain.jsp?center=CarReserveResult.jsp");
		dis.forward(request, response);
	}
	
}






