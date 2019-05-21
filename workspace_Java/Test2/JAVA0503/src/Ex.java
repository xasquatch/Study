
public class Ex {

	public static void main(String[] args) {
		/*
		 * while 문
		 * - for문처럼 특정 조건 결과가 true 일 동안 반복 실행하는 반복문
		 * - for문과 달리 초기식, 증감식 위치가 정해져있지 않다(조건식 위치만 고정)
		 * - 주로 반복 횟수가 명확히 정해져 있지 않은 경우에 사용
		 * - for문 <-> while문 사이의 전환이 100% 가능하다!
		 * 
		 * < 기본 문법 >
		 * 초기식;
		 * 
		 * while(조건식) {
		 * 		// 반복 실행할 문장들...
		 * 		// 증감식(while 문 블록문 내에서 반복 실행 문장 위 또는 아래에 위치)
		 * }
		 * 
		 */
		
		// 1 ~ 5 까지 1씩 증가하면서 출력(초기식 : 1, 조건식 : 5 이하, 증감식 : 1씩 증가)
		int i = 1; // 초기식
		
		while(i <= 5) { // 조건식
			// 반복 실행할 문장들...
			System.out.println("i값 : " + i);
			i++; // 증감식
		}
		
		System.out.println("while 문 종료 후 i값 : " + i);
		
		// while 문을 for 문으로 전환
		for(i = 1; i <= 5; i++) {
			System.out.println("i값 : " + i);
		}
		
		System.out.println("for 문 종료 후 i값 : " + i);
		
		System.out.println("-----------------------");
		
		// 1 2 3 4 5 6 7 8 9 10 까지 가로로 출력
		i = 1;
		
		while(i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println();
		
		System.out.println("-----------------------");
		
		// 1 ~ 10 까지 홀수만 출력하고, 홀수의 합 계산하여 출력
		i = 1;
		int oddTotal = 0; // 홀수 합
		
		while(i <= 10) {
			System.out.print(i + " ");
			oddTotal += i; // 홀수 누적
			i += 2; // 증감식
		}
		
		System.out.println();
		System.out.println("1 ~ 10 까지 홀수 합 : " + oddTotal); // 25
		
		System.out.println("-----------------------");
		
		// 2 ~ 10 까지 짝수만 출력하고, 짝수의 합 계산하여 출력
		i = 2;
		int evenTotal = 0; // 짝수 합
		
		while(i <= 10) {
			System.out.print(i + " ");
			evenTotal += i; // 짝수 누적
			i += 2;
		}
		
		System.out.println();
		System.out.println("1 ~ 10 까지 짝수 합 : " + evenTotal); // 30
		
		
	}

}













