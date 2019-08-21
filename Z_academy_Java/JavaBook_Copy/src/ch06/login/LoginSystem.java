package ch06.login;

public class LoginSystem {

	public LoginResult doLogin(String id, String pass) {
		LoginResult re = new LoginResult();
		if(id.equals("admin") && pass.equals("1234")) {
			re.result = true;
			System.out.println("반갑");
		}else if(!id.equals("admin")){
			re.message = "아이디를 확인하세요";
		}else {
			re.message = "비밀번호를 확인하세요";
		}
		return re;
	}
}
