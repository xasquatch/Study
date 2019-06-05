package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.ReplyDAO;
import com.willtoto.dto.MemberDTO;

public class CommandReply implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("user_member");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String reply_write = request.getParameter("reply_write");
		try{
			PrintWriter out = response.getWriter(); 
			ReplyDAO dao = new ReplyDAO();
			int check = dao.write(num, dto, reply_write);
			if(check == 1){
				out.println("<script>"); 
				out.println("alert('댓글 작성완료');"); 
				out.println("location.href='view.do?num="+num+"';"); 
	            out.println("</script>"); 
	            out.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
