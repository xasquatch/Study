package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") //서블릿을 요청할 매핑 이름이 login
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init 메소드 호출됨");
		
	}

	public void destroy() {
		System.out.println("destroy 메소드 호출됨");
		
	}
	
	//웹브라우저에서 전송한 정보를 톰캣이 HttpServletRequest객체를 생성한 후 doGet()메소드의 인자로 넘겨 줌.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//전송된 데이터를 UTF-8로 인코딩합니다.(한글깨짐방지처리)
		request.setCharacterEncoding("UTF-8");
		
		//클라이언트가 입력한 id요청값을 request객체 메모리 영역에서 꺼내서 변수에 저장
		String user_id = request.getParameter("user_id");
		//클라이언트가 입력한 비밀번호 요청값을 request객체 메모리 영역에서 꺼내서 변수에 저장
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("dd");
	}

}
