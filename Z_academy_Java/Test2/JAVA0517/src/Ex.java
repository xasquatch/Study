
public class Ex {

	public static void main(String[] args) {
		/*
		 * 생성자(Contructor)
		 * - 인스턴스가 생성될 때 제일 먼저 호출되는 메서드의 일종
		 *   (인스턴스 생성 시 new 키워드 뒤의 '클래스명()' 부분이 생성자를 호출하는 코드) 
		 * - 인스턴스 생성 시 인스턴스 변수의 초기화 역할 수행
		 *   (인스턴스 생성 시 초기값으로 가져야 할 값을 지정하는 용도)
		 * - 사용자가 생성자를 정의하지 않으면, 컴파일러에 의해 기본(Default) 생성자가 자동으로 정의됨
		 * - 메서드와 형태가 거의 유사하나 다음과 같은 차이점(규칙)이 있다.
		 *   1. 리턴타입이 없고
		 *   2. 생성자명 = 클래스명
		 *   
		 * < 기본 문법 >
		 * [접근제어자] 클래스명([매개변수...]) {
		 * 		// 인스턴스 변수의 초기화 작업 등...
		 * }
		 * 
		 * < 기본 생성자 형태 >
		 * [클래스의접근제어자] 클래스명() {}
		 * => 매개변수가 없고, 수행되는 코드가 아무것도 없는 빈 생성자
		 */
		
		// Person 인스턴스 생성 및 초기화하여 사용
		Person p = new Person();
		// => new Person(); 코드 중 Person() 부분이 생성자를 호출하는 코드
		//    단, Person 클래스에 생성자를 정의하지 않았으므로, 기본 생성자가 자동으로 생성됨
		
//		p.setName("이순신");
//		p.setAge(20);
//		p.setJumin("901010-1234567");
		
		System.out.println("이름 : " + p.getName());
		System.out.println("나이 : " + p.getAge());
		System.out.println("주민번호 : " + p.getJumin());
	}

}

class Person {
	// 이름(name, 문자열), 나이(age, 정수), 주민번호(jumin, 문자열)
	private String name;
	private int age;
	private String jumin;
	
	// 직접 정의한 Person() 생성자
//	public Person() {
//		System.out.println("생성자 Person() 호출됨!");
//		name = "홍길동";
//		age = 20;
//		jumin = "901010-1234567";
//	}
	
	// 컴파일러가 자동으로 생성해주는 기본 생성자 Person() 의 형태
	public Person() {}
	
	// Getter/Setter 정의
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	
}



























