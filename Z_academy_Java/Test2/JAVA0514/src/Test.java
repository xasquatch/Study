
public class Test {

	public static void main(String[] args) {
		// Account 인스턴스 생성하여 다음과 같이 초기화 후 출력
		// 계좌번호 : 111-1111-111
		// 예금주명 : 홍길동
		// 현재잔고 : 100000원
		Account acc = new Account();
		acc.accountNo = "111-1111-111";
		acc.ownerName = "홍길동";
		acc.balance = 100000;

		System.out.println("계좌번호 : " + acc.accountNo);
		System.out.println("예금주명 : " + acc.ownerName);
		System.out.println("현재잔고 : " + acc.balance + "원");

		System.out.println("-------------------------");

		// 입금기능 담당 deposit() 메서드를 호출하여 55555원 입금
		acc.deposit(55555);

		// 출금기능 담당 withdraw() 메서드를 호출하여 출금할 금액 100000원 입력
		// => 리턴되는 출금금액을 정수형 변수 myMoney 에 저장 후
		// "출금금액 : XXXXXX원" 출력
		int myMoney = acc.withdraw(1000000);
		System.out.println("출금금액 : " + myMoney + "원");

	}

}

/*
 * 은행계좌 클래스 - Account
 * 
 * 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(ownerName, 문자열), 현재잔고(balance, 정수형)
 * 
 * 메서드 1. 입금기능(deposit()) - 외부로부터 입금금액(amount, 정수형)을 전달받아 현재잔고(balance)에 누적 후
 * 다음과 같이 출력 "입금된 금액 : XXXXX원" "현재잔고 : XXXXX원"
 * 
 * 2. 출금기능(withdraw())
 */
class Account {
	String accountNo;
	String ownerName;
	int balance;

	public int deposit(int amount) {

		balance += amount;
		System.out.println("입금된 금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
		return amount;
	}

	public int withdraw(int myMoney) {
		System.out.println("=======================");
		if (balance >= myMoney) {
			System.out.println("출금완료");
			System.out.println("출금할 금액 : " + myMoney + "원");
			System.out.println("현재잔고 : " + balance + "원");
			return myMoney;
		} else {
			balance -= myMoney;
			System.out.println("출금 불가(잔고가 부족합니다)");
			System.out.println("출금할 금액 : " + myMoney + "원");
			System.out.println("현재잔고 : " + balance + "원");
			return 0;
		}

	}

}
