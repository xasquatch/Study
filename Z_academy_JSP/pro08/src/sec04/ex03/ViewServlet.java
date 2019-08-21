package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//두 번째 서블릿은 getAttribute()메소드를 이용해
//첫 번째 서블릿에서 request객체영역에 바인딩한 검색한 회원정보 (ArrayList객체)
@WebServlet("/viewmembers")
public class ViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ArrayList memberList = (ArrayList)request.getAttribute("memberList");
		PrintWriter out = response.getWriter();
		
		out.write("<html><body>");
		out.write("<table border='1'>");
		out.write("<tr bgcolor = '#FF6'>");
		out.write("<th>id</th>");
		out.write("<th>pwd</th>");
		out.write("<th>name</th>");
		out.write("<th>email</th>");
		out.write("<th>joinDate</th>");
		out.write("</tr>");
//		for(int i = 0;i<memberList.size();i++) {
//			MemberVO vo = (MemberVO)memberList.get(i);
//			String id = vo.getId();
//			String pwd = vo.getPwd();
//			String name = vo.getName();
//			String email = vo.getEmail();
//			Date joinDate = vo.getJoinDate();
//			
//
//			out.write("<tr>");
//			out.write("<td>"+id+"</td>");
//			out.write("<td>"+pwd+"</td>");
//			out.write("<td>"+name+"</td>");
//			out.write("<td>"+email+"</td>");
//			out.write("<td>"+joinDate+"</td>");
//			out.write("</tr>");
//
//		};
		for(Object ob : memberList) {
			MemberVO vo = (MemberVO)ob;
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();

			out.write("<tr>");
			out.write("<td>"+id+"</td>");
			out.write("<td>"+pwd+"</td>");
			out.write("<td>"+name+"</td>");
			out.write("<td>"+email+"</td>");
			out.write("<td>"+joinDate+"</td>");			
			out.write("</tr>");
		};
		out.write("</table>");
		out.write("</body></html>");
		
		
	}

}
