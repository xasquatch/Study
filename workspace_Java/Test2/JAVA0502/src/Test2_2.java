
public class Test2_2 {

	public static void main(String[] args) {
		/*
		 * 구구단 2 ~ 9단까지 출력
		 * 
		 * < 출력 예제 >
		 * 
		 *  < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...생략...
		 * 2 * 9 = 18
		 * 
		 *  < 3단 >
		 * 3 * 1 = 3
		 * 3 * 2 = 6
		 * ...생략...
		 * 
		 *  < 9단 >
		 * ...생략...
		 * 9 * 9 = 81
		 */
		
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println(" < " + dan + "단 >");
			
			for(int i = 1; i <= 9; i++) {
				System.out.println(dan + " * " + i + " = " + (dan * i));
			}
			
			System.out.println();
		}
		

		System.out.println("----------------------------");
		
		
	}

}





















