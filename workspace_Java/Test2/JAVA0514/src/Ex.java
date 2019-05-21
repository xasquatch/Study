
public class Ex {

	public static void main(String[] args) {
		// Animal 클래스 인스턴스 생성
		// 이름 : 멍멍이, 나이 : 3
		Animal ani = new Animal();
		ani.name = "멍멍이";
		ani.age = 3;
		
		System.out.println("이름 : " + ani.name + ", 나이 : " + ani.age);
		
		// Animal 클래스의 cry() 메서드 호출
		ani.cry();
		ani.cry();
		
		// Animal 클래스의 eat() 메서드 호출
		ani.eat("껌");
		
		System.out.println("--------------------------");
		
		Animal ani2 = new Animal();
		System.out.println("이름 : " + ani2.name + ", 나이 : " + ani2.age);
		// Animal 클래스의 인스턴스를 생성하여
		// 인스턴스 변수값을 바로 출력해보면 기본값으로 자동으로 초기화 되어있다!
		// => int 타입 기본값 : 0, String 타입 기본값 : null(아무 주소값도 참조하지 않음)
		// => 기본데이터타입 8가지 외의 모든 타입은 기본값이 null

		System.out.println("--------------------------");
		
		// Person 클래스 인스턴스 생성
		// 이름 : 홍길동, 나이 : 20, 배고픔 : true   =>  콘솔에 출력
		// Person 인스턴스의 eat() 메서드 호출
		// 다시 이름, 나이, 배고픔 출력
		// Person 인스턴스의 work() 메서드 호출
		// 다시 이름, 나이, 배고픔 출력
		Person p = new Person();
		p.name = "홍길동";
		p.age = 20;
		p.isHungry = true;
		
		System.out.println("이름 : " + p.name + ", 나이 : " + p.age + ", 배고픔 : " + p.isHungry);
		
		p.eat();
		System.out.println("이름 : " + p.name + ", 나이 : " + p.age + ", 배고픔 : " + p.isHungry);
		
		p.work();
		System.out.println("이름 : " + p.name + ", 나이 : " + p.age + ", 배고픔 : " + p.isHungry);
		
		
	}

} // Ex 클래스 끝

/*
 * 다른 클래스를 하나의 java 파일 내에서 정의할 수도 있다.
 * 단, 파일명과 같은 이름을 갖는 클래스 앞에 public 을 사용해야한다!
 * => public 이 붙은 클래스(현재 파일명과 동일한 클래스)의 소스파일(.java)만 만들어지고
 *    다른 클래스는 소스파일이 생성되지 않는다!
 *    대신, 바이트코드(.class)는 각 클래스별로 별도로 생성됨 
 */
// 동물(Animal) 클래스
// 멤버변수 : 이름(name), 나이(age)
// 멤버메서드 : cry() - "동물 울음 소리" 출력, 매개변수 없고, 리턴값 없는 메서드
//              eat() - 문자열(food)을 전달받아 "XXX 먹기!" 출력, 매개변수 있고, 리턴값 없음
class Animal {
	// 인스턴스 멤버변수 선언
	String name;
	int age;
	
	// 메서드 정의
	public void cry() {
		System.out.println("동물 울음 소리!");
	}
	
	public void eat(String food) {
		System.out.println(food + " 먹기!");
	}
	
}

// 교재 p176
// Person 클래스 정의
class Person {
	// 멤버변수(인스턴스변수)
	String name;
	int age;
	boolean isHungry;
	
	// 멤버메서드
	void eat() {
		System.out.println("냠냠.");
		isHungry = false; // eat() 수행 시 밥을 먹으므로 배고픔(isHungry)이 false 로 변경
	}
	
	void work() {
		System.out.println("열심히");
		isHungry = true; // work() 수행 시 일을 했으므로 배고픔(isHungry)이 true 로 변경
	}
}












