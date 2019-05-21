
public class Ex4 {

	public static void main(String[] args) {
		/*
		 * break 문 vs continue 문
		 * - break 문 : 현재 실행 중인 반복문의 블록{}을 빠져나갈 때 사용
		 *   => 주로, 특정 조건이 만족했을 때 반복문을 모두 실행하지 않더라도 종료할 경우 사용 
		 */
		
		for(int i = 1; i <= 10; i++) {
			if(i == 5) {
				System.out.println("i가 5일 때 break");
				break;
			}
			
			// 1 ~ 4 까지 출력 후 i 값이 5일 때 break 문을 만나면 5는 출력되지 않고 종료됨
			System.out.println(i);
		}
		
		System.out.println("--------------");
		// i값이 1 ~ 1000 까지 반복하면서 i값을 변수 total 에 누적
		// => 단, total 이 10000 이상이 될 때의 i 값을 구하고 종료
		//    (누적 변수 total 의 값이 10000 이상일 경우 반복문을 종료)
		int total = 0, i;
		
		for(i = 1; i <= 1000; i++) {
			total += i;
			
			// 누적변수 total 의 값이 10000 이상이면 반복문 종료
			if(total >= 10000) {
				break;
			}
			
		}
		
		System.out.println("누적변수 total = " + total + ", i = " + i);
		
		System.out.println("----------------------");
		
		total = 0;
		i = 1;
		
		while(i <= 1000) {
			total += i;
			
			// 누적변수 total 의 값이 10000 이상이면 반복문 종료
			if(total >= 10000) {
				break;
			}
			
			i++;
		}
		
		System.out.println("누적변수 total = " + total + ", i = " + i);
		
		System.out.println("-------------------");
		
		// 참고. break 문 없이 반복문을 종료하도록 조건식 변경
		total = 0;
		i = 1;
		
		while(i <= 1000 && total < 10000) {
			total += i;
			
			i++;
		}
		
		System.out.println("누적변수 total = " + total + ", i = " + i);
		
	}

}


















