package com.willtoto.front;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.command.Command;
import com.willtoto.command.CommandDelete;
import com.willtoto.command.CommandJoin;
import com.willtoto.command.CommandList;
import com.willtoto.command.CommandLogin;
import com.willtoto.command.CommandMemberModify;
import com.willtoto.command.CommandPointGame1;
import com.willtoto.command.CommandPointGame1ok;
import com.willtoto.command.CommandPointGame2ok;
import com.willtoto.command.CommandPointGame3ok;
import com.willtoto.command.CommandPointGame4ok;
import com.willtoto.command.CommandPointMessage;
import com.willtoto.command.CommandPointMessageSelect;
import com.willtoto.command.CommandPointRank;
import com.willtoto.command.CommandPointTrade;
import com.willtoto.command.CommandPointTradeOkSelect;
import com.willtoto.command.CommandReply;
import com.willtoto.command.CommandReplyDelete;
import com.willtoto.command.CommandReplyUpdate;
import com.willtoto.command.CommandSearch;
import com.willtoto.command.CommandUpdate;
import com.willtoto.command.CommandUpdateOk;
import com.willtoto.command.CommandView;
import com.willtoto.command.CommandWrite;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter(); 
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String com = uri.substring(path.length());
		String view = null;
		Command command;
		int send = 0;
		HttpSession session = request.getSession();
		if(com.equals("/index.do")){ // index 화면
			command = new CommandPointTradeOkSelect();
			command.execute(request, response);
			view = "index.jsp";
			send = 0;
		}
		else if(com.equals("/login.do")){ //로그인 화면
			view = "login.jsp";
			send = 0;
		}else if(com.equals("/login_ok.do")){ //로그인 성공
			  command = new CommandLogin();
		      command.execute(request, response);
		      if (session.getAttribute("user_member") != null) {
		        view = "index.do";
		        send = 0;
		      } else {
		        request.setAttribute("user_member", "NO");
		        view = "login.do";
		        send = 0;
		      }
		}else if (com.equals("/logout.do")) {
		      session.invalidate();
		      view = "index.do";
		      send = 0;
		    }
		else if(com.equals("/join.do")){ //회원가입
			view = "join.jsp";
			send = 0;
		}else if(com.equals("/join_ok.do")){ //회원가입 성공
			command = new CommandJoin();
			command.execute(request, response);
			if(request.getAttribute("join_result").equals(true)){
				request.setAttribute("join_result", "true");
			}
			view = "index.do";
			send = 0;
		}else if(com.equals("/find.do")){ //아이디 비밀번호 찾기
			view = "find.jsp";
			send = 0;
		}else if(com.equals("/member_modify.do")){ //멤버 회원정보
			view = "member_modify.jsp";
			send = 0;
		}else if(com.equals("/member_modify_ok.do")){ //멤버 회원정보 수정 성공
			command = new CommandMemberModify();
			command.execute(request, response);
			out.println("<script>"); 
			out.println("alert('수정되었습니다');"); 
            out.println("location.href='index.do'"); 
            out.println("</script>"); 
            out.close(); 
		}
		else if(com.equals("/search.do")){ //검색
			command = new CommandSearch();
			command.execute(request, response);
			view = "search.jsp";
			send = 0;
		}else if(com.equals("/board.do")){ //게시판
			command = new CommandList();
			command.execute(request, response);
			view = "board.jsp";
			send = 0;
		}else if(com.equals("/view.do")){ //글 보기
			command = new CommandView();
			command.execute(request, response);
			view = "view.jsp";
			send = 0;
		}else if(com.equals("/write.do")){ //글쓰기 화면
			view = "write.jsp";
			send = 0;
		}else if(com.equals("/write_ok.do")){ //글쓰기 성공
			command = new CommandWrite();
			command.execute(request, response);
		}else if(com.equals("/delete.do")){ //글삭제
			command = new CommandDelete();
			command.execute(request, response);
		}else if(com.equals("/update.do")){ //글수정 화면
			int num = Integer.parseInt(request.getParameter("num"));
			command = new CommandUpdate();
			command.execute(request, response);
			view = "update.jsp?num="+num;
			send = 0;
		}else if(com.equals("/update_ok.do")){ //글수정 성공
			command = new CommandUpdateOk();
			command.execute(request, response);
		}else if(com.equals("/reply.do")){ //댓글달기
			command = new CommandReply();
			command.execute(request, response);
		}else if(com.equals("/replyDelete.do")){ //댓글삭제
			command = new CommandReplyDelete();
			command.execute(request, response);
		}else if(com.equals("/replyUpdate.do")){ //댓글삭제
			command = new CommandReplyUpdate();
			command.execute(request, response);
		}else if(com.equals("/point_game1.do")){ //포인트게임
			command = new CommandPointGame1();
			command.execute(request, response);
			view = "point_game1.jsp";
			send = 0;	
		}else if(com.equals("/point_game1_ok.do")){ //포인트게임
			command = new CommandPointGame1ok();
			command.execute(request, response);
			view = "point_game1.do";
			send = 1;
		}else if(com.equals("/point_game2.do")){ //포인트게임
			view = "point_game2.jsp";
			send = 0;	
		}else if(com.equals("/point_game2_ok.do")){ //포인트게임
			command = new CommandPointGame2ok();
			command.execute(request, response);
		}else if(com.equals("/point_game3.do")){ //포인트게임
			view = "point_game3.jsp";
			send = 0;	
		}else if(com.equals("/point_game3_ok.do")){ //포인트게임
			command = new CommandPointGame3ok();
			command.execute(request, response);
		}else if(com.equals("/point_game4.do")){ //포인트게임
			view = "point_game4.jsp";
			send = 0;	
		}else if(com.equals("/point_game4_ok.do")){ //포인트게임
			command = new CommandPointGame4ok();
			command.execute(request, response);
		}else if(com.equals("/point_rank.do")){ //포인트랭킹
			command = new CommandPointRank();
			command.execute(request, response);
			view = "point_rank.jsp";
			send = 0;
		}else if(com.equals("/point_trade.do")){ //포인트교환
			command = new CommandPointMessageSelect();
			command.execute(request, response);
			view = "point_trade.jsp";
			send = 0;
		}else if(com.equals("/point_message.do")){ //포인트 구걸 메시지
			command = new CommandPointMessage();
			command.execute(request, response);
			view = "point_trade.do";
			send = 1;
		}
		else if(com.equals("/pointTrade_ok.do")){ //포인트송금 OK
			command = new CommandPointTrade();
			command.execute(request, response);
			if(request.getAttribute("trade_check") != null){
				request.setAttribute("trade_check", "true");
			}
			
			out.println("<script>"); 
			out.println("alert('송금되었습니다');"); 
            out.println("location.href='point_trade.do'"); 
            out.println("</script>"); 
            out.close(); 

		}
		
		
		if(send == 1){
		response.sendRedirect(view);
		}else if(send == 0){
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		}else{
			
		}
		
	}
}
