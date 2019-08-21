package com.willtoto.command;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.BoardDAO;
import com.willtoto.dao.ReplyDAO;
import com.willtoto.dto.BoardDTO;
import com.willtoto.dto.ReplyDTO;

public class CommandView implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try{
		PrintWriter out = response.getWriter();
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.view(num);
		
		
		ReplyDAO dao2 = new ReplyDAO();
		ArrayList<ReplyDTO> dto2 = dao2.repleView(num);
		
		if(dto == null){
			out.println("<script>");
			out.println("alert('글이 삭제되었거나 존재하지 않습니다.');");
			out.println("location.href='board.do'"); 
			out.println("</script>");
			out.close();
		}else{
			request.setAttribute("view", dto);
			request.setAttribute("reply_view", dto2);
			request.setAttribute("reply_size", dto2.size());
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
