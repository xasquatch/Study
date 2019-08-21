
public class Ex4 {

	public static void main(String[] args) {
		// Static 멤버 활용
		// Math 클래스의 변수 및 메서드는 모두 static 으로 선언되어 있다.
		// => 수학적 기능을 제공하는 클래스

		// Math 클래스의 상수(static final, final 은 아직 배우지 않음) PI 값 접근
		System.out.println("PI값 : " + Math.PI);

		// Math 클래스의 다양한 메서드 활용
		System.out.println("10 vs 20 최대값은? " + Math.max(10, 20));
		System.out.println("10 vs 20 최소값은? " + Math.min(10, 20));

		System.out.println("4 의 제곱근은? " + Math.sqrt(4));

		System.out.println("-10 의 절대값은? " + Math.abs(-10));

		System.out.println("------------------------------");

		for (int i = 1; i <= 10; i++) {
			// 0.0xxxxx <= x <= 0.9xxxxx 사이의 난수 발생
//			System.out.println("double 타입 범위 내의 난수 : " + Math.random());

			// 0 <= x <= 9 사이의 난수
//			System.out.println("0 ~ 9 사이의 난수 : " + (int) (Math.random() * 10));
//
//			// 1 <= x <= 10 사이의 난수
//			System.out.println("1 ~ 10 사이의 난수 : " + ((int) (Math.random() * 10) + 1));
			
			System.out.println("1 ~ 45 사이의 난수 : " + ((int) (Math.random() * 45)+1));
		}

	}

}
