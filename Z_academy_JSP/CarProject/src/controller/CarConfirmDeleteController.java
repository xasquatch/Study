package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;

//CarConfirmDelete.jspȭ�鿡�� ������ ��й�ȣ �Է���...
//CarConfirmDeleteController.java�������� ������� ��û�� ��� �ö�.. 
//������ ���������� ���� orderid ����  �Է��ߴ� ��й�ȣ�� ���� �޴´�.
@WebServlet("/CarConfirmDeleteController.do")
public class CarConfirmDeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//��û�� ���
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String memberpass = request.getParameter("memberpass");
		
		//�����ͺ��̽��� �����Ͽ� ����
		CarDAO cdao = new CarDAO();
		//DELETE�۾��� ����... carOrderDelete()�޼ҵ� ȣ���..�ֹ����̵�� �Է��ߴ� ��й�ȣ�� ����
		int result = cdao.carOrderDelete(orderid,memberpass);
		
		//DELETE�� �����ϸ�...
		if(result != 0){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.alert('���� ������ ���� �Ǿ����ϴ�.')");
			out.println("location.href='CarListController.do'");
			out.println("</script>");
		}else{//DELETE�� �����ϸ�..  result  = 0
			request.setAttribute("result", result);
			//����ġ �������  ������
			RequestDispatcher dis = 
			request.getRequestDispatcher("CarMain.jsp?center=CarConfirmDelete.jsp");
			dis.forward(request, response);
		}	
	}//doPost ��	
}//���� ��







