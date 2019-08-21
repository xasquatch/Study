
public class Test2 {

	public static void main(String[] args) {
		/*
		 * 중첩 for문을 활용한 시간 출력(XX분 XX초)
		 * - 분 : 0 ~ 59분(바깥쪽 for문)
		 * - 초 : 0 ~ 59초(안쪽 for문)
		 * 
		 * < 출력 예 >
		 * 00분 00초
		 * 00분 01초
		 * 00분 02초
		 * ...
		 * 00분 59초
		 * 01분 00초
		 * 01분 01초
		 * ...
		 * 59분 58초
		 * 59분 59초
		 */
		
		for(int min = 0; min <= 59; min++) {
//			System.out.println(min + "분");
			
			for(int sec = 0; sec <= 59; sec++) {
//				System.out.println(min + "분 " + sec + "초");
				System.out.printf("%02d분 %02d초\n", min, sec);
			}
			
		}
		
		System.out.println("------------------------");
		
		// XX시 XX분 XX초 출력(24시간제 : 00시 ~ 23시)
		for(int hour = 0; hour <= 23; hour++) {
			for(int min = 0; min <= 59; min++) {
				for(int sec = 0; sec <= 59; sec++) {
					System.out.printf("%02d시 %02d분 %02d초\n", hour, min, sec);
				}
				
			}
		}
		
		
	}

}
















