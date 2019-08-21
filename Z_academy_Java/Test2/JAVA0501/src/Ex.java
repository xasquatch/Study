
public class Ex {

	public static void main(String[] args) {
		/*
		 * switch ~ case 문
		 * - if ~ else if 문과 유사한 조건문
		 * - if 문은 프로그램을 실행할 때 조건에 따른 실행 위치가 결정되지만
		 *   switch ~ case 문은 프로그램을 번역할 때 실행 위치가 결정됨
		 *   => 따라서, if 문에 비해 실행 속도가 빠르다!
		 * - switch ~ case 문 보다 if 문이 더 유연하다!
		 *   (switch 문은 비교할 대상 값에 대한 범위 지정 등이 불가)
		 * 
		 * < 기본 문법 >
		 * switch(식) {
		 * 		case 값1 : 
		 * 			식의 판별 결과가 값1 에 해당할 때 실행할 문장들...
		 * 			[break;]
		 * 		case 값2 : 
		 * 			식의 판별 결과가 값2 에 해당할 때 실행할 문장들...
		 * 			[break;]
		 * 		case 값n :
		 * 			식의 판별 결과가 값n 에 해당할 때 실행할 문장들...
		 * 			[break;]
		 * 		[default :
		 *   		위의 case 문에 아무것도 해당되지 않을 때 실행할 문장들...]
		 * }
		 * 
		 * => switch 문의 식은 연산식, 변수, 리터럴이 올 수 있으나
		 *    해당 식의 결과가 정수 또는 문자열이어야 한다!
		 * => case 문 뒤의 값은 반드시 리터럴만 사용 가능하다!
		 *    (단, case 문 끼리의 순서는 무관하며, 중복될 수 없다!)
		 *    
		 */
		
		int num = 1;
		
		switch(num) {
			case 0 : 
				System.out.println(num + " : 0이다!");
			case 1 :
				System.out.println(num + " : 1이다!");
			case 2 :
				System.out.println(num + " : 2이다!");
			default :
				System.out.println("1, 2, 3 아닌 모든 경우!");
		}
		
		// switch ~ case 문에서 case 에 일치하는 값을 찾았을 경우
		// case 문 : 뒤의 문장을 실행하는데, 이 때 break 문이 없으면
		// break 문을 만날때 까지 또는 switch 문이 끝날 때까지 
		// 해당 case 문의 아래쪽 모든 case 문과 default 문을 실행
		
		System.out.println("------------------------");
		
		num = 10;
		
		switch(num) {
			case 0 : 
				System.out.println(num + " : 0이다!");
				break;
			case 1 :
				System.out.println(num + " : 1이다!");
				break; 
			case 2 :
				System.out.println(num + " : 2이다!");
				break;
			default :
				System.out.println("1, 2, 3 아닌 모든 경우!");
		}
		
		// num = 1 일 때, case 1 뒤의 문장을 실행한 후 break 문을 만나므로
		// 실행중인 switch 문을 빠져나감(나머지 문장 실행 X)
		
		// num = 10 일 때, 일치하는 case 문이 없으므로 default 문을 찾아서 실행한다!
		// => 만약 default 문이 없으면 그대로 종료
	}

}











