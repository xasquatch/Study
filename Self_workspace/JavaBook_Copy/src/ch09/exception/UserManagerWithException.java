package ch09.exception;

import java.util.Scanner;

class LoginFailException extends RuntimeException {

	enum ErrorCode {
		INVALID_ID, INVALID_PASS;
	}

	private ErrorCode errorCode;

	public LoginFailException(ErrorCode errorCode, String data) {
		super(data);
		this.errorCode = errorCode;
	}

	@Override
	public String getLocalizedMessage() {
		String msg = this.getMessage();
		switch (errorCode) {
		case INVALID_ID:
			msg += " 아이디 확인하세요";
			break;
		case INVALID_PASS:
			msg += " 비번 확인하세요";
			break;
		}
		return msg;
	}

}

public class UserManagerWithException {
	
	public boolean login(String id, String pass) {
		if (!id.equals("hong")) {
			throw new LoginFailException(LoginFailException.ErrorCode.INVALID_ID, id);
		}else if (!pass.equals("1234")) {
			throw new LoginFailException(LoginFailException.ErrorCode.INVALID_PASS, pass);
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		UserManagerWithException usermanager = new UserManagerWithException();
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String pass = sc.nextLine();
		try {
			boolean result = usermanager.login(id, pass);
			System.out.println("로그인 성공여부 "+result);
		} catch (LoginFailException e) {
			System.out.println("예외처리: "+e.getLocalizedMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}