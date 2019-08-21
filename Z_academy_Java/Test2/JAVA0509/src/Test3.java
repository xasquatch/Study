
public class Test3 {

	public static void main(String[] args) {
		/*
		 * 배열의 정렬
		 * - 정수 5개를 저장한 배열을 전달받아
		 *   오름차순으로 정렬하여 정렬된 배열을 리턴하는 메서드 sort() 정의
		 * - 힌트 : 배열 데이터의 앞뒤로 비교하여 값 교환을 위해서는
		 *          옮길 데이터 둘 중 하나를 임시로 저장할 변수(temp 또는 tmp)가 필요
		 *   힌트2 : 가장 쉬운 알고리즘은
		 *           배열 0번 인덱스부터 4번 인덱스까지 반복할 동안
		 *           배열 0번부터 4번인덱스를 차례대로 비교하여 값 교환
		 *           (i가 0일 때 : j가 0 ~ 4까지)
		 *           (i가 1일 때 : j가 0 ~ 4까지)
		 *           (...)
		 *           (i가 4일 때 : j가 0 ~ 4까지)
		 * 
		 * ex) 정렬 전 배열 데이터 = 10, 50, 70, 30, 20 일 때
		 *     정렬 후 배열 데이터 = 10, 20, 30, 50, 70
		 */
		int[] num = {10, 50, 70, 30, 20};
		
		num = sort(num);
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
	}
	
	public static int[] sort(int[] arr) {
		int tmp; // swap 할 데이터를 저장할 변수
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] < arr[j]) { 
					tmp = arr[i]; // i번 데이터를 임시변수에 저장
					arr[i] = arr[j]; // j번 데이터를 i번에 저장
					arr[j] = tmp; // 임시변수 데이터를 j번에 저장
				}
			}
		}
		
		return arr;
		
	}
	
	
	

}
















