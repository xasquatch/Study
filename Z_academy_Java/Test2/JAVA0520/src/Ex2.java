
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * static 키워드
		 * - 멤버변수 또는 메서드의 앞에 붙여서 사용
		 * - 인스턴스가 생성되기 전 클래스가 메모리에 로딩될 때(프로그램 시작 시)
		 *   static 키워드가 붙은 변수 및 메서드도 함께 로딩됨
		 *   (인스턴스 변수는 인스턴스가 생성되어야만 메모리에 생성됨)
		 *   (인스턴스 생성과 관계 없으므로 클래스명만으로 변수 또는 메서드에 접근 가능)
		 * - 멤버변수에 static 이 붙으면 정적 변수 또는 static 변수 또는 클래스 변수라고 하고,
		 *   멤버메서드에 static 이 붙으면 정적 메서드 또는 static 메서드라고 한다.
		 * 
		 * < static 멤버 접근 기본 문법 >
		 * 클래스명.멤버변수명 또는 클래스명.메서드명()
		 * 
		 * < static 멤버변수 특징 >
		 * 1. 인스턴스 생성 없이 클래스명만으로 변수 접근 가능
		 * 2. 모든 인스턴스에서 하나의 값(메모리 공간)을 공유
		 */
		
		// StaticMemberVariable 클래스의 static 변수 a 에 접근
		StaticMemberVariable.a = 99;
		System.out.println("StaticMemberVariable.a : " + StaticMemberVariable.a);
//		System.out.println("StaticMemberVariable.b : " + StaticMemberVariable.b);
		
		// StaticmemberVariable 인스턴스 생성 및 a = 10, b = 20 으로 초기화 후 출력
		StaticMemberVariable smv = new StaticMemberVariable();
		// 인스턴스변수 a, b 에 접근하려면 반드시 인스턴스 생성 후에 접근해야한다!
		smv.a = 10;
		smv.b = 20;
		System.out.println("smv.a : " + smv.a + ", smv.b : " + smv.b);
		
		System.out.println("------------------------");
		System.out.println("StaticMemberVariable.a : " + StaticMemberVariable.a);
		StaticMemberVariable smv2 = new StaticMemberVariable();
		System.out.println("smv2.a : " + smv2.a + ", smv2.b : " + smv2.b);
		
	}

}

class StaticMemberVariable {
	static int a; // 클래스 멤버 변수(정적, static 변수)
	int b; // 인스턴스 멤버 변수
}






















