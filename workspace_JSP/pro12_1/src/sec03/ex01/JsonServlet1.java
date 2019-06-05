package sec03.ex01;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {doHandle(request, response);}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {doHandle(request, response);}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//json5.jsp페이지에서 Ajax통신으로 전달된 JSON문자열을 getParameter()메소드를 이용해 가져옴
		String jsonInfo = request.getParameter("jsonInfo");
		try {
			//참고 : JSONParser클래스는 JSON 문자열을 파싱해서
			//		JSONObject객체로 변환하는 기능을 제공
			
			//JSON 문자열을 파싱해서 JSONObject객체로 변환할 객체 생성
			JSONParser jsonParser = new JSONParser();
			
			//parse()메소드를 호출할 때 JSON형태의 문자열이 들어가 있는 변수 jsonInfo를 인자로 전달
			//하면 JSON형태의 문자열을 파싱해서 JSONObject객체로 변환한다.
			//참고 : JSONObject 객체 내부를 살펴보면 HashMap의 구조로 각인덱스 위치에 key:value를 쌍으로 지정한다.
			JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonInfo);
			
				System.out.println(jsonObject.get("name"));
				System.out.println(jsonObject.get("age"));
				System.out.println(jsonObject.get("gender"));
				System.out.println(jsonObject.get("nickname"));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
