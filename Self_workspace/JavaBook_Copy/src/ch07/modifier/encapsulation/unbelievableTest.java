package ch07.modifier.encapsulation;

class UnbeiievableUserInfo{
	private String name ="ȫ�浿";
	private int account =10000;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	
	
	
}

public class unbelievableTest {
	public static void main(String[] args) {
		UnbeiievableUserInfo t1 = new UnbeiievableUserInfo();
		System.out.printf("���������:%s,%d%n",t1.getName(),t1.getAccount());
		
		t1.setName("lim");
		t1.setAccount(-1111111);
		System.out.printf("���������:%s,%d%n",t1.getName(),t1.getAccount());
		System.out.println(t1.getClass());
	}
}
