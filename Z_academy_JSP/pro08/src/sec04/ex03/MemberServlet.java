package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8090/pro08/member 웹브라우저를 이용하여 회원검색 요청
@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 요청 값 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// DB작업을 담당할 객체 생성
		MemberDAO dao = new MemberDAO();
		//DB로부터 회원정보를 검색하기 위해 MemberDAO의 listMembers()메소드를 호출함
		ArrayList<?> list = dao.listMembers();
		//검색된 회원정보는 ArrayList에 저장되어 있다.
		//그러므로 두 번째 서블릿으로 ArrayList를 전달하기 위해 request라는 객체영역에 수동으로 저장
		//request객체 자체를 전달 할 수 있다.
		request.setAttribute("memberList", list);
		//바인딩한 request객체를 viewMembers매핑주소에 대한 서블릿으로 포워딩합니다.
		RequestDispatcher rd = request.getRequestDispatcher("viewmembers");
		
		rd.forward(request, response);
		
	}//doHandle 닫는 부분

}//memberServlet2 닫는부분
