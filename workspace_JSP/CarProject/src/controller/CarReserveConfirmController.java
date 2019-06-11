package controller;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import db.CarConfirmBean;
import db.CarDAO;
import db.CarDataAccessObject;
import db.CarListBean;
import sun.rmi.server.Dispatcher;

@WebServlet("/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		CarDAO cdao = new CarDAO();
		Vector<CarConfirmBean> v = cdao.getAllCarOrder(memberphone,memberpass);
		
		request.setAttribute("vector", v);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp?center=CarReserveResult.jsp");
		dispatcher.forward(request, response);
		
	}

}
