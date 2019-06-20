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

import db.CarDAO;
import db.CarDataAccessObject;
import db.CarListBean;
import db.CarOrderBean;
import sun.rmi.server.Dispatcher;

@WebServlet("/CarOrderController.do")
public class CarOrderController extends HttpServlet{

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

		CarOrderBean cbean = new CarOrderBean();
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
		cbean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
		cbean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
		cbean.setCarins(Integer.parseInt(request.getParameter("carins")));
		cbean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));
		cbean.setCarnave(Integer.parseInt(request.getParameter("carnave")));
		cbean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		cbean.setCarbegindate(request.getParameter("carbegindate"));
		cbean.setMemberphone(request.getParameter("memberphone"));
		cbean.setMemberpass(request.getParameter("memberpass"));
		
		CarDAO cdao = new CarDAO();
		
		cdao.insertCarOrder(cbean);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CarListController.do");
		dispatcher.forward(request, response);
		
	}

}
