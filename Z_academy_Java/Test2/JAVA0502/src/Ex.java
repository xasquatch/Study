
public class Ex {

	public static void main(String[] args) {
		/*
		 * 반복문을 활용한 값의 누적
		 * 
		 * < 공식 >
		 * 1. 반복문 바깥에서 값을 누적하여 저장할 변수 선언 및 초기화
		 * 2. 필요한 반복 횟수만큼 반복문 정의
		 * 3. 반복문 내에서 누적할 값을 누적 변수(1번에서 초기화한 변수)에 누적
		 * 4. 반복문 종료 후 누적 변수의 값을 출력 또는 사용
		 */
		
		// 반복문을 사용하지 않은 1 ~ 10까지의 합 계산(1 + 2 + 3 + ... + 10 = 55)
		int total = 0; // 누적 합계를 저장할 변수(합계이므로 0으로 초기화)
		int num = 1; // 누적 변수에 누적할 값
		System.out.println("num = " + num + ", total = " + total);
		
		// 변수 num 을 활용하여 1 ~ 10 까지의 합을 total 에 누적
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		total += num; // num 값을 total 에 누적
		num++; // num 값을 1 증가시킴
		System.out.println("num = " + num + ", total = " + total);
		
		System.out.println("1 ~ 10 까지의 합 : " + total);
		
		System.out.println("====================================");
		
		// for문을 사용한 1 ~ 10 까지 합 계산
		total = 0;
		num = 1;
		
		for(int i = 1; i <= 10; i++) { // i가 1 ~ 10까지 1씩 증가(10회 반복)
			total += num; // num 값을 total 에 누적
			num++; // num 값을 1 증가시킴
			System.out.println("num = " + num + ", total = " + total);
		}
		
		System.out.println("------");
		// 제어변수 i 대신 기존의 num 값을 제어변수도 사용해도 무관하다!
		
		total = 0;
		for(num = 1; num <= 10; num++) { // num 이 1 ~ 10까지 1씩 증가(10회 반복)
			total += num; // num 값을 total 에 누적
			System.out.println("num = " + num + ", total = " + total);
		}
		
		System.out.println("1 ~ 10 까지의 합 : " + total);
		
	}

}




















