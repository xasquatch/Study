package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.ReplyDAO;
import com.willtoto.dto.MemberDTO;

public class CommandReplyUpdate implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		int replyNum = Integer.parseInt(request.getParameter("replyNum"));
		String update_reply_write = request.getParameter("update_reply_write");
		try{
			PrintWriter out = response.getWriter(); 
			HttpSession session = request.getSession();
			MemberDTO dto = (MemberDTO)session.getAttribute("user_member");
			ReplyDAO dao = new ReplyDAO();
			
			int check = dao.update(num, replyNum, update_reply_write, dto);
			if(check == 1){
				out.println("<script>"); 
				out.println("alert('수정되었습니다');"); 
	            out.println("location.href='view.do?num="+num+"';"); 
	            out.println("</script>"); 
	            out.close(); 
			}else{
				out.println("<script>"); 
				out.println("alert('이미 삭제되었거나 본인 글이 아닙니다');"); 
	            out.println("location.href='view.do?num="+num+"';"); 
	            out.println("</script>"); 
	            out.close(); 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
