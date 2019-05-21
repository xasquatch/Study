
public class Test2 {

	public static void main(String[] args) {
		/*
		 * 구구단 2단 ~ 9단 출력
		 */
		int dan = 2;
		
		while(dan <= 9) {
			
			System.out.println(" < " + dan + "단 >");
			
			int i = 1;
			
			while(i <= 9) {
				
				System.out.println(dan + " * " + i + " = " + (dan * i));
				i++;
			}
			
			dan++;
			System.out.println();
		}
		
		System.out.println("--------------");
		
		/*
		 * 시계 XX시 XX분 XX초 출력
		 */
		
		int hour = 0;
		
		while(hour <= 23) {
			
			int min = 0;
			
			while(min <= 59) {
				
				int sec = 0;
				
				while(sec <= 59) {
					
					System.out.printf("%02d시 %02d분 %02d초\n", hour, min, sec);
					sec++;
				}
				
				min++;
				
			}
			
			hour++;
			System.out.println();
		}
		
		
	}

}




















