package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.BoardDAO;
import com.willtoto.dto.BoardDTO;
import com.willtoto.dto.MemberDTO;

public class CommandWrite implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try{
		BoardDAO dao = new BoardDAO();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		MemberDTO Mdto = (MemberDTO)session.getAttribute("user_member");
		BoardDTO Bdto = new BoardDTO(); 
		Bdto.setId(Mdto.getId());
		Bdto.setTitle(request.getParameter("title"));
		Bdto.setContent(request.getParameter("content"));
		Bdto.setIp(request.getRemoteAddr());
		int num = dao.max()+1;
		Bdto.setNum(num);
		Bdto.setRe_ref(num);
		int check = dao.write(Bdto);
		
		if(check == 1){
			out.println("<script>");
			out.println("alert('작성 완료');");
			out.println("location.href='board.do'");
			out.println("</script>");
			out.close();
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
