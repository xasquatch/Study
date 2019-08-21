
public class Ex {

	public static void main(String[] args) {
		/*
		 * 2차원 배열
		 * - 다차원 배열은 2차원 이상의 모든 배열을 통칭하지만
		 *   일반적으로 2차원 배열까지만 사용
		 * - 행열의 형태로 표기하지만 실제 메모리 상의 형태는 다르다.
		 *   (열에 해당하는 공간에 실제 데이터가 저장되고, 행은 열의 위치(주소값)를 저장한다)
		 * - 배열명.length 속성 값은 행크기를 나타내며,
		 *   배열명[행번호].length 속성 값은 열크기(실제 데이터 저장 공간 크기)를 나타낸다.
		 * - 배열 생성 시 행크기(2차원배열크기)만 지정하고, 열크기는 생략할 수 있으며
		 *   차후에 각 열을 별도로 생성할 수 있다. 이 때, 열의 크기를 다르게 생성 가능하다.
		 * 
		 * < 2차원 배열 선언 기본 문법 >
		 * 데이터타입[][] 변수명;
		 * 
		 * < 2차원 배열 생성 기본 문법 >
		 * 변수명 = new 데이터타입[행크기][열크기];
		 * 
		 * < 2차원 배열 접근 및 초기화 기본 문법 >
		 * 변수명[행번호][열번호] = 데이터;
		 * 
		 */
		
		int[][] arr; // 2차원 배열 선언
		
		// 2차원 배열 생성
//		arr = new int[2][]; // 앞의 대괄호(행크기)만 지정하면 문법 오류 사라짐
//		                    // => 단, 실제 데이터 저장 공간인 열은 생성되기 전
//		arr[0] = new int[3]; // arr 배열 0번 행에 3개의 열(데이터 저장공간) 생성
//		arr[1] = new int[3]; // arr 배열 1번 행에 3개의 열(데이터 저장공간) 생성
		
		arr = new int[2][3]; // 2행 3열 크기의 배열 생성
		
		// 2차원 배열 초기화(행번호 접근 -> 열번호 접근 -> 데이터 저장)
		arr[0][0] = 10; arr[0][1] = 20; arr[0][2] = 30;
		arr[1][0] = 40; arr[1][1] = 50; arr[1][2] = 60;
		
//		System.out.println(arr[0][0] + " " + arr[0][1] + " " + arr[0][2]);
//		System.out.println(arr[1][0] + " " + arr[1][1] + " " + arr[1][2]);
		
		// for문을 사용하여 2차원 배열에 접근(length 사용하지 않을 경우)
		// 주로 행크기를 지정하는 for문 내에 열크기를 지정하는 for문을 중첩해서 사용
		for(int i = 0; i < 2; i++) { // 행 반복
//			System.out.println("----------- i = " + i);
			
			for(int j = 0; j < 3; j++) { // 열 반복
//				System.out.println("j = " + j);
//				System.out.println(i + ", " + j);
//				System.out.println(arr[i][j]);
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("---------------------");
		System.out.println("2차원 배열 행 크기 : " + arr.length);
		System.out.println("2차원 배열 0번 행의 열 크기 : " + arr[0].length);
		System.out.println("2차원 배열 1번 행의 열 크기 : " + arr[1].length);
		
		// length 속성을 활용한 for문(기본 공식)
		for(int i = 0; i < arr.length; i++) { // 행 반복
			
			for(int j = 0; j < arr[i].length; j++) { // 열 반복
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}

}

















