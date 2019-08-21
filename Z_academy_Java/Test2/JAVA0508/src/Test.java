
public class Test {

	public static void main(String[] args) {
		/*
		 * 학생 5명의 과목별 점수를 저장하는 배열(score) 생성 및 사용
		 * 
		 *   < 출력 형태 >
		 *          자바   JSP   Oracle
		 * 홍길동   100     50     50   
		 * 이순신    80     80     80
		 * 강감찬    60     50     80
		 * 김태희   100    100    100
		 * 정우성    77     80     80
		 * 
		 */
		
		int[][] score = new int[5][3];
		
		score[0][0] = 100; score[0][1] = 50; score[0][2] = 50;
		score[1][0] = 80; score[1][1] = 80; score[1][2] = 80;
		score[2][0] = 60; score[2][1] = 50; score[2][2] = 80;
		score[3][0] = 100; score[3][1] = 100; score[3][2] = 100;
		score[4][0] = 77; score[4][1] = 80; score[4][2] = 80;
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
//				System.out.print(score[i][j] + " ");
				System.out.printf("%3d ", score[i][j]);
			}
			
			System.out.println();
		}
		
	}

}




















