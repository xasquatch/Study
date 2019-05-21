
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * < 2차원 배열 선언 및 생성, 초기화 동시에 수행하는 문법 >
		 * 데이터타입[][] 변수명 = { 
		 * 				{0행0열데이터, 0행1열데이터, ..., 0행n열데이터},
		 * 				{1행0열데이터, 1행1열데이터, ..., 1행n열데이터},
		 * 				.....생략.....
		 * 				{x행0열데이터, x행1열데이터, ..., x행n열데이터}
		 * }; 	
		 * 
		 * => 배열 전체를 중괄호로 둘러싸고
		 *    다시 각 행을 중괄호로 둘러싼 뒤 콤마로 구분함
		 *    행의 중괄호 내에서 각 열 데이터끼리도 콤마로 구분
		 * => 이 때, 열 데이터 크기에 따라 가변형태 배열로 생성할 수 있다.
		 * 				 
		 */
		
		int[][] arr = {
				{10, 20, 30}, // 0번 행{0열, 1열, 2열}
				{40, 50, 60}  // 1번 행{0열, 1열, 2열}
		};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("-----------------------");
		
		char[][] charArr2Dim = {
				{'H', 'E', 'L', 'L', 'O'},
				{'J', 'A', 'V', 'A'},
				{'W', 'O', 'R', 'L', 'D'},
		};
		
		for(int i = 0; i < charArr2Dim.length; i++) {
			for(int j = 0; j < charArr2Dim[i].length; j++) {
				System.out.print(charArr2Dim[i][j]);
			}
			
			System.out.println();
		}
		
	}

}





















