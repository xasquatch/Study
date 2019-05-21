
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * - 특정 조건에 따라 실행할 문장을 지정된 횟수만큼 반복하는 문
		 * - for문, while문 으로 분류됨
		 * - 초기식, 조건식, 증감식, 블록문 으로 구성되며 각 항목은 생략될 수 있다
		 * 
		 * 1. for문
		 *    - 지정된 횟수만큼 반복하는 문장에 적합한 반복문
		 *    - 초기식, 조건식, 증감식, 블록문(반복할 문장들)의 위치가 정해져 있으므로 문법이 쉽다
		 *    - 조건식 판별 결과가 true 일 동안 블록문{} 내의 문장을 반복 실행
		 *    
		 *    < 기본 문법 >
		 *    for(초기식; 조건식; 증감식) {
		 *    		// 조건식 판별 결과가 true 일 때 실행할 블록문...
		 *    }
		 *    
		 *    => 초기식 : 조건식에 사용할 변수를 초기화하는 용도(변수를 제어변수라고 함)
		 *       조건식 : 반복 실행 여부를 판별하는 용도
		 *       증감식 : 초기식을 조건식에 부합될 때까지 변화시키는 용도
		 *       블록문 : 한 줄 이상의 반복 실행할 문장
		 *     
		 */
		
		// 출력문을 10번 사용하여 "Hello, World" 출력
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		System.out.println("Hello, World!");
		
		System.out.println("--------------");
		
		// for문을 사용하여 "Hello, World!" 10번 반복 출력
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + " : Hello, World!");
		}
		
		/*
		 * 위의 반복문을 디버깅 해보기!
		 * 
		 *  초기식(i)  조건식(i <= 10)  실행결과                  증감식(i++)
		 * --------------------------------------------------------------------
		 *    i = 1        true         "1 : Hello, World!" 출력     i = 2
		 *    i = 2        true         "2 : Hello, World!" 출력     i = 3
		 *    i = 3        true         "3 : Hello, World!" 출력     i = 4
		 *    i = 4        true         "4 : Hello, World!" 출력     i = 5
		 *    ..... 중간 생략
		 *    i = 10       true         "10 : Hello, World!" 출력     i = 11
		 *    i = 11       false        for 문 종료됨
		 * 
		 */
		
		System.out.println("--------------------------");
		
		// 정수 1 ~ 10 까지 출력(1 2 3 4 5 6 7 8 9 10)
		for(int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		System.out.println("--------------------------");
		
		// 정수 1 ~ 10까지 홀수만 출력(1 3 5 7 9)
		for(int i = 1; i <= 10; i += 2) { // 증감식에서 i 값을 2씩 증가하도록 변경
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		System.out.println("--------------------------");
		
		// 정수 2 ~ 10까지 짝수만 출력(2 4 6 8 10)
		for(int i = 2; i <= 10; i += 2) { // 증감식에서 i 값을 2씩 증가하도록 변경
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		System.out.println("--------------------------");
		
		// 정수 10 ~ 1까지 역순으로 출력(10 9 8 7 6 5 4 3 2 1)
		for(int i = 10; i >= 1; i--) { // 증감식에서 i 값을 1씩 감소시키도록 변경
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

}





















