
public class Ex2 {

	public static void main(String[] args) {
		// Cash, CheckCard, PassValue 인스턴스 생성
		Cash cash = new Cash();
		System.out.println("Cash 인스턴스의 money 값 : " + cash.money);
		
		CheckCard checkCard = new CheckCard();
		System.out.println("CheckCard 인스턴스의 money 값 : " + checkCard.money);
		
		PassValue pv = new PassValue();
		pv.passByValue(cash.money);
		// Cash 인스턴스의 "기본형" 변수 money 값 전달 => 실제 데이터 복사
		// 즉, cash 인스턴스의 변수 money 값(1000)을 복사한 1000을 전달
		
		pv.passByReference(checkCard);
		// CheckCard 인스턴스의 "참조형" 변수 checkCard 값 전달 => 주소값 복사
		// 즉, CheckCard 인스턴스의 주소값을 복사하여 전달(인스턴스 위치를 알려줌)
		
		System.out.println("----------------------------");
		System.out.println("Cash 인스턴스의 money 값 : " + cash.money);
		System.out.println("CheckCard 인스턴스의 money 값 : " + checkCard.money);
	}

}

class Cash {
	int money = 1000;
}

class CheckCard {
	int money = 1000;
}

class PassValue {
	
	// 메서드 정의
	// 1. passByValue() 메서드 : 매개변수로 int타입 변수 money 선언, 리턴값 없음
	public void passByValue(int money) { // 외부로부터 기본형 데이터 1000 이 전달되어 money 에 저장
		// 변수 money 의 값에서 500을 차감
		money -= 500;
	}
	
	// 2. passByReference() 메서드 : 매개변수로 CheckCard 클래스 타입 변수 cc 선언, 리턴값 없음
	public void passByReference(CheckCard cc) { // 참조형 데이터(주소값) 전달되어 cc 에 저장
		// CheckCard 타입 인스턴스 cc 의 인스턴스변수 money 값에서 500을 차감
		cc.money -= 500;
	}
	
}






















