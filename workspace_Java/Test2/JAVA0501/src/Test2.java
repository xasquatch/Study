
public class Test2 {

	public static void main(String[] args) {
		/*
		 * for문을 사용하여 구구단 출력
		 * => 특정 단을 입력받아 구구단을 다음과 같이 출력
		 * ex) 변수 dan = 2 일 때
		 * 
		 *  < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * 2 * 5 = 10
		 * 2 * 6 = 12
		 * 2 * 7 = 14
		 * 2 * 8 = 16
		 * 2 * 9 = 18
		 * 
		 */
		int dan = 2;
		
		System.out.println(" < " + dan + "단 >");
//		System.out.println(dan + " * " + 1 + " = " + (dan * 1));
//		System.out.println(dan + " * " + 2 + " = " + (dan * 2));
//		System.out.println(dan + " * " + 3 + " = " + (dan * 3));
//		System.out.println(dan + " * " + 4 + " = " + (dan * 4));
//		System.out.println(dan + " * " + 5 + " = " + (dan * 5));
//		System.out.println(dan + " * " + 6 + " = " + (dan * 6));
//		System.out.println(dan + " * " + 7 + " = " + (dan * 7));
//		System.out.println(dan + " * " + 8 + " = " + (dan * 8));
//		System.out.println(dan + " * " + 9 + " = " + (dan * 9));
		
		for(int i = 1; i <= 9; i++) {
			// 구구단 출력 문장
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
		
		/*
		 * 구구단 출력 디버깅
		 * 
		 *   dan  초기식(i)  조건식(i <= 9)    실행 결과           증감식(i++)
		 * ---------------------------------------------------------------------------------
		 *    2      1          true           2 * 1 = 2 출력        i = 2
		 *    2      2          true           2 * 2 = 4 출력        i = 3
		 *    2      3          true           2 * 3 = 6 출력        i = 4
		 *    2      4          true           2 * 4 = 8 출력        i = 5
		 *    2      5          true           2 * 5 = 10 출력       i = 6
		 *    2      6          true           2 * 6 = 12 출력       i = 7
		 *    2      7          true           2 * 7 = 14 출력       i = 8
		 *    2      8          true           2 * 8 = 16 출력       i = 9
		 *    2      9          true           2 * 9 = 18 출력       i = 10     
		 *    2     10          false          for문 종료됨
		 * 
		 */
		
		
	}

}


















