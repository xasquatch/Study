package ch06.login;

public class LoginSystem {

	public LoginResult doLogin(String id, String pass) {
		LoginResult re = new LoginResult();
		if(id.equals("admin") && pass.equals("1234")) {
			re.result = true;
			System.out.println("�ݰ�");
		}else if(!id.equals("admin")){
			re.message = "���̵� Ȯ���ϼ���";
		}else {
			re.message = "��й�ȣ�� Ȯ���ϼ���";
		}
		return re;
	}
}
