package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {

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
	
		//배열을 저장할 JSONObject객체 생성
		JSONObject totalObject = new JSONObject();
		//HashMap의 구조와 같은 JSONObject객체들을 저장할 JSONArray객체 배열을 생성
		JSONArray membersArray = new JSONArray();
		
		//회원 한명의 정보가 들어갈 JSONObject객체 생성
		JSONObject memberInfo = new JSONObject();
		//회원 한명의 정보를 name/value 쌍으로 저장합니다.
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날쌘돌이");
		//회원 한명의 정보가 저장되어 있는 JSONObject객체를 JSONArray객체 배열에 저장합니다.
		membersArray.add(memberInfo);
		
		//회원 한명의 정보가 들어갈 JSONObject객체 생성
		memberInfo = new JSONObject();
		//회원 한명의 정보를 name/value 쌍으로 저장합니다.
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "28");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		//회원 한명의 정보가 저장되어 있는 JSONObject객체를 JSONArray객체 배열에 저장합니다.
		membersArray.add(memberInfo);
				
		
		membersArray.add(putmember("리팩토링", "18", "연습", "연습9"));
		membersArray.add(putmember("리팩토링", "28", "연4습", "연9습"));
		membersArray.add(putmember("알아도", "38", "연습1", "연3습"));
		membersArray.add(putmember("아는게", "28", "연3습", "연5습"));
		membersArray.add(putmember("아니다", "48", "연4습", "연7습"));
		membersArray.add(putmember("리팩토링", "68", "연8습", "8연습"));
		
		
		//JSONArray객체 배열을 JSONObject객체에 저장하는데
		//name속성은 members,
		//value값은 membersArray
		totalObject.put("members", membersArray);
				
		String jsonInfo = totalObject.toJSONString();
		
		PrintWriter writer = response.getWriter();
		
		writer.print(jsonInfo);
	}

	public JSONObject putmember(String name, String age,String gender,String nickname) {
		//회원 한명의 정보가 들어갈 JSONObject객체 생성
		JSONObject memberInfo = new JSONObject();
		//회원 한명의 정보를 name/value 쌍으로 저장합니다.
		memberInfo.put("name", name);
		memberInfo.put("age", age);
		memberInfo.put("gender", gender);
		memberInfo.put("nickname", nickname);
		//회원 한명의 정보가 저장되어 있는 JSONObject객체를 JSONArray객체 배열에 저장합니다.
		
		return memberInfo;
	}
	
	
}
