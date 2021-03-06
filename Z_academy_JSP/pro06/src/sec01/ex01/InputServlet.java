package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("ID : " + user_id);
		System.out.println("PW : " + user_pw);
		
		/*하나의 name값으로 여러값을 전송하는 경우 getParameterValues()를 이용해 배열 형태로 반환하여 저장*/
		String[] subject = request.getParameterValues("subject");
		
//		subject배열의 사이즈만큼 반복
//		subject String배열의 0번째 인덱스 위치에 있는 값을 꺼내서 String str변수에 저장
//		subject String배열의 1번째 인덱스 위치에 있는 값을 꺼내서 String str변수에 저장
//		subject String배열의 2번째 인덱스 위치에 있는 값을 꺼내서 String str변수에 저장		
		for (String str : subject) {
			System.out.println("과목 : "+str);
		}
		for (int i = 0; i<subject.length;i++) {
			System.out.println("과목 : "+subject[i]);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
