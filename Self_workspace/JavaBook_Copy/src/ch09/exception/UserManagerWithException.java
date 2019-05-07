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
			msg += " ���̵� Ȯ���ϼ���";
			break;
		case INVALID_PASS:
			msg += " ��� Ȯ���ϼ���";
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
			System.out.println("�α��� �������� "+result);
		} catch (LoginFailException e) {
			System.out.println("����ó��: "+e.getLocalizedMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}