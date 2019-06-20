package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarListBean;

/*CarReservation.jsp페이지에서 전체검색 버튼을 클릭했을때.. 요청받는 서블릿*/
@WebServlet("/CarCategoryController.do")
public class CarCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				   throws ServletException, IOException {
		requestPro(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				   throws ServletException, IOException {
		System.out.println("요청받았음");
		
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) 
			   throws ServletException, IOException {
			
		//한글처리
		request.setCharacterEncoding("UTF-8");
	
		//전체 차량 검색을위해  MVC중..Model역할을 하는 CarDAO객체 생성
		CarDAO cdao = new CarDAO();
		
		//실제 DB에 접근하여 자동차 정보를 모두 검색해와서 얻는다.
		Vector<CarListBean> v = cdao.getAllCarList();
		
		//CarList.jsp화면에 보여질 응답데이터를 request객체영역에 담기
		request.setAttribute("vector", v);
		
		//디스패치 방식을 이용한 포워딩
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");
		//재요청시 ~ 데이터를 넘기시오
		dis.forward(request, response);
			
	}
	
}






