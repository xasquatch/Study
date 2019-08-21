
public class Ex6 {

	public static void main(String[] args) {
		/*
		 * Label 의 활용
		 * => 중첩 반복문에서 원하는 위치의 반복문을 빠져나가기 위한 위치 지정문
		 * 
		 * < 기본 문법 >
		 * 레이블명:
		 * 반복문() {
		 *		반복문() {
		 *			if(조건식) {
		 *				break 레이블명;
		 * 			}
		 *		}		
		 * }
		 */
		
		for(int dan = 2; dan <= 9; dan++) {
			
			System.out.println(" < " + dan + "단 >");
			
			for(int i = 1; i <= 9; i++) {

				// 현재 dan 이 5단일 때 반복문 종료
				if(dan == 5) {
					break; 
					// 중첩 for문에서 일반 break 문을 사용할 경우
					// 현재 소속된 반복문의 블록문을 빠져나가므로 5단 출력만 생략되고
					// 6단부터 다음 반복문이 다시 실행됨
					// => 즉, dan 반복이 아닌 i 반복문을 빠져나가므로 다음 i 반복이 실행됨
				}
				
				System.out.println(dan + " * " + i + " = " + (dan * i));
				
			}
			
			System.out.println();
		}
		
		System.out.println("-----------------------------------------");
		
		EXIT_FOR:
		for(int dan = 2; dan <= 9; dan++) {
			
			System.out.println(" < " + dan + "단 >");
			
			for(int i = 1; i <= 9; i++) {

				// 현재 dan 이 5단일 때 반복문 종료
				if(dan == 5) {
					break EXIT_FOR; 
					// 중첩 for문에서 break 문에 레이블 사용할 경우
					// 레이블 다음에 오는 반복문의 블록문을 빠져나가므로
					// 5단 제목만 출력된 후 바깥쪽 for문을 빠져나감
					// => 즉, 5단 이후의 모든 반복문은 실행되지 않는다!
					
//					continue EXIT_FOR;
					// 만약, break 문 대신 continue 문을 사용할 경우
					// 레이블 다음에 오는 반복문의 다음 반복을 실행하므로
					// 바깥쪽 for문 dan++ 증감식으로 점프한다!
					// => 즉, 5단 제목만 출력한 후 6단부터 다시 반복 실행
				}
				
				System.out.println(dan + " * " + i + " = " + (dan * i));
				
			}
			
			System.out.println();
		}
		
	}

}
