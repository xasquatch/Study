
public class Test {

	public static void main(String[] args) {
		/*
		 * Account(은행계좌) 클래스
		 * - 계좌번호("xxx-xxxx-xxx" => 문자열(String) accountNo)
		 *   예금주명("XXX" => 문자열(String) ownerName)
		 *   현재잔고(xxxxxx => 정수 balance)
		 */
		
		// Account 클래스의 인스턴스 생성(acc)
		// 계좌번호 : 111-1111-111
		// 예금주명 : 홍길동
		// 현재잔고 : 100000원
		Account acc = new Account(); // Account 인스턴스 생성
		acc.accountNo = "111-1111-111"; // 멤버변수에 데이터 저장
		acc.ownerName = "홍길동";
		acc.balance = 100000;
		
		// 멤버변수 값 출력
		System.out.println("계좌번호 : " + acc.accountNo);
		System.out.println("예금주명 : " + acc.ownerName);
		System.out.println("현재잔고 : " + acc.balance + "원");
		
		System.out.println("------------------------");
		
		Account acc2 = new Account(); // Account 인스턴스 생성
		acc2.accountNo = "222-2222-222"; // 멤버변수에 데이터 저장
		acc2.ownerName = "이순신";
		acc2.balance = 100000000;
		
		// 멤버변수 값 출력
		System.out.println("계좌번호 : " + acc2.accountNo);
		System.out.println("예금주명 : " + acc2.ownerName);
		System.out.println("현재잔고 : " + acc2.balance + "원");
		
		
	}

}



















