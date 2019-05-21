import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class Test {

	public static void main(String[] args) {

		Account a = new Account();
		System.out.println(a.getAccountNo());
		System.out.println(a.getOwnerName());
		System.out.println(a.getBalance());

		Account a2 = new Account("222-222-222");
		System.out.println(a2.getAccountNo());
		System.out.println(a2.getOwnerName());
		System.out.println(a2.getBalance());

		Account a3 = new Account("222-222-222","세균맨");
		System.out.println(a3.getAccountNo());
		System.out.println(a3.getOwnerName());
		System.out.println(a3.getBalance());

		Account a4 = new Account("222-222-222","세균맨",124124);
		System.out.println(a4.getAccountNo());
		System.out.println(a4.getOwnerName());
		System.out.println(a4.getBalance());
	}

}

class Account {
	private String accountNo;
	private String ownerName;
	private int balance;

	public Account() {
		this("111-1111-111", "호빵맨", 0);
	}

	public Account(String accountNo) {
		this(accountNo, "호빵맨", 0);
	}

	public Account(String accountNo, String ownerName) {
		this("111-1111-111", "호빵맨", 0);
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println("==========");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}