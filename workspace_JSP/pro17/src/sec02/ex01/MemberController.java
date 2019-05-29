package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 컨트롤러 역할을 하는 MemberController서블릿 클래스
 * 이 컨트롤러에서는 httpServletRequest객체의 getpathInfo()메소드를 이용해서
 * 두 단계로 이루어진 클라이언트의 요청 주소를 가져옴
 * action변수의 값에 따라 if문을 분기해서 요청한 작업을 수행
 */
@WebServlet("/member/*")//웹브라우저로부터 주소를 입력해서 요청시 두 단계로 요청이 이루어짐(asterisk 표시 중요)
public class MemberController extends HttpServlet {

	MemberDataAccessObject dao;
	private String nextPage = "";
	
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

		/*request객체의 getPathInfo()메소드를 호출해서 반환값으로 클라이언트의 요청 URL을 가져옴*/
		String action = request.getPathInfo();
		
		System.out.println("action : " + action);//listMembers.do : 회원정보 검색 요청
		
		/*action변수의 값에 따라 if문을 분기해서 요청한 작업을 수행하는데
		만약 action변수의 값이 null이거나 /listmembers.do인 경우에 회원검색 기능 요청이 들어왔다라는 것을 알 수 있음*/
		if (action != null){
				
				MemberDataAccessObject dao = new MemberDataAccessObject();
			
			if(action.equals("/listMembers.do")) {
				
				nextPage = "/test02/listMembers.jsp";
				List<MemberValueObject> list = dao.listMembers();
				request.setAttribute("list", list);
				
			}else if (action.equals("/memberForm.do")) { /*action변수값이 /memberForm.do이면 회원가입 입력창(View)화면으로 이동하라는 요청임을 알 수 있음*/ 
				
				nextPage= "/test02/memberForm.jsp";
						
			}else if (action.equals("/addMember.do")) { //action변수값이 /addmember.do이면 요청된 회원정보를 DB의 테이블에 insert하라는 요청 
				
			}
		
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}


