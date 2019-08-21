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

//CarList.jsp페이지 에서 carno를 전달받아.. 요청받는 서블릿
//하나의 자동차를 렌트 하기 위해 .. 하나의 자동차정보를 검색 해줘~~ 요청이 들어오면 처리하는 서블릿
@WebServlet("/CarInfoController.do")
public class CarInfoController extends HttpServlet {

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
			
			//한글처리
			request.setCharacterEncoding("UTF-8");
		
			int carno =  Integer.parseInt(request.getParameter("carno"));
			
			//하나의 차량 검색을위해  MVC중..Model역할을 하는 CarDAO객체 생성
			CarDAO cdao = new CarDAO();
			
			CarListBean bean = cdao.getOneCar(carno);
			
			request.setAttribute("bean", bean);
			
			//디스패치 방식을 이용한 포워딩
			RequestDispatcher dis = 
					request.getRequestDispatcher("CarMain.jsp?center=CarInfo.jsp");
			//재요청시 ~ 데이터를 넘기시오
			dis.forward(request, response);
	}
	
}






