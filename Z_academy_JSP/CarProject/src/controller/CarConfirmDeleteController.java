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

//CarConfirmDelete.jsp화면에서 삭제시 비밀번호 입력후...
//CarConfirmDeleteController.java서블릿으로 예약삭제 요청이 들어 올때.. 
//삭제할 예약정보에 관한 orderid 값과  입력했던 비밀번호를 전달 받는다.
@WebServlet("/CarConfirmDeleteController.do")
public class CarConfirmDeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//요청값 얻기
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String memberpass = request.getParameter("memberpass");
		
		//데이터베이스에 연결하여 삭제
		CarDAO cdao = new CarDAO();
		//DELETE작업을 위해... carOrderDelete()메소드 호출시..주문아이디와 입력했던 비밀번호를 전달
		int result = cdao.carOrderDelete(orderid,memberpass);
		
		//DELETE에 성공하면...
		if(result != 0){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.alert('예약 정보가 삭제 되었습니다.')");
			out.println("location.href='CarListController.do'");
			out.println("</script>");
		}else{//DELETE에 실패하면..  result  = 0
			request.setAttribute("result", result);
			//디스패치 방식으로  포워딩
			RequestDispatcher dis = 
			request.getRequestDispatcher("CarMain.jsp?center=CarConfirmDelete.jsp");
			dis.forward(request, response);
		}	
	}//doPost 끝	
}//서블릿 끝







