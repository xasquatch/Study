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

@WebServlet("/CarInfoController.do")
public class CarInfoController extends HttpServlet{

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
		int carno = Integer.parseInt(request.getParameter("carno"));
		
		CarDataAccessObject dao = new CarDataAccessObject();
		CarListBean bean = dao.getOneCar(carno);
		request.setAttribute("bean", bean);

		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp?center=CarInfo.jsp");
		dispatcher.forward(request, response);
		
	}

}
