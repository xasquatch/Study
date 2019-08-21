
public class Ex {

	public static void main(String[] args) {
		/* 
		 * < 클래스의 인스턴스 생성 기본 문법 >
		 * 클래스명 변수명 = new 클래스명();
		 * 
		 * < 클래스의 멤버 접근 방법 >
		 * - 클래스 타입으로 선언한 참조변수명 뒤에 마침표(.)를 붙이고
		 *   그 뒤에 멤버변수 또는 멤버메서드를 지정하여 접근
		 * => 참조변수명.멤버변수명
		 *    참조변수명.멤버메서드명()
		 */
		
		// Student 클래스의 인스턴스 생성
		Student stu = new Student(); // 학생 1명에 해당하는 Student 인스턴스 1개 생성
		// Student 클래스의 멤버변수 : 2개(name, id)
		// Student 클래스의 멤버에 접근하기 위해서는 변수 stu 를 통해 접근할 수 있다!
		stu.id = 20190101; // 멤버변수 id 에 정수 20190101 저장 
		// 참조변수 stu가 가리키는 주소값을 따라가면, 멤버변수 id 가 있고
		// 해당 id 라는 멤버변수에 접근하여 값을 저장할 수 있다!
		stu.name = "홍길동"; // 멤버변수 name 에 문자열 "홍길동" 저장
		
		// 멤버변수 값을 콘솔에 출력
		System.out.println("번호 : " + stu.id);
		System.out.println("이름 : " + stu.name);
		
		System.out.println("---------------------");
		// Student 클래스의 두 번째 인스턴스 생성(stu2)
		// 기존 인스턴스를 저장하는 변수 stu 와 다른 변수를 사용하므로 
		// 새로운 인스턴스를 별도로 관리할 수 있다. = 다른 학생의 정보를 따로 저장 가능
		Student stu2 = new Student();
		stu2.name = "김민재";
		stu2.id = 20131395;
		
		System.out.println("번호 : " + stu2.id);
		System.out.println("이름 : " + stu2.name);
		
		// 여전히 "홍길동" 학생의 인스턴스는 stu 변수를 통해 접근할 수 있다!
		System.out.println("번호 : " + stu.id);
		System.out.println("이름 : " + stu.name);
	}

}



















