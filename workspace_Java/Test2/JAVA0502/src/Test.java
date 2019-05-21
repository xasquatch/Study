
public class Test {

	public static void main(String[] args) {
		// 1 ~ 10 까지 1씩 증가하면서 1 ~ 10 사이의 홀수 합(oddTotal) 계산하여 출력
		int oddTotal = 0; // 홀수의 합을 저장할 변수
		
		for(int i = 1; i <= 10; i++) {
			
			// if 문을 사용하여 i값이 홀수일 때만 골라내기
			if(i % 2 == 1) { // 홀수 계산
				oddTotal += i; // i 값 누적
				System.out.println("i = " + i + ", total = " + oddTotal);
			}
			
		}
		
		System.out.println("1 ~ 10 사이의 홀수 합 : " + oddTotal);
		
		System.out.println("------------------------------------");
		
		// 1 ~ 10 까지 1씩 증가하면서 1 ~ 10 사이의 짝수 합(evenTotal) 계산하여 출력
		int evenTotal = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			// if 문을 사용하여 i값이 짝수일 때만 골라내기
			if(i % 2 == 0) { // 짝수 계산
				evenTotal += i; // i 값 누적
				System.out.println("i = " + i + ", total = " + evenTotal);
			}
			
		}
		
		System.out.println("1 ~ 10 사이의 짝수 합 : " + evenTotal);
		
		System.out.println("-------------------------------------");
		
		oddTotal = 0;
		evenTotal = 0;
		
		// 1 ~ 10까지 1씩 증가하면서 홀수 합, 짝수 합 각각 계산하여 출력
		for(int i = 1; i <= 10; i++) {
			
			// if 문을 사용하여 i값이 홀수일 때만 골라내기
			if(i % 2 == 0) { // 짝수 계산
				evenTotal += i; // i 값 누적
				System.out.println("i = " + i + ", 짝수 누적 = " + evenTotal);
			} else { // 홀수 계산
				oddTotal += i; // i 값 누적
				System.out.println("i = " + i + ", 홀수 누적 = " + oddTotal);
			}
			
		}
		
		System.out.println("1 ~ 10 사이의 홀수 합 : " + oddTotal);
		System.out.println("1 ~ 10 사이의 짝수 합 : " + evenTotal);
	}

}
















