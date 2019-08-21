
public class Ex3 {

	public static void main(String[] args) {
		/*
		 * do ~ while 문
		 * - while 문은 반복문 실행 전 조건을 판별하여 실행 여부를 결정하지만
		 *   do ~ while 문은 반복문을 일단 무조건 한 번 실행한 후 반복 여부를 판별한다!
		 *   => 즉, while 문은 조건 판별 결과에 따라 반복문을 단 한 번도 실행하지 않을 수도 있지만
		 *      do ~ while 문은 최소한 한 번의 실행이 보장된다!
		 *      
		 * < 기본 문법 >
		 * 초기식;
		 * 
		 * do {
		 * 		// 반복 실행할 문장들...
		 * 		증감식;
		 * } while(조건식);  // 주의사항! while() 뒤에 반드시 세미콜론(;) 필수!
		 * 
		 */
		
		// while 문과 do ~ while 차이 비교
		boolean isTrue = false;
		
		// 1. while 문일 때
		System.out.println("맞을래? " + isTrue);
		
		while(isTrue) { // isTrue == true 와 동일한 조건식
			
		}
		// isTrue 가 false 이므로 while 문 내의 반복문을 실행하지 않는다!
		System.out.println("while 문 종료!");
		
		System.out.println("-------------");
		// 2. do ~ while 문일 때
		System.out.println("맞을래? " + isTrue);
		
		do {
			System.out.println("맞는다!");
		} while(isTrue);
		// isTrue 가 false 이지만, do 문장으로 인해 반복문을 한 번 실행한 후 조건을 판별하여
		// isTrue 가 false 이므로 두 번째 반복은 실행되지 않는다! => 최소 한 번은 무조건 실행!
		System.out.println("while 문 종료!");
		
		System.out.println("===========================");
		
		int i = 11;
		
		while(i <= 10) {
			System.out.println(i + " : Hello, World!");
			i++;
		}
		// => i값이 11일 때, while 문의 경우 반복문이 실행되지 않는다!
		
		System.out.println("-------------");
		
		i = 11;
		
		do {
			System.out.println(i + " : Hello, World!");
			i++;
		} while(i <= 10);
		// => i값이 11이지만 반복문을 한 번 실행한 후 조건식 판별하여 반복문 종료
		
	}

}













