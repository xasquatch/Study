package Chapter7;

class BelievableUserInfo {
	private String name = "홍길동";
	private int account = 10000;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			System.out.println("부적절한  name 할당시도무시 : " + name);
		}
	}

	public int getAccount() {
		return this.account;
	}

	public void setAccount(int account) {
		if (account > 0) {
			this.account = account;
		} else {
			System.out.println("부적절한 account 할당시도무시 : " + account);
		}
	}
}

public class BelievableTest {
	public static void main(String[] args) {
		BelievableUserInfo info = new BelievableUserInfo();
		
		System.out.printf("사용자 정보 : %s, %d%n",info.getName(),info.getAccount());
		
		
		info.setName(null);
		info.setAccount(-10000);
		System.out.printf("사용자 정보 : %s, %d%n",info.getName(),info.getAccount());
	}

}


