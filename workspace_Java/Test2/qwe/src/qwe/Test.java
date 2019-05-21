import java.util.Date;

// 스마트웹 하이브리드앱 자바 개발자 양성 - 이름(생년월일)
public class Test {

	public static void main(String[] args) {
		Account acc = new Account();
		
		acc.setAccountNo("111-1111-111");
		acc.setOwnerName("홍길동");
		acc.setBalance(100000);
		
		Date d = new Date(2019, 05, 15);
		acc.setCreateDate(d);
		
		// Getter 메서드를 호출하여 값 리턴받아 사용
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance());
		System.out.println("계좌개설일 : " + d.getYear() + "/" + d.getMonth() + "/" + d.getDate());
		
	}

}

// Account 클래스 정의
// 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(ownerName, 문자열)
// 현재잔고(balance, 정수), 계좌개설일(createDate, 날짜)
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	// 입금(deposit())
	public void deposit(int amount) {
		balance += amount; // 입금금액 누적
		System.out.println("입금된 금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	// 출금(withdraw())
	public int withdraw(int amount) {
		if(amount > balance) { // 출금 불가능한 상황
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
	
}

















