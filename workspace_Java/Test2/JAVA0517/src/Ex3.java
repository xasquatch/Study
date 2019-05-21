
public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 레퍼런스 this
		 * - 자기 자신의 인스턴스 주소를 담고 있는 변수이자 키워드
		 * - 인스턴스를 생성하게 되면 자동으로 레퍼런스 this 에 자신의 인스턴스 주소가 저장됨
		 * - 인스턴스 변수와 메서드 내의 로컬 변수의 이름이 동일할 때
		 *   메서드 내에서 인스턴스 변수를 구분하기 위해 this 를 붙여 구분한다.
		 * - 메서드 내에 인스턴스 변수와 동일한 이름의 로컬변수가 없을 경우 this 생략 가능
		 * 
		 * < 기본 문법 >
		 * this.인스턴스변수명
		 * 	
		 */
		Person3 p = new Person3();
		
//		p.name = "홍길동";
		p.setName("홍길동");
		
//		System.out.println(p.name);
		System.out.println(p.getName());
		
//		System.out.println(p.age);
	}

}

class Person3 {
	private String name; // 인스턴스 변수 name(멤버 변수)
	private int age;
	
	public void setName(String name) { // 로컬 변수 name
		// 메서드 내의 로컬변수와 인스턴스변수의 이름이 동일할 때
		// 메서드 내에서 해당 변수명은 로컬변수로 취급됨(변수명만으로 인스턴스변수 지정 불가)
//		name = name; // 로컬변수 name 의 데이터를 다시 로컬변수 name(자기자신) 에 저장
		
		// 이 때, 인스턴스 변수 name 을 지정(로컬변수와 구분)하기 위해서는
		this.name = name; // 인스턴스 변수명 앞에 this. 을 붙임
		// => 로컬변수 name 의 값을 인스턴스변수 name 에 저장
		
		// p 와 p2 등 각각 다른 Person3 인스턴스에서 모두 this 를 지정할 수 있는데, 
		// 이 때 각 this 는 서로 다른 인스턴스 주소를 저장하고 있기 때문에 구분이 가능하다!
	}
	
	public String getName() {
		// Getter 메서드 내에서는 인스턴스 변수와 동일한 로컬변수가 없으므로
		// 레퍼런스 this 를 생략할 수 있다!
		return name; // return this.name; 과 동일
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}

















