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

import db.CarDataAccessObject;
import db.CarListBean;
import sun.rmi.server.Dispatcher;

@WebServlet("/CarListController.do")
public class CarListController extends HttpServlet{

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
		
		CarDataAccessObject dao = new CarDataAccessObject();
		Vector<CarListBean> v = dao.getAllCarList();
		request.setAttribute("vector", v);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp?center=CarList.jsp");
		dispatcher.forward(request, response);
		
	}

}
