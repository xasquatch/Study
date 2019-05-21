
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 중첩 while 문
		 * - while 문 내에 또 다른 while 문을 기술하는 형태
		 *   => 중첩 for 문과 동일 
		 *   
		 * < 기본 문법 >
		 * 초기식1;
		 * 
		 * while(조건식1) { // 바깥쪽 while 문
		 * 		문장1;
		 * 
		 * 		초기식2;
		 * 
		 * 		while(조건식2) { // 안쪽 while 문
		 * 			문장2;
		 * 			증감식;
		 * 		}
		 * 
		 * 		증감식1;
		 * }
		 * 
		 */
		
		/*
		 * 바깥쪽 while 문 i값이 1 ~ 5 까지 1씩 증가하면서 반복할 동안
		 * 안쪽 while 문 j값을 1 ~ 3 까지  1씩 증가하면서 반복
		 */
		int i = 1;
		
		while(i <= 5) {
			
			System.out.println("----------------- 바깥쪽 while 문 i = " + i); // 문장1(i = 5회 반복)
			
			int j = 1;
			
			while(j <= 3) {
				
				System.out.println("안쪽 while 문 j = " + j); // 문장2(j = 3회 * 5회 = 15회 반복)
				j++;
			}
			
			System.out.println("안쪽 while 문 종료"); // 문장3(i = 5회 반복)
			
			i++;
		}
		
		System.out.println("----------------- 바깥쪽 while 문 종료");
	}

}












