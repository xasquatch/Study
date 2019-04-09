package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec02.ex02.MemberDAO;

//memberForm.html페이지에서 가입할 회원내용을 입력하고
//입력한 내용들을 request객체영역에 저장 후
//MemberrServlt2서블릿을 요청시 request영역을 전달하게 된다.
//입력한 회원내용을 DB에 추가해주세요 하는 요청이 들어옴
//command값을 먼저 받아와 addMember이면 값이 전송된 회원정보를 받습니다.
//회원 정보를 MemberVO객체에 설정한 후 MemberDAO의 메소드로 전달해 SQL문을 이용하여 테이블에 추가합니다.
@WebServlet("/Member3")
public class Memberservlet2 extends HttpServlet {

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
		// 클라이언트의 웹브라우저로 응답하기 위한 출력스트림 객체 생성
		PrintWriter out = response.getWriter();

		// 클라이언트의 요청값 전달받기
		// 클라이언트가 어떤 요청을 했는지 받아옵니다. 그 값은 addMember입니다.
		String command = request.getParameter("command");

		// 회원가입 창에서 전송된 command가 addMember이면 전송된 값들을 모두 받아옵니다.
		if (command != null || command.equals("addMember")) {
			// 흐름 :
			// 회원가입창에서 전송된 값들을 얻어와 MemberVO객체에 저장한 후
			// SQL문을 이용해 DB에 insert함.
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");

			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			
			// SQL문을 이용해 DB에 insert함.			
			dao.addMember(vo);
			
		}

	}

}
