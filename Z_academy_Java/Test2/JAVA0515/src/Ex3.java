
public class Ex3 {

	public static void main(String[] args) {
		// NormalClass 인스턴스 생성
		NormalClass nc = new NormalClass();
		System.out.println(nc.abs(-5)); // -5 전달 시 절대값 5 출력
		
//		System.out.println(nc.abs(-5.1234)); // 매개변수가 double 형이므로 호출 불가! 오류 발생
		System.out.println(nc.doubleAbs(-5.1234)); // 별도의 메서드 호출 필요
		
//		System.out.println(nc.abs(-5L)); // long 타입은 전달 불가!
		System.out.println(nc.longAbs(-5L));
		// 일반적인 메서드는 매개변수 타입이 다를 경우 처리가 불가능하므로
		// 새로운 메서드를 별도의 이름으로 정의하여 처리하기 때문에
		// 메서드 이름이 달라서 헷갈리며, 중복된 코드가 발생한다!
		
		/*
		 * 메서드 오버로딩(Method Overloading) = 메서드 다중정의
		 * - 이름이 같은 메서드를 여러개 정의하는 것
		 * - 규칙1. 메서드명이 동일해야한다.
		 *   규칙2. 매개변수의 타입 또는 갯수가 달라야한다.
		 */
		OverloadingClass oc = new OverloadingClass();
		System.out.println(oc.abs(-10)); // int abs(int num) 호출됨
		System.out.println(oc.abs(-3.14)); // double abs(double num) 호출됨
		System.out.println(oc.abs(-5L)); // long abs(long num) 호출됨
		
		System.out.println("----------------");
		
		// 오버로딩 메서드가 적용된 실제 예 : System.out.println() 메서드
		System.out.println(-10);
		System.out.println(-3.14);
		System.out.println(-5L);
		System.out.println("문자열");
		System.out.println('A');
		System.out.println(true);
	}

}

class OverloadingClass {
	// 메서드 매개변수의 타입이 다른 메서드 오버로딩
	
	public int abs(int num) { // 정수값을 전달받아 절대값을 리턴하는 메서드
		if(num < 0) {
			num = -num;
		}
		
		return num;
	}
	
	// abs() 메서드 오버로딩 - int형 대신 long형 데이터를 전달받아 절대값 리턴
	public long abs(long num) { // long타입 값을 전달받아 절대값을 리턴하는 메서드
		if(num < 0) {
			num = -num;
		}
		
		return num;
	}
	
	// abs() 메서드 오버로딩 - int형 대신 double형 데이터를 전달받아 절대값 리턴
	public double abs(double num) { // double타입 값을 전달받아 절대값을 리턴하는 메서드
		if(num < 0) {
			num = -num;
		}
		
		return num;
	}
	
}

class NormalClass {
	
	public int abs(int num) { // 정수값을 전달받아 절대값을 리턴하는 메서드
		if(num < 0) { // 음수 판별
			num = -num; // 양수로 변환
		}
		
		return num;
	}
	
	public double doubleAbs(double num) { // 실수값을 전달받아 절대값을 리턴하는 메서드
		if(num < 0) { // 음수 판별
			num = -num; // 양수로 변환
		}
		
		return num;
	}
	
	public long longAbs(long num) { // long 타입값을 전달받아 절대값을 리턴하는 메서드
		if(num < 0) { // 음수 판별
			num = -num; // 양수로 변환
		}
		
		return num;
	}
	
}



















