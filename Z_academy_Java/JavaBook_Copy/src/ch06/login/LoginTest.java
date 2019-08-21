package ch06.login;

public class LoginTest {

	public static void main(String[] args) {
		LoginSystem lo = new LoginSystem();
		LoginResult result = lo.doLogin("hong","1234");
		result.printResult();
		
		result = lo.doLogin("admin", "12345");
		result.printResult();
		
		result = lo.doLogin("admin", "1234");
		result.printResult();
	}
}
