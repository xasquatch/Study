
public class Test {

	public static void main(String[] args) {
		/*
		 * 학생 5명의 점수를 저장할 배열 score 를 생성하여 데이터 저장 후 출력
		 * (=> 0번 인덱스부터 4번 인덱스까지 차례대로 100, 90, 50, 80, 70 데이터 저장)
		 * 
		 * < 출력 예시 >
		 * 1번 학생 : 100
		 * 2번 학생 : 90
		 * 3번 학생 : 50
		 * 4번 학생 : 80
		 * 5번 학생 : 70
		 */
		
		int[] score = new int[5];
		
		score[0] = 100;
		score[1] = 90;
		score[2] = 50;
		score[3] = 80;
		score[4] = 70;
		
		System.out.println("1번 학생 : " + score[0]);
		System.out.println("2번 학생 : " + score[1]);
		System.out.println("3번 학생 : " + score[2]);
		System.out.println("4번 학생 : " + score[3]);
		System.out.println("5번 학생 : " + score[4]);
		
		System.out.println("-------------------------");
		
		// 반복문(for문)을 사용하여 5개 점수 출력
		for(int i = 0; i <= 4; i++) { // 0 ~ 4 까지 1씩 증가하면서 반복 5회
			System.out.println((i + 1) + "번 학생 : " + score[i]);
		}
		
		System.out.println("------------------------");
		
		// length 속성을 활용한 반복문 사용
		for(int i = 0; i < score.length; i++) { // 0 ~ 4 까지 1씩 증가하면서 반복 5회
			System.out.println((i + 1) + "번 학생 : " + score[i]);
		}
		
		System.out.println("--------------------");
		
		/*
		 * char타입 배열 5개 생성
		 * 0번 배열 : 'A'
		 * 1번 배열 : 66
		 * 2번 배열 : 'C'
		 * 3번 배열 : 'D'
		 * 
		 * => 배열에 데이터 저장 후 반복문을 사용하여 모두 출력
		 */
		
		char[] chArr = new char[5];
		chArr[0] = 'A';
		chArr[1] = 66;
		chArr[2] = 'C';
		chArr[3] = 'D';
		
		for(int i = 0; i < chArr.length; i++) {
			System.out.println(i + "번 배열 : " + chArr[i]);
		}
		
	}

}


















