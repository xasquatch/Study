package Chapter7;

class BelievableUserInfo {
	private String name = "ȫ�浿";
	private int account = 10000;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			System.out.println("��������  name �Ҵ�õ����� : " + name);
		}
	}

	public int getAccount() {
		return this.account;
	}

	public void setAccount(int account) {
		if (account > 0) {
			this.account = account;
		} else {
			System.out.println("�������� account �Ҵ�õ����� : " + account);
		}
	}
}

public class BelievableTest {
	public static void main(String[] args) {
		BelievableUserInfo info = new BelievableUserInfo();
		
		System.out.printf("����� ���� : %s, %d%n",info.getName(),info.getAccount());
		
		
		info.setName(null);
		info.setAccount(-10000);
		System.out.printf("����� ���� : %s, %d%n",info.getName(),info.getAccount());
	}

}


