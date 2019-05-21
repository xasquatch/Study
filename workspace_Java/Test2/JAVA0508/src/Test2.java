
public class Test2 {

	public static void main(String[] args) {
		/*
		 * 학생 5명의 과목별 점수를 저장하는 배열(score)을 생성하고
		 * 학생별 총점(studentTotal) 과목별 점수(subjectTotal) 계산
		 * 
		 *      < 출력 형태 >
		 * -----------------------------
		 *          자바   JSP   Oracle
		 * 홍길동   100     50     50   
		 * 이순신    80     80     80
		 * 강감찬    60     50     80
		 * 김태희   100    100    100
		 * 정우성    77     80     80
		 * =============================
		 * < 학생별 총점 >
		 * 홍길동 : 200점  
		 * 이순신 : 240점
		 * 강감찬 : 190점
		 * 김태희 : 300점
		 * 정우성 : 237점
		 * =============================
		 * < 과목별 총점 >
		 * 자바 : 417점
		 * JSP : 360점
		 * Oracle : 390점 
		 */
		
		// 1차원 배열 studentName 을 생성하여 학생 이름 5개 저장
		// 1차원 배열 subjectName 을 생성하여 과목명 3개 저장
		// 1차원 배열 studentTotal 을 생성하여 학생별 총점 5개 저장
		// 1차원 배열 subjectTotal 을 생성하여 과목별 총점 3개 저장
		int[][] score = {
				{100, 50, 50},
				{80, 80, 80},
				{60, 50, 80},
				{100, 100, 100},
				{77, 80, 80}
		};
		
		String[] studentName = {"홍길동", "이순신", "강감찬", "김태희", "정우성"};
		String[] subjectName = {"자바", "JSP", "Oracle"};
		
		System.out.printf("        %s   %s  %s\n", subjectName[0], subjectName[1], subjectName[2]);
		
		for(int i = 0; i < score.length; i++) { // 행 반복(1명의 학생별로 반복)
			
			System.out.print(studentName[i] + "   "); // 학생 이름 출력
			
			for(int j = 0; j < score[i].length; j++) { // 열 반복(1개의 과목별로 반복)
				
				System.out.printf("%3d   ", score[i][j]); // 점수 출력
				
			}
			
			System.out.println();
		}
		
		System.out.println("======================");
		
		/*
		 * 학생별 총점 계산
		 * 홍길동 학생의 점수 : 0,0  0,1  0,2  => studentTotal 0번 인덱스에 저장
		 * 이순신 학생의 점수 : 1,0  1,1  1,2  => studentTotal 1번 인덱스에 저장
		 * 강감찬 학생의 점수 : 2,0  2,1  2,2  => studentTotal 2번 인덱스에 저장
		 * 김태희 학생의 점수 : 3,0  3,1  3,2  => studentTotal 3번 인덱스에 저장
		 * 정우성 학생의 점수 : 4,0  4,1  4,2  => studentTotal 4번 인덱스에 저장
		 * => 공통점 : studentTotal 배열 인덱스 번호 = 학생 점수의 행번호와 동일
		 *    즉, 학생 점수의 행번를 제어하는 제어변수를 studentTotal 인덱스 번호로 사용
		 */
		int[] studentTotal = new int[5];
		
		for(int i = 0; i < score.length; i++) { // 행 반복(1명의 학생별로 반복)
			
			for(int j = 0; j < score[i].length; j++) { // 열 반복(1개의 과목별로 반복)
				
				studentTotal[i] += score[i][j]; // 학생 점수를 각 studentTotal에 누적
				// 학생 점수 인덱스 중 행번호에 해당하는 제어변수 i를
				// 총점을 저장하는 studentTotal 인덱스 번호로 사용하면
				// 각 학생별 총점 계산이 가능하다!
			}
			
		}
		
		// 학생별 총점 출력
		System.out.println("< 학생별 총점 >");
		for(int i = 0; i < studentTotal.length; i++) {
			System.out.println(studentName[i] + " : " + studentTotal[i] + "점");
		}
		
		System.out.println("=======================");
		
		/*
		 * 과목별 총점 계산
		 * 자바   : 0,0  1,0  2,0  3,0  4,0 => subjectTotal 의 0번에 저장
		 * JSP    : 0,1  1,1  2,1  3,1  4,1 => subjectTotal 의 1번에 저장
		 * Oracle : 0,2  1,2  2,2  3,2  4,2 => subjectTotal 의 2번에 저장
		 * => subjectTotal 배열 인덱스 번호 = 학생 점수의 열번호
		 *    즉, 학생 점수 열번호를 제어하는 제어변수를 subjectTotal 인덱스 번호로 사용
		 */
		
		int[] subjectTotal = new int[3];
		
		for(int i = 0; i < score.length; i++) { // 행 반복(1명의 학생별로 반복)
			
			for(int j = 0; j < score[i].length; j++) { // 열 반복(1개의 과목별로 반복)
				
				subjectTotal[j] += score[i][j]; // 학생 점수를 각 studentTotal에 누적
			}
			
		}
		
		System.out.println("< 과목별 총점 >");
		for(int i = 0; i < subjectTotal.length; i++) {
			System.out.println(subjectName[i] + " : " + subjectTotal[i] + "점");
		}
		
		
		System.out.println("==========================");
		// 학생별 총점과 과목별 총점을 한꺼번에 계산
		for(int i = 0; i < score.length; i++) { // 행 반복(1명의 학생별로 반복)
			
			for(int j = 0; j < score[i].length; j++) { // 열 반복(1개의 과목별로 반복)
				
				studentTotal[i] += score[i][j]; // 학생 점수를 각 studentTotal에 누적
				subjectTotal[j] += score[i][j]; // 학생 점수를 각 studentTotal에 누적
			}
			
		}
		
		
	}

}






















