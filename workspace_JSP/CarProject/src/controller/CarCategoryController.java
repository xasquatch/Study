package controller;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDataAccessObject;
import db.CarListBean;

@WebServlet("/CarCategoryController.do")
public class CarCategoryController extends HttpServlet{

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
		String carcategory = request.getParameter("carcategory");
		
		
		CarDataAccessObject dao = new CarDataAccessObject(); 
		Vector<CarListBean> v = dao.getCarList(carcategory);		
		request.setAttribute("vector", v);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp?center=CarList.jsp");
		dispatcher.forward(request, response);
	}

}
