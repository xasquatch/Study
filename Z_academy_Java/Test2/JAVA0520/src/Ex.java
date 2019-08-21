
public class Ex {

	public static void main(String[] args) {
		Person p = new Person(); // Person 인스턴스를 생성하면서 기본 생성자 Person() 호출
		System.out.println("이름 : " + p.getName());
		System.out.println("나이 : " + p.getAge());

		Person p2 = new Person("홍길동", 20);
		System.out.println("이름 : " + p2.getName());
		System.out.println("나이 : " + p2.getAge());

		Person p3 = new Person("홍길동");
		System.out.println("이름 : " + p3.getName());
		System.out.println("나이 : " + p3.getAge());
		Person p4 = new Person(17);
		System.out.println("이름 : " + p4.getName());
		System.out.println("나이 : " + p4.getAge());
	}

}

class Person {
	// 인스턴스변수 : name(문자열), age(정수) => private 선언
	private String name;
	private int age;

	// 기본 생성자 정의 => 이름(김아무개), 나이(1) 로 초기화
	public Person() {
		this("호로록",12);
//		name = "김아무개";
//		age = 1;
		System.out.println("생성자 Person() 호출됨!");
	}

	// 이름 전달받아 초기화하는 생성자 Person(String) 정의
	public Person(String name) {
		this(name,1);
//		this.name = name;
//		age = 1;
		System.out.println("생성자 Person(String) 호출됨!");
	}

	// 나이 전달받아 초기화하는 생성자 Person(int) 정의
	public Person(int age) {
		this("길동이",age);
//		name = "길동이";
//		this.age = age;
		System.out.println("생성자 Person(int) 호출됨!");
	}

	// 이름, 나이를 전달받아 인스턴스 변수를 초기화하는 생성자 Person(String, int) 정의
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("생성자 Person(String, int) 호출됨!");
	}

	// Getter, Setter 정의
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

}
