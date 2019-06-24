package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUp implements Icommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String pwd = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String callnum = request.getParameter("CallNumber");
        String addr1 = request.getParameter("myaddr1");
        String addr2 = request.getParameter("myaddr2");
        String addr3 = request.getParameter("myaddr3");
        String addr4 = request.getParameter("myaddr4");
        
        if (!pwd.equals(pwd2)) {
    		request.setAttribute("message_header", "오류");
        	request.setAttribute("message_body", "입력하신 비밀번호를 다시 확인해 주세요");
        	
        }else{
        	try {
        		int result = DAO.getInstanceDAO().signUp(id, pwd, name, email, callnum, addr1, addr2, addr3, addr4);
        		
        		if (result == 1) {
        			request.setAttribute("message_header", "회원가입 완료");
        			request.setAttribute("message_body", "성공적으로 회원가입이 완료되었습니다!");
				}
        	} catch (Exception e) {
        		request.setAttribute("message_header", "오류");
        		request.setAttribute("message_body", "수정에 실패하였습니다 다음 사항을 확인해주세요. ID중복, 연락처 중복");
        	}
        }
	}

}
