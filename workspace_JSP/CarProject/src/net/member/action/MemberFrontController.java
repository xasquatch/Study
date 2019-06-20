package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		System.out.println("do POST START");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		System.out.println("do doPOST");
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do Process");

		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		String com = uri.substring(path.length());
		ActionForward forward = null;
		Action action = null;

		if (com.equals("/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./CarMain.jsp?center=member/join.jsp");

		} else if (com.equals("/MemberJoinAction.me")) {
			action = new MemberJoinAction();
			
			try {
				forward = action.excute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}

		
		
		
		
		
		if (forward != null) {

			if (forward.isRedirect()) {

				response.sendRedirect(forward.getPath());

			} else {

				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);

			}
		}

	}

}
