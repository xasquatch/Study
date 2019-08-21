
public class Ex3 {

	public static void main(String[] args) {
		// 4-2. 매개변수가 2개 이상이고, 리턴값이 있는 메서드
		String snack = "새우깡";
		int money = 200;
		System.out.println("동생아! " + snack + "과 " + money + "원 가지고 가서 쿠쿠다스로 바꿔온나");
		
		snack = sister4_2(snack, money);
		
		System.out.println("동생이 준 것 : " + snack);
		
		System.out.println("------------------------");
		
		// 4-3. 매개변수가 배열이고, 리턴값이 있는 메서드
		// 정수가 저장된 배열을 전달받아 최대값을 리턴하는 메서드 maxArr()
		int[] nums = {100, 50, 80, 30, 140};
		int max = maxArr(nums);
		System.out.println("최대값 : " + max);
		
	}
	
	// 4-2. 매개변수가 2개 이상이고, 리턴값이 있는 메서드
	public static String sister4_2(String snack, int money) {
		System.out.println("오빠가 " + snack + ", " + money + "원을 쿠쿠다스로 바꿔오라고 시켰다!");
		snack = "쿠쿠다스";
		return snack;
	}
	
	// 4-3. 매개변수가 배열이고, 리턴값이 있는 메서드
	public static int maxArr(int[] arr) { // 정수형 배열을 전달받음
		int max = arr[0]; // 배열의 첫번째 데이터를 미리 변수에 저장
		
		for(int i = 1; i < arr.length; i++) { // 2번째 배열 데이터(1번 인덱스) 부터 비교
			if(arr[i] > max) { // 최대값 비교하여 기존 최대값보다 배열 데이터가 클 경우
				max = arr[i]; // 최대값 교체
			}
		}
		
		return max;
		
	}
	

}

















