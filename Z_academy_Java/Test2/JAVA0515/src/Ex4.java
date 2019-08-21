
public class Ex4 {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.plus(10, 20); // 10 + 20 = 30 출력
		c.plus(10, 20, 30); // 10 + 20 + 30 = 60 출력
		c.plus(10, 20, 30, 40); // 10 + 20 + 30 + 40 = 100 출력
	}

}

class Calculator {
	// 메서드의 매개변수 갯수가 다른 메서드 오버로딩
	
	// 정수 2개를 전달받아 덧셈 결과를 출력하는 plus() 메서드
	public void plus(int num1, int num2) { 
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
	
	public void plus(long num1, int num2) { 
		long result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
	
	public void plus(int num1, long num2) { 
		long result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
	
//	public void plus(int num2, int num1) {} // 타입이 같고 변수명만 다르면 오버로딩이 아니다!
	
//	public int plus(int num1, int num2) {} // 리턴타입만 다르면 오버로딩이 아니다!
	
	// 정수 3개                    ""
	public void plus(int num1, int num2, int num3) { 
		int result = num1 + num2 + num3;
		System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + result);
	}
	
	// 정수 4개                    ""
	public void plus(int num1, int num2, int num3, int num4) { 
		int result = num1 + num2 + num3 + num4;
		System.out.println(num1 + " + " + num2 + " + " + num3 + " + " + num4 + " = " + result);
	}
	
	
}















