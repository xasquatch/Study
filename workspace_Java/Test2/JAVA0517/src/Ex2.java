
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 매개변수가 있는 생성자 = 파라미터 생성자
		 * - 생성자 호출 시 매개변수를 전달하여 초기화할 값을 지정할 수 있다.
		 * - 파라미터 생성자를 정의할 경우 기본 생성자가 컴파일러에 의해 자동으로 생성되지 않음
		 *   => 따라서, 기본 생성자를 호출해야 할 경우 반드시 직접 정의해야한다.
		 * - 생성자도 메서드의 일종이므로 오버로딩 규칙이 적용된다. => 생성자 오버로딩
		 */
		
		// 매개변수 String, int, String 을 전달받는 생성자 Person2() 호출하여 값 전달 초기화
		Person2 p = new Person2("홍길동", 20, "901010-1234567");
		
		System.out.println("이름 : " + p.getName());
		System.out.println("나이 : " + p.getAge());
		System.out.println("주민번호 : " + p.getJumin());
		
		System.out.println("--------------------");
		
		// 매개변수가 있는 생성자를 별도로 정의할 경우
		// 컴파일러는 더 이상 기본 생성자를 자동으로 생성해주지 않는다!
		// 따라서, 기본 생성자를 호출하는 코드가 있을 경우 컴파일에러 발생한다!
		Person2 p2 = new Person2(); // 기본 생성자를 호출하는 코드
		
	}

}

class Person2 {
	// 이름(name, 문자열), 나이(age, 정수), 주민번호(jumin, 문자열)
	private String name;
	private int age;
	private String jumin;
	
	
	// 매개변수를 전달받아 인스턴스 변수를 초기화하는 생성자 Person2() 정의
	// => 이 때, 기본 생성자를 별도로 정의하지 않으면 컴파일러에 의해 자동 생성되지 않는다!
//	public Person2(String newName, int newAge, String newJumin) {
//		System.out.println("생성자 Person(String, int, String) 호출됨!");
//		name = newName;
//		age = newAge;
//		jumin = newJumin;
//	}

	// 불필요하더라도 다른 생성자 정의 시 기본 생성자도 반드시 정의하도록 하자!
	public Person2() {} // 기본 생성자 => 자동으로 생성되지 않음!
	
	// 생성자 자동 생성 단축키 : Alt + Shift + S -> O
	public Person2(String name, int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	
	
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





























