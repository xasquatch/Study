package Chapter9;

public class UserManagerWithException {

	public boolean login(String id, String pass) {
		if(!id.equals("hong")) {
			throw new LoginFailException(LoginFailException.ErrorCode.INVALID_ID,id);
		}else if(!pass.equals("1234")) {
			throw new LoginFailException(LoginFailException.ErrorCode.INVALID_PASS,pass);
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		UserManagerWithException userManager = new UserManagerWithException();
		try {
//			boolean result = userManager.login("hong", "1234");
			boolean result = userManager.login("hong", "12345");
			System.out.printf("로그인 성공여부 %b%n ", result);
		} catch (LoginFailException e) {
			System.out.printf("예외처리 : %s",e.getLocalizedMessage());
		}
		
	}

}
