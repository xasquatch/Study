package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//주제:
		//전송(요청)되는 데이터가 많은 경우에는 getParameterNames()메소드를 이용해
		//input태그의 name속성값만 따로 구할 수 있음
		
		//전송되어 오는 name속성의 값들만 Enumeration객체에 저장한 후 Enumeration객체 자체를 리턴받음
		Enumeration enu = request.getParameterNames();
		
		//Enumeration반복기 객체 내부에 name속성이름들이 존재하는 동안 반복
		while(enu.hasMoreElements()){
			//각 name을 하나씩 가져와 
			String name = (String) enu.nextElement();
			
			//대응해서 전송되어 온 값을 배열로 받아
			String[] values = request.getParameterValues(name);

			//반복해서 출력
			for(int i = 0 ; i<values.length ; i++) {
				System.out.println("name : "+name+"  value :"+values[i]);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
