//Iot반 고태흥
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

@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {

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
		
		JSONObject totalObject = new JSONObject();//최종 객체
		JSONArray bookArray = new JSONArray();//bookInfo array
		
		bookArray.add(addbook("자바의정석", "남궁성", "30000", "IT", "http://localhost:8090/pro12_1/image/image1.jpg"));
		bookArray.add(addbook("JSP & servlet", "오정현", "32000", "IT", "http://localhost:8090/pro12_1/image/image2.jpg"));
		bookArray.add(addbook("Java 프로그래밍", "조용준", "26500", "IT", "http://localhost:8090/pro12_1/image/image3.jpg"));
		bookArray.add(addbook("자바스크립트 디자인 패턴", "사이먼 팀스", "25000", "IT", "http://localhost:8090/pro12_1/image/image4.jpg"));
		
		totalObject.put("books", bookArray);
		String jsonInfo = totalObject.toJSONString();
		
		PrintWriter writer = response.getWriter();
		writer.print(jsonInfo);
	}
	public JSONObject addbook(String title,String writer,String price,String genre,String image){
		JSONObject bookInfo = new JSONObject();//하나의 정보
			bookInfo.put("title", title);
			bookInfo.put("writer", writer);
			bookInfo.put("price", price);
			bookInfo.put("genre", genre);
			bookInfo.put("image", image);
			
		return bookInfo;
	}
}
