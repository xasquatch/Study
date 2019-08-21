package sec02.ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//컨트롤러 역할을 하는 MemberController서블릿 클래스
//이컨트롤러에서는 HttpServletRequest객체의 getPathInfo()메소드를 이용해서 
//두 단계로 이루어진 클라이언트의 요청 주소를 가져옵니다.
//action변수값에 따라 if문을 분기해서 요청한 작업을 수행합니다.


@WebServlet("/member/*")//웹브라우저로에서 주소를 입력해서 요청시 두단계로 요청이 이루어짐 
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
		
		//이동할 View페이지 주소 저장할 용도의 변수 
		String nextPage = null;
		
		//request객체의 getPathInfo()메소드를 호출해서 반환값으로 클라이언트의 요청 URL를 가져옴
		String action = request.getPathInfo();
	  //System.out.println("action : " + action); // /listMembers.do : 회원정보 검색 요청
	  //System.out.println("action : " + action); // /memberForm.do : 회원가입창으로 이동 시켜줘! 요청!
	 //System.out.println("action : " + action); // /addMember.do : DB에 회원등록해줘~ 요청!
	//System.out.println("action : " + action); // /modeMember.do : DB에 회원 정보 수정해줘~ 요청!			
//action변수의 값에 따라 if문을 분기해서 요청한 작업을 수행하는데..
//만약action변수의 값이 null이거나 /listMembers.do인 경우에 회원검색기능 요청이 들어 왔다라는 것을 알수 있음
		if(action == null || action.equals("/listMembers.do")){// 회원정보 검색 요청
			
			//비즈니스 로직 처리 부분 명령!
			//서블릿을 DB로부터 회원정보를 검색 해줘! 라는 요청을 /listMembers.do라는 매핑주소러 전달 받았기 떄문에..
			//서블릿은 그요청에 응답결과물을 생성하여 응답 해야 하므로...
			//MemberDAO의 listMembers()메소드를 호출하여  요청에 대해 DB로부터 검색한 회원정보들을
			//ArrayList로 반환 받기
			List memberList = membarDAO.listMembers();
			
			//이떄 request내장객체 영역에 검색한 회원정보들(MemberVO객체들을 저장하고 있는 ArrayList)을
			//list라는 속성이름으로 memberList를 바인딩(저장) 합니다.
			request.setAttribute("list", memberList);			
			
			//검색한 회원정보(응답메세지)를 보여줄  View페이지 주소를 저장
			nextPage = "/test03/listMembers.jsp";
			
			
//만약 action변수의 값이  /memberForm.do이면 회원가입입력창 View화면으로 이동하라라는 요청임을 알수 있음
		}else if(action.equals("/memberForm.do")){ //회원가입 입력창으로이동 요청
			
			//회원가입 입력창으로 이동시시키기 위한 주소를 변수에 저장
			nextPage = "/test03/memberForm.jsp"; 
			
//만약 action변수의 값이  /addMember.do이면  요청된 회원정보를 DB의 테이블에 insert 추가하라라는 요청			
		}else if(action.equals("/addMember.do")){//회원정보를  DB에 추가 요청 
			
			/*요청값 얻기*/
			//서블릿은 memberForm.jsp페이지로 부터 입력한 회원정보 얻기
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			
			/*요청값에 응답을 하기 위해..회원정보를 DB에 추가하는 작업 명령*/
			membarDAO.addMember(memberVO);
			
			//DB에 회원등록후 ~ listMembers.jsp로 메세지를 출력하기 위한 용도로 저장 
			request.setAttribute("msg", "addMember");
			
			/*회원정보를 DB에 추가한후 이동할 View페이지 주소 저장*/
			nextPage = "/member/listMembers.do";
		
		//listMembers.jsp페이지에서 수정링크를 클릭했을때..
		//컨트롤러에 회원정보 수정창 요청시  ID로 회원정보를 조회한 후 수정창으로 포워딩함.
		}else if(action.equals("/modMemberForm.do")){
			
			/*클라이언트의 요청값(수정할 회원정보중..ID)*/
			String id = request.getParameter("id");
			
			//회원정보 수정창을 요청하면서 전송된 ID를 이용해 수정 전 회원정보를 검색해 옵니다.
			MemberVO memInfo = membarDAO.findMember(id);
			
			//request내장객체 영역에 바인딩 하여 회원 정보 수정창에 수정하기전의 회원정보를 전달합니다.
			request.setAttribute("memInfo", memInfo);
			
			//회원정보 수정창 페이지로 포워딩 하기위한 URL 저장
			nextPage = "/test03/modMemberForm.jsp";
			
			
		//회원정보 수정 입력 창에서 회원수정 정보를 입력후 수정하기 버튼을 클릭한후..
		// http://localhost:8090/pro17/member/modMember.do로 
		// DB 테이블의 데이터 수정 요청이 들어오면.. 
		}else if(action.equals("/modMember.do")){
			/*요청값 전달받기*/
			//modMemberForm.jsp페이지에서 수정시 입력한  정보를 request영역에서 얻기
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			//MemberVO객체의 변수에 설정
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			/*요청값에 의해 응답을 하기 위한 수정DB작업*/
			membarDAO.modMember(memberVO);
			
			//수정후~ 회원목록창 view(listMembers.jsp)로 수정작업 완료 메세지를 전달하기위해..
			//request내장객체 영역에 수정성공 메세지를 바인딩함.
			request.setAttribute("msg", "수정성공!");
			
			/*수정후 회원목록창 View(listMembers.jsp)로 포워딩하기위한 URL설정*/
			nextPage = "/member/listMembers.do";
		
		//listMembers.jsp에서 삭제링크를 클릭했을때...request영역에 삭제할 ID를 저장하여 
		//요청 해온다.
		}else if(action.equals("/delMember.do")){
			/*요청값 얻기*/
			//삭제할 회원의 ID얻기
			String id = request.getParameter("id");
			
			/*요청값을 이용해 DB에 저장되어 있는 회원 삭제 명령!*/
			membarDAO.delMember(id);
			
			/*삭제후 회원목록화면(listMembers.jsp)로 삭제작업 완료 메세지를 전달하기위해 바인딩*/
			request.setAttribute("msg", "deleted");
			
			/*삭제후 회원목록화면(listMembers.jsp)로 이동할 View주소를 저장 */
			nextPage = "/member/listMembers.do";
	
		}else{ 
			//DB에 있는 모든 회원정보를 검색하여  ListMembers.jsp로 이동할수 있도록
			List memberList = membarDAO.listMembers();
			request.setAttribute("list", memberList);
			nextPage = "/test03/listMembers.jsp";
		}
				
		//디스패치 방식 으로 포워딩!!!!
		//View페이지(listMembers.jsp)로  재요청하여 이동시..
		//request영역 전달 하여 View페이지에서 응답결과데이터들을 출력
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(nextPage);
		//실제 재요청(이동)시 request영역, response영역전달
		dispatcher.forward(request, repsone);
	}	
	
}










