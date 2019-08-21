
public class Ex5 {

	public static void main(String[] args) {
		/*
		 * continue 문
		 * - break 문과 달리 반복문을 빠져나가는 것이 아니라
		 *   현재 반복을 중단하고 다음 반복을 실행
		 *   (즉, 현재 실행중인 반복문의 continue 문 아래쪽 문장을 모두 생략하고 다음 반복 실행)
		 * 
		 */
		
		for(int i = 1; i <= 10; i++) {
			if(i == 5) {
				System.out.println("i가 5일 때 continue");
				continue;
			}
			
			// 1 ~ 4 까지 출력 후 i 값이 5일 때 continue 문을 만나면 5는 출력되지 않고
			// 다음 반복 수행을 위해 증감식(i++) 로 점프
			// => 즉, System.out.println(i); 메서드는 현재 반복의 실행 대상에서 제외됨
			System.out.println(i);
		}
		
		System.out.println("-----------------------");
		
		// 1 ~ 10까지 1씩 증가하면서 제어변수 i값을 total 에 누적
		int total = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			// i값이 홀수일 때만 total 에 i 값을 누적
			// => if문을 사용하여 짝수일 때 continue 문 실행하도록 하여 누적 문장 실행 생략
			if(i % 2 == 0) {
				System.out.println("i = " + i + "일 때 continue");
				continue;
			}
			
			System.out.println("i = " + i + "일 때 누적");
			total += i;
		}
		
		System.out.println("total = " + total);
		
	}

}
















