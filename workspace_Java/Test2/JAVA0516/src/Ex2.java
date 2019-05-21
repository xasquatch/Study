
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 메서드의 매개변수에 대한 가변인자(Variable Arguments, VARARGS, 비정형 인자) 사용 - 메서드 호출 시 정의된
		 * 매개변수 갯수와 타입에 맞게 호출 시 값을 전달해야하지만 가변인자를 사용할 경우 메서드 정의 시 갯수를 지정하지 않고 데이터타입과 변수명
		 * 사이에 ... 을 표기하여 갯수를 생략한다. => 따라서, 외부에서 해당 타입 데이터를 몇 개를 전달하더라도 메서드에서 전달받아 배열로
		 * 관리해준다! - 주의사항! 가변인자는 매개변수의 마지막 인자로 한 번만 사용 가능!
		 * 
		 * < 가변형 인자를 사용한 메서드 정의 기본 문법 > [접근제어자] 리턴타입 메서드명(데이터타입... 변수명) { // 메서드에서 수행할
		 * 작업들... } => 매개변수 부분의 변수명으로 된 배열이 자동으로 생성되어 데이터가 저장됨 => ... 기호는 데이터타입과 변수명 사이에
		 * 어디든 위치 가능
		 * 
		 */

		// print() 메서드 호출하여 값 전달 : 'A', "홍길동", "이순신"
		NormalArguments na = new NormalArguments();
		na.print('A', "홍길동", "이순신");
		System.out.println("--------------------------------------------------------");
		na.print('A', "홍길동", "이순신", "강감찬");
		na.print('A', "홍길동", "이순신", "강감찬", "김태희");
		na.print('A', "홍길동", "이순신", "강감찬", "신수환", "김태희");

		System.out.println("========================================================");
		VariableArguments va = new VariableArguments();
		va.print('A', "홍길동", "이순신");
		va.print('A', "홍길동", "이순신", "강감찬");
		va.print('A', "홍길동", "이순신", "강감찬", "김태희");
		va.print('A', "홍길동", "이순신", "강감찬", "신수환", "김태희");
	}

}

class VariableArguments {
	// 가변인자를 활용한 초대장 출력(초대자 명단을 가변인자로 사용)
	public void print(char groupType, String... names) {
		// print() 메서드 호출 시 char 타입 1개, String 타입 무한대로 전달 가능
		// => 이 때, 전달받은 String 타입 데이터는 names 라는 이름의 배열로 관리됨
		// 전달받은 nanes 배열을 반복문을 사용하여 접근
		System.out.println("그룹 : " + groupType);
//		System.out.println("초대할 명단 : " + name1 + ", " + name2);
		for (int i = 0; i < names.length; i++) {
			System.out.println("초대할 명단 : " + names[i]);
		}
	}

}

class NormalArguments {
	// 초대장 출력을 위해 그룹타입과 초대할 사람의 명단을 입력하면 화면에 출력
	public void print(char groupType, String name1, String name2) {
		System.out.println("그룹 : " + groupType);
		System.out.println("초대할 명단 : " + name1 + ", " + name2);
	}

	public void print(char groupType, String name1, String name2, String name3) {
		System.out.println("그룹 : " + groupType);
		System.out.println("초대할 명단 : " + name1 + ", " + name2 + ", " + name3);
	}

	public void print(char groupType, String name1, String name2, String name3, String name4) {
		System.out.println("그룹 : " + groupType);
		System.out.println("초대할 명단 : " + name1 + ", " + name2 + ", " + name3 + ", " + name4);
	}

	public void print(char groupType, String name1, String name2, String name3, String name4, String name5) {
		System.out.println("그룹 : " + groupType);
		System.out.println("초대할 명단 : " + name1 + ", " + name2 + ", " + name3 + ", " + name4 + ", " + name5);
	}

}
