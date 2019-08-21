
public class Ex2 {
	
	public static void main(String[] args) {
		/*
		 * 접근제어자(Access Modifier)
		 * - 특정 멤버변수 접근을 제한하기 위해 사용하는 키워드
		 * - public, protected, default, private 4가지
		 * - 클래스, 메서드, 변수의 앞에 붙여서 접근을 제한할 수 있다.
		 * 
		 * < 기본 문법 >
		 * [접근제어자] class 클래스명 {}
		 * [접근제어자] 리턴타입 메서드명(매개변수...) {}
		 * [접근제어자] 데이터타입 변수명;
		 * 
		 * < public vs private >
		 * 
		 */
		
		Animal2 ani = new Animal2();
		ani.name = "멍멍이";
		ani.age = 3;
		ani.print();
		
		ani.age = -10; // 정수형 범위에 -10 이 포함되지만 "나이" 에 맞지 않은 값
		               // 하지만 변수에 직접 접근하여 값을 변경하므로 제어할 방법이 없다!
		
		System.out.println("-------------");
		
		Animal3 ani2 = new Animal3();
//		ani2.name = "멍멍이"; // 컴파일에러 발생! private 접근지정자이므로 외부에서 접근 불가
		
		ani2.setName("멍멍이");
		System.out.println("이름 : "+ani2.getName());
		
		ani2.setAge(3);
		System.out.println("나이 : "+ani2.getAge());
		
//		ani2.age = 3; // 컴파일에러 발생! private 접근지정자이므로 외부에서 접근 불가
	}

}

class Animal2 {
	String name;
	int age;
	
	// print() 메서드 정의 : 인스턴스변수 name, age 값 출력(매개변수 X, 리턴값 X)
	public void print() {
		System.out.println("이름 : " + name + ", 나이 : " + age);
	}
	
}

class Animal3 {
	private String name; // 접근제어자가 private 이므로 외부 클래스에서 접근 불가! 
	private int age; // 접근제어자가 private 이므로 외부 클래스에서 접근 불가! 
	
	// 인스턴스 변수는 대부분 외부에서 접근이 불가능하도록 private 접근제어자 사용
	// => 이 때, 외부에서 값을 저장하거나 꺼낼 수 없으므로
	//    클래스 내에서 대신 값을 저장하거나 꺼내는 역할을 수행하는 메서드를 정의해야한다!
	//    => 이 메서드들은 외부에서 "누구나" 접근 가능해야 하므로 접근제어자로 public 사용
	// => Getter 메서드 : 인스턴스 변수 값을 외부로 전달하는 역할의 메서드
	//                    메서드명을 getXXX() 형태로 작성 - XXX 은 리턴할 데이터의 변수명
	//                    (매개변수는 없고, 리턴값만 있는 메서드)
	// => Setter 메서드 : 외부로부터 값을 전달받아 인스턴스 변수에 저장하는 역할의 메서드
	//                    메서드명을 setXXX() 형태로 작성 - XXX 은 저장할 데이터의 변수명
	//                    (매개변수는 있고, 리턴값은 없는 메서드)
	
	// name 변수값을 외부로 리턴할 Getter : getName() => 리턴타입 String, 매개변수 X
	public String getName() {
		return name; // name 값 리턴
	}
	
	// name 에 저장할 변수값을 전달받아 저장할 Setter : setName() => 리턴타입 void, 매개변수 O
	public void setName(String newName) {
		name = newName; // 새로운 name 값 저장		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	
	// print() 메서드 정의 : 인스턴스변수 name, age 값 출력(매개변수 X, 리턴값 X)
	public void print() {
		System.out.println("이름 : " + name + ", 나이 : " + age);
		// private 접근제어자를 사용했더라도 같은 클래스 내에서는 접근이 가능하다!
	}
	
}









