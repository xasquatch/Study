package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.IDChecking;
import command.Icommand;
import command.SignUp;

@WebServlet("/*.do")
public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String path = "index.jsp";
		String uri = request.getRequestURI();
    	String conpath = request.getContextPath();
    	String command = uri.substring(conpath.length());
			System.out.println("--------VIEW CONTROLL START-------------");
			System.out.println("* uri : "+uri);
			System.out.println("* conpath : "+conpath);
			System.out.println("* command : "+command);
			System.out.println("--------VIEW CONTROLL END---------------");
    	 
    	if (command.equals("/signup.do")) {
    		Icommand cmd = new SignUp();
    		cmd.excute(request, response);
    		
	    }else if (command.equals("/idchecking.do")) {
			Icommand cmd = new IDChecking();
			cmd.excute(request, response);
			return;
		}
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
    	dispatcher.forward(request, response);
    	
	}
}
