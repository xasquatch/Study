
public class Test2 {

	public static void main(String[] args) {
		// 1. 매개변수도 없고, 리턴값도 없는 메서드 연습
		// => 구구단 2단을 출력하는 메서드 gugudan2() 정의
		gugudan2();
			
		System.out.println("-----------");
		
		// 2. 매개변수는 없고, 리턴값만 있는 메서드 연습
		// => 1 부터 10 까지 정수의 합을 리턴하는 메서드 sum() 정의
		//    메서드 실행 후 리턴되는 정수값을 받아서 출력(변수 저장 또는 직접 출력)
		int total = sum(); // sum() 메서드 호출 결과를 리턴받아 total 변수에 저장
		System.out.println("1 ~ 10 사이 정수의 합 : " + total);
		
		System.out.println("-----------");
		
		// 3. 매개변수만 있고, 리턴값은 없는 메서드 연습
		// => 외부에서 정수값을 전달하면 해당 정수의 구구단 출력하는 메서드 gugudanX() 정의
		gugudanX(5); // 구구단 5단 출력
		gugudanX(9); // 구구단 9단 출력
		gugudanX(19);
		
		System.out.println("-----------");
		
		// 4. 매개변수도 있고, 리턴값도 있는 메서드 연습
		// => 외부에서 정수값을 전달하면 "홀수" 또는 "짝수" 를 리턴하는 메서드 oddEven() 정의
		int num = 10;
		System.out.println(num + " : " + oddEven(num));
		
	}
	
	// 1. 매개변수도 없고, 리턴값도 없는 메서드 연습
	// gugudan2() 메서드 정의
	public static void gugudan2() {
		// 구구단 2단 출력
		int dan = 2;
		
		System.out.println(" < " + dan + "단 >");
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
		
	}
	
	// 2. 매개변수는 없고, 리턴값만 있는 메서드 연습
	// sum() 정의
	public static int sum() {
		int total = 0;
		
		for(int i = 1; i <= 10; i++) {
			total += i; // 1 ~ 10 사이의 합 계산
		}
		
		// 리턴타입이 int 이므로 반드시 int 타입 데이터를 리턴해야함
		return total;
	}
	
	
	// 3. 매개변수만 있고, 리턴값은 없는 메서드 연습
	// gugudanX() 정의
	public static void gugudanX(int dan) {
		
		System.out.println(" < " + dan + "단 >");
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
		
	}
	
	
	// 4. 매개변수도 있고, 리턴값도 있는 메서드 연습
	// oddEven() 정의
	public static String oddEven(int x) {
		String result = "";
		
		if(x % 2 == 1) {
			result = "홀수";
		} else {
			result = "짝수";
		}
		
		return result;
		
		// ------------------------
		// 주의사항! return 문을 기술해야할 경우 모든 경우의 수에 return 문이 사용되어야 한다!
//		if(x % 2 == 1) {
//			return "홀수";
//		} else if(x % 2 == 0) {
//			return "짝수";
//		} 
		
		// => if 문과 else if 문 모두 조건 결과가 false 일 경우
		//    아무 return 문도 없으므로 return 문에 대한 오류 발생!
		//    따라서, else 문을 사용하여 return 문을 추가하거나
		//    if 문 종료 후 별도의 return 문을 추가해야한다!
		
		
	}

}















