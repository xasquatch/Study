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
import db.CarOrderBean;
import sun.rmi.server.Dispatcher;

@WebServlet("/CarOptionController.do")
public class CarOptionController extends HttpServlet{

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
		int carqty = Integer.parseInt(request.getParameter("carqty"));	
		int carprice = Integer.parseInt(request.getParameter("carprice"));	
		int carreserveday = Integer.parseInt(request.getParameter("carreserveday"));
		
		int carins = Integer.parseInt(request.getParameter("carins"));
		int carwifi = Integer.parseInt(request.getParameter("carwifi"));
		int carnave = Integer.parseInt(request.getParameter("carnave"));
		int carbabyseat = Integer.parseInt(request.getParameter("carbabyseat"));
		//적용값 되면 1 아니면 0
		
		int totalreserve = carqty * carreserveday * carprice;
		int totaloption = (carins+carwifi+carnave+carbabyseat)*(carreserveday*10000)*carqty;
		
		CarOrderBean cbean = new CarOrderBean();
			cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
			cbean.setCarqty(carqty);
			cbean.setCarreserveday(carreserveday);
			cbean.setCarins(carins);
			cbean.setCarnave(carnave);
			cbean.setCarbabyseat(carbabyseat);
			cbean.setCarbegindate(request.getParameter("carbegindate"));
		
		request.setAttribute("cbean", cbean);
		request.setAttribute("totalreserve", totalreserve);
		request.setAttribute("totaloption", totaloption);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CarMain.jsp?center=CarOrder.jsp");
		dispatcher.forward(request, response);
	}

}
