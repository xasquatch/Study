
public class Ex3 {

	public static void main(String[] args) {
		/*
		 * < static 메서드 기본 문법 >
		 * [접근제어자] static 리턴타입 메서드명([매개변수...]) {}
		 *
		 * < static 메서드 정의 시 주의사항 >
		 * 1. static 메서드 내에서는 인스턴스 변수 사용 불가
		 * 2. static 메서드 내에서는 레퍼런스 this 사용 불가
		 * 3. static 메서드는 오버라이딩 불가! (차후에 상속 단원에서 배울 내용)
		 */
		
		// 정적(static) 메서드는 인스턴스 생성없이 클래스명만으로 바로 호출 가능
		StaticMethod.staticMethod();
		
		// 일반(not-static) 메서드는 인스턴스 생성 필수!
//		StaticMethod.normalMethod(); // 오류 발생! 클래스명만으로 호출 불가
		StaticMethod sm = new StaticMethod();
		sm.normalMethod();
		sm.staticMethod(); // static 메서드도 호출은 가능하지만 권장하는 문법은 아니다!
		
		System.out.println("------------------------");
		
		// static 변수 a 에 접근하는 getA(), setA() 메서드가 일반 메서드일 경우
		// 반드시 인스턴스 생성 후에 메서드를 호출해야하지만
		sm.setA(10);
		System.out.println(sm.getA());
		
		// static 메서드로 정의할 경우 static 변수 a에 접근하는 Getter/Setter 도
		// 클래스명만으로 인스턴스 생성없이 접근 가능하다!
		StaticMethod.setA(10);
		System.out.println(StaticMethod.getA());
		
	}
	
}

class StaticMethod {
	private static int a;
	private int b;
	
	public static void staticMethod() {
		System.out.println("static 메서드!");
		
		System.out.println("a : " + a);
		
		// static 메서드 내에서 인스턴스 변수 접근 불가(static 변수에만 접근할 수 있다)
		// => 인스턴스 생성 전이므로 인스턴스 변수 b 는 메모리에 로딩되어 있지 않다!
		//    즉, static 메서드 내에서 인스턴스 변수에 접근 가능한 방법은 없다!
//		System.out.println("b : " + b);
	}
	
	public void normalMethod() {
		System.out.println("일반 메서드!");
	}
	
	public static int getA() {
		return a;
	}

	public static void setA(int a) {
		// static 메서드 내에서는 레퍼런스 this 사용 불가
		// => 인스턴스 생성 전이므로 자신의 인스턴스 주소를 담는 레퍼런스 this 존재하지 않는다!
//		this.a = a;
		StaticMethod.a = a; // 대신 클래스명을 사용하여 접근할 수 있다!
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}











