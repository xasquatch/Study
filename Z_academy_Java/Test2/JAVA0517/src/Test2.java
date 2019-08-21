
public class Test2 {

	public static void main(String[] args) {
		// Account 인스턴스 생성
		// Getter 를 호출하여 인스턴스 변수값 출력(Setter 사용하지 않고 바로 출력)
		Account2 acc = new Account2("홍길동", "111-1111-111", 99999);
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance());
		
		System.out.println("-----------------------");
		
		Account2 acc2 = new Account2();
		System.out.println("계좌번호 : " + acc2.getAccountNo());
		System.out.println("예금주명 : " + acc2.getOwnerName());
		System.out.println("현재잔고 : " + acc2.getBalance());
		
		System.out.println("-----------------------");
		
		Account2 acc3 = new Account2("999-9999-999"); // 계좌번호만 전달받는 생성자 호출
		System.out.println("계좌번호 : " + acc3.getAccountNo());
		System.out.println("예금주명 : " + acc3.getOwnerName()); // 기본값 "김아무개"
		System.out.println("현재잔고 : " + acc3.getBalance()); // 기본값 1
		
		System.out.println("-----------------------");
		
		Account2 acc4 = new Account2("666-6666-666", "이순신"); // 계좌번호, 예금주명만 전달
		System.out.println("계좌번호 : " + acc4.getAccountNo());
		System.out.println("예금주명 : " + acc4.getOwnerName());
		System.out.println("현재잔고 : " + acc4.getBalance()); // 기본값 1
	}

}

/*
 * Account2 클래스 정의
 * 계좌번호(accountNo)
 * 예금주명(ownerName)
 * 현재잔고(balance)
 * 
 * => 생성자 Account2() 를 정의하여 계좌번호, 예금주명, 현재잔고를 직접 초기화
 */
class Account2 {
	
	private String accountNo;
	private String ownerName;
	private int balance;
	
	// 기본 생성자, 매개변수 3개짜리 생성자를 오버로딩
	// 계좌번호, 예금주명, 현재잔고 전달받아 초기화하는 생성자 Account2(String, String, int) 정의
//	public Account2(String acc, String own, int bal) {
//		accountNo = acc;
//		ownerName = own;
//		balance = bal;
//	}
	
	public Account2() {
		System.out.println("생성자 Account2() 호출됨!");
	}
	
	public Account2(String accountNo) {
		System.out.println("생성자 Account2(String) 호출됨!");
		this.accountNo = accountNo;
		ownerName = "김아무개";
		balance = 1;
	}

	public Account2(String accountNo, String ownerName) {
		System.out.println("생성자 Account2(String, String) 호출됨!");
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		balance = 1;
	}

	public Account2(String accountNo, String ownerName, int balance) {
		System.out.println("생성자 Account2(String, String, int) 호출됨!");
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
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













