package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*MCV중... C의 역활(controller)을 하는 서블릿 클래스
 1. 클라이언트의 요청을 처음 전달 받는곳
 2. M(Model)과 V(View)를 연결시켜주는 컨트롤러 역할을 함
 
*/
@WebServlet("/mem.do")//← DB로부터 회원정보를 검색해서 보여줘!(?)
public class MemberController extends HttpServlet {

	MemberDataAccessObject dao;
	
	@Override
	public void init() throws ServletException {
		dao = new MemberDataAccessObject();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
/*해당 서블릿을 DB로부터 회원정보를 검색 해줘! 라는 요청을 /mem.do라는 매핑주소로 전달받았기 때문에
 서블릿은 그 요청에 응답 결과물을 생성하여 응답해야 하므로
 MemberDataAccessObject의 listMembers()메소드를 호출하여 요청에 대해 DB로 부터 검색한 회원정보들을 ArrayList로 반환받기
*/
		List<MemberValueObject> memlist = dao.listMembers();
		request.setAttribute("list", memlist);
		RequestDispatcher disptcher = request.getRequestDispatcher("/test01/listMembers.jsp");
		disptcher.forward(request, response);
		
		
	}
	
	
	
	
}
