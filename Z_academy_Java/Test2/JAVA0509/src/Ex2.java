
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 메서드(Method)
		 * - 프로그램에서 작업의 최소 단위(최소 실행 단위)
		 * - 반드시 호출되어야 사용할 수 있다
		 *   => 특정 메서드를 호출하는 메서드 : Caller 메서드(주로 main() 메서드)
		 *      특정 메서드로부터 호출되어 작업을 수행하는 메서드 : Worker 메서드 
		 *   => 단, main() 메서드는 호출하지 않아도 프로그램 시작 시 자동으로 호출되는 메서드
		 *      (즉, 프로그램의 시작점(Starting point) 역할을 하는 메서드)
		 * - 메서드 선언부(Header)와 구현부(Body)로 구분됨
		 * 
		 * < 메서드 정의 기본 문법 >
		 * [제한자] 리턴타입 메서드명([매개변수...]) {
		 * 		// 메서드 내에서 수행할 작업들...
		 * 		[return [리턴값];]
		 * }
		 * 
		 * < 메서드의 문법 구조별 분류 - 4가지 >
		 * 1. 매개변수도 없고, 리턴값도 없는 메서드 
		 * 2. 매개변수는 없고, 리턴값만 있는 메서드
		 * 3. 매개변수만 있고, 리턴값은 없는 메서드
		 * 4. 매개변수도 있고, 리턴값도 있는 메서드
		 */
		
		// 1. 매개변수도 없고, 리턴값도 없는 메서드
		System.out.println("동생아! 불 좀 꺼라!");
		sister_1(); // sister_1() 메서드 호출
		// => 매개변수가 없으므로 메서드 괄호() 내에 아무것도 기술하지 않음 
		System.out.println("sister_1() 메서드 종료!");
		
		System.out.println("-----------------------");
		
		// 2. 매개변수는 없고, 리턴값만 있는 메서드
		System.out.println("동생아! 물 좀 떠다 도!");
//		sister_2(); // sister_1() 메서드 호출
		// => 매개변수가 없으므로 메서드 괄호() 내에 아무것도 기술하지 않음
		// => 리턴값이 있지만, 리턴받은 값을 사용하지 않을 경우 아무것도 기술하지 않아도 되지만
		
//		String result = sister_2(); // 리턴값을 받아서 변수에 저장하거나
//		System.out.println("동생이 갖다준 것 : " + result);
		
		// 출력문 등에 리턴값을 직접 사용할 수도 있다!
		System.out.println("동생이 갖다준 것 : " + sister_2()); 
		
		System.out.println("sister_2() 메서드 종료!");
		
		System.out.println("-----------------------");
		
		// 3. 매개변수만 있고, 리턴값은 없는 메서드
		System.out.println("동생아! 200원 줄게 과자 사먹어라!");
		sister_3(200); // sister_3() 메서드 호출 
		// => 매개변수가 있으므로 반드시 괄호() 안에 데이터 기술
		//    (메서드 선언부의 매개변수 타입과 갯수가 일치해야함)
		System.out.println("sister_3() 메서드 종료!");
		
		System.out.println("-----------------------");
		
		// 4. 매개변수도 있고, 리턴값도 있는 메서드
		System.out.println("동생아! 1000원 줄게 나도 새우깡 사다도!");
		int myMoney = 1000;
		String snack = sister_4(myMoney); // sister_4() 메서드 호출(매개변수 값으로 변수 사용 가능);
		
		System.out.println("동생이 사다준 것 : " + snack);
		System.out.println("sister_4() 메서드 종료!");
	
	} // main() 메서드 끝
	

	// 각 메서드 정의
	// 1. 매개변수도 없고, 리턴값도 없는 메서드
	public static void sister_1() {
		// 매개변수가 없으므로 메서드 선언부의 괄호() 내에 아무것도 기술하지 않음(변수 선언 X)
		// 리턴값이 없으므로 리턴타입을 생략하지 않고 특수 데이터타입인 void 반드시 명시!
		System.out.println("오빠가 불을 끄라고 시켜서 불을 껐다!");
//		return; // 리턴문. 현재 메서드를 종료하고 호출한 곳으로 되돌아감(생략 가능)
		// 리턴타입이 void 일 경우 return 문을 생략할 수도 있고
		// return 문만 기술할 수 있다! (=> 주의!! return 문 뒤에 어떠한 값도 기술할 수 없다!)
	} // sister_1() 메서드 끝
	
	// 2. 매개변수는 없고, 리턴값만 있는 메서드
	public static String sister_2() {
		// 매개변수가 없으므로 메서드 선언부의 괄호() 내에 아무것도 기술하지 않음(변수 선언 X)
		// 리턴값이 있으므로 리턴타입부분에 리턴할 데이터 타입(문자열일 경우 String) 명시
		System.out.println("오빠가 물을 떠오라고 시켰다!");
		
		// 리턴타입이 void 가 아닌 다른 타입일 경우에는
		// 반드시 해당 타입의 데이터를 리턴하는 return 문을 기술해야함! => 생략 불가!
//		return '물'; // 오류 발생! 반드시 String 타입 데이터를 리턴해야함!
		
		return "물"; // 리터럴을 직접 리턴하거나
		
//		String result = "물";
//		return result; // 변수를 리턴할 수도 있다!
	}
	
	// 3. 매개변수만 있고, 리턴값은 없는 메서드
	public static void sister_3(int money) {
		// 매개변수가 있으므로 Caller 에서 메서드 호출 시 전달하는 데이터를 저장할 변수 선언 필수!
		// => 값을 대입하는 것이 아니라 데이터 저장할 변수만 선언하는 것이다! (자동으로 저장됨)
		System.out.println("오빠가 과자 사먹으라고 " + money + "원을 줬다!");
		money -= 200;
		System.out.println("새우깡 사먹고 " + money + "원이 남았다!");
		
		// 리턴타입이 void 이므로 return 문 생략할 수 있다.
	}
	
	// 4. 매개변수도 있고, 리턴값도 있는 메서드
	public static String sister_4(int money) {
		System.out.println("오빠가 과자 사오라고 " + money + "원을 줬다!");
		money -= 200;
		System.out.println("새우깡을 사고 " + money + "원이 남았다!");
		
		return "새우깡";
		// return 문에는 반드시 하나의 데이터만 리턴 가능하다! 복수개의 데이터 리턴 불가!
	}
	

} // 클래스 끝




















