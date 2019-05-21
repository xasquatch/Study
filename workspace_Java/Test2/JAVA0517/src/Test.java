
public class Test {
	public static void main(String[] args) {
		Account acc = new Account();
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance() + "만원");
	}
}

class Account {
	private String accountNo;
	private String ownerName;
	private int balance;

	public Account() { //생략가능 public
		accountNo = "1234-5678";
		ownerName = "바보진현형";
		balance = -1200;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getBalance() {
		return balance;
	}

}