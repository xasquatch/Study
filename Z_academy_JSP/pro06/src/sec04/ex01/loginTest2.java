package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;

@WebServlet("/loginTest2")
public class loginTest2 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//login.html에서 아이디와 비밀번호를 입력받고
		//loginServlet2를 요청했을 때 전달되는 요청값 인코딩 처리(한글처리)
		req.setCharacterEncoding("utf-8");
		//login.html에서 입력한 아이디와 비밀번호를 각각 변수에 저장
		resp.setContentType("text/html;charset = utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		//위 두 요청값을 이클립스의 console창에 각각 출력

		
			if ("admin".equals(id)) {
		//조건 : 만약 id를 입력했을 경우
			//조건 : 입력한 id가 admin이면 관리자 화면을 보여주기 위해 "관리자로 로그인 하셨습니다"라고 메시지 웹브라우저로 응답
				//한줄 바꾸기
				//[회원정보 수정하기] 버튼만들기
				//[회원정보 삭제하기] 버튼만들기
				out.print("<html>");
				out.print("<body>");
				out.print("<font size='15'>관리자로 로그인 하셨습니다</font>.<br>");
				out.print("<input type='button' value='회원정보 수정하기'>");
				out.print("<input type='button' value='회원정보 삭제하기'>");
				out.print("</body>");
				out.print("</html>");
			//조건 : admin으로 입력하지 않았을 경우 
				//id변수 님 로그인 하셨습니다 라고 웹브라우저로 응답
		}else if(id != null &&(id.length() != 0) && "admin".equals(id) == false) {
			out.print("<html>");
			out.print("<body>");
			out.print(id + "님 로그인하셨습니다");
			out.print("</body>");
			out.print("</html>");
		}else{
			out.print("<html>");
			out.print("<body>");
			out.print("id와 비밀번호를 입력하세요");
			out.print("<BR>");
			out.print("<a href='localhost:8090/pro06/test01/login.html'>로그인창으로 돌아가기</a>");
			out.print("</body>");
			out.print("</html>");			
		}
			//조건 : id를 입력하지 않았을 경우
				//id와 비밀번호를 입력하세요라고 웹브라우저로 응답
				//<a>로그인창으로 이동 링크 걸어주기
		
	}

}
