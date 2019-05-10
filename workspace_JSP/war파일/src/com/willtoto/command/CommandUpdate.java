package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.BoardDAO;
import com.willtoto.dto.BoardDTO;
import com.willtoto.dto.MemberDTO;

public class CommandUpdate implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try{
			PrintWriter out = response.getWriter(); 
			HttpSession session = request.getSession();
			int num = Integer.parseInt(request.getParameter("num"));
			MemberDTO dto = (MemberDTO)session.getAttribute("user_member");
			String id = dto.getId();
			BoardDAO dao = new BoardDAO();
			BoardDTO Bdto = dao.updateView(num, id);
			
			if(Bdto != null){
				request.setAttribute("update_view", Bdto);
			}else{
				out.println("<script>"); 
				out.println("alert('이미 삭제되었거나 본인 글이 아닙니다');"); 
	            out.println("location.href='board.do'"); 
	            out.println("</script>"); 
	            out.close(); 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
