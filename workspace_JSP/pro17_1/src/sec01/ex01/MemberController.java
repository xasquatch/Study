package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//MVC중... C역할(컨트롤러역할)을 하는 서블릿 클래스
//1. 클라이언트의 요청을 처음 전달 받는곳.
//2. M 과  V를 연결 시켜주는 컨트롤러 역할을 함.
//3. 사장님 

@WebServlet("/mem.do")  //DB로부터 회원정보를 검색해서 보여줘 요청!
public class MemberController extends HttpServlet{

	//DB작업을 위한 MemberDAO객체를 저장할 변수 선언
	MemberDAO membarDAO;
	
	//init()메소드에서 MemberDAO객체를 초기화함
	@Override
	public void init() throws ServletException {	
		membarDAO = new MemberDAO();
	}	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse repsone) throws ServletException, IOException {
			doHandle(request, repsone);
	}	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse repsone) throws ServletException, IOException {
			doHandle(request, repsone);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse repsone) throws ServletException, IOException {
		
		//한글인코딩 
		request.setCharacterEncoding("UTF-8");
		//클라이언트의 웹브라우저에 응답할 데이터 타입 지정(MIME-TYPE 지정)
		repsone.setContentType("text/html; charset=utf-8");
		
		/*비즈니스 로직 처리 부분 명령!*/
		//서블릿을 DB로부터 회원정보를 검색 해줘! 라는 요청을 /mem.do라는 매핑주소러 전달 받았기 떄문에..
		//서블릿은 그요청에 응답결과물을 생성하여 응답 해야 하므로...
		//MemberDAO의 listMembers()메소드를 호출하여  요청에 대해 DB로부터 검색한 회원정보들을
		//ArrayList로 반환 받기
		List memberList = membarDAO.listMembers();
		
		//이떄 request내장객체 영역에 검색한 회원정보들(MemberVO객체들을 저장하고 있는 ArrayList)을
		//list라는 속성이름으로 memberList를 바인딩(저장) 합니다.
		request.setAttribute("list", memberList);
		
		//View페이지(listMembers.jsp)로  재요청하여 이동시..
		//request영역 전달 하여 View페이지에서 응답결과데이터들을 출력
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/test01/listMembers.jsp");
		//실제 재요청(이동)시 request영역, response영역전달
		dispatcher.forward(request, repsone);
	}	
	
}










