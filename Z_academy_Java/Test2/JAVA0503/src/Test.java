
public class Test {

	public static void main(String[] args) {
		// 1 ~ 100 사이의 홀수 합(oddTotal), 짝수 합(evenTotal) 계산
		int i = 1;
		int oddTotal = 0, evenTotal = 0;
		
		while(i <= 100) {
			
			if(i % 2 == 1) { // 홀수일 때
				oddTotal += i;
			} else { // 짝수일 때
				evenTotal += i;
			}
			
			i++;
		}
		
		System.out.println("홀수 합 : " + oddTotal);
		System.out.println("짝수 합 : " + evenTotal);
		
		System.out.println("------------------------");
		
		// 특정 단(dan) 을 입력받아 구구단 출력
		int dan = 2;

		System.out.println(" < " + dan + "단 >");
		
		i = 1;
		
		while(i <= 9) {
//			System.out.println(dan + " * " + i + " = " + (dan * i));
			System.out.printf("%d * %d = %d\n", dan, i, (dan * i));
			i++;
		}
		
	}

}




















