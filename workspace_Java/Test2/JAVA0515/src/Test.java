import java.util.Date;

// 스마트웹 하이브리드앱 자바 개발자 양성 - 이름(생년월일)
public class Test {

	public static void main(String[] args) {
		Account sbj = new Account();

		sbj.setAccountNo("123-4567-890");
		sbj.setOwnerName("손병준");
		sbj.setBalance(30000);

		Date d = new Date(2019, 05, 13);
		sbj.setCreateDate(d);

		System.out.println("계좌번호 : " + sbj.getAccountNo());
		System.out.println("예금주명 : " + sbj.getOwnerName());
		System.out.println("현재잔고 : " + sbj.getBalance());
		System.out.println("계좌개설일 : " + d.getYear() + "/" + d.getMonth() + "/" + d.getDate());

	}

}

// Account 클래스 정의
// 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(ownerName, 문자열), 현재잔고(balance, 정수), 계좌개설일(createDate)
// Getter/Setter 메서드 정의
class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	private Date createDate;	
	
	
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
	//입금(deposit())
	public void deposit(int amount) {
		balance += amount; // 입금금액 누적
		System.out.println("입금된 금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	// 출금(withdraw())
	public int withdraw(int amount) {
		if(amount > balance) { // 출금 불가능
			System.out.println("출금 불가(잔고가 부족합니다)");
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("현재잔고 : " + balance + "원");
			
			return 0;
		} 
		
		// else 문이 없어도 if문 판별 결과가 false 이면 자동으로 아래쪽 문장이 실행됨
		// if문 판별 결과가 true 일 때 return 문이 있기 때문에 상관없다!
		balance -= amount;
		System.out.println("출금 완료!");
		System.out.println("출금된 금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
		
		return amount;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
