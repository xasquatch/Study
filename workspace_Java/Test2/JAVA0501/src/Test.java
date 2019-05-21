
public class Test {

	public static void main(String[] args) {
		int score = 5;
		String grade = "";
		
		// 점수(score)가 정상 범위일 때만 학점 계산을 수행하고
		// 정상 범위가 아닐 때는 오류 메시지를 출력
		if(score >= 0 && score <= 100) { // 점수가 0 ~ 100 사이일 경우
			// 이미 점수는 0 ~ 100 사이이므로 정상 범위 이내
			if(score >= 90) { // 90점 이상이므로 90 ~ 100 사이의 점수가 해당됨
				grade = "A";
			} else if(score >= 80) {
				// 이미 위의 if 문에서 90 이상이 아니므로 자동으로 80 ~ 89 사이 점수가 해당됨
				grade = "B";
			} else if(score >= 70) {
				grade = "C";
			} else if(score >= 60) {
				grade = "D";
			} else { // 59점 이하의 모든 점수이므로 0 ~ 59 사이의 점수가 해당됨
				grade = "F";
			}
			
			System.out.println(score + "는 " + grade + " 학점입니다!");
		} else { // 점수가 0 ~ 100 사이가 아닐 경우
			System.out.println("점수 입력 오류!");
		}
		
		/*
		 * switch ~ case 문을 사용하여 학점에 따른 메세지 출력
		 * 학점(grade)이 "A" 일 때, "수" 출력
		 * 학점(grade)이 "B" 일 때, "우" 출력
		 * 학점(grade)이 "C" 일 때, "미" 출력
		 * 학점(grade)이 "D" 일 때, "양" 출력
		 * 학점(grade)이 "F" 일 때, "가" 출력
		 */
		switch(grade) {
			case "A" : System.out.println("수"); break;
			case "B" : System.out.println("우"); break;
			case "C" : System.out.println("미"); break;
			case "D" : System.out.println("양"); break;
			case "F" : System.out.println("가");
		}
		
		System.out.println("============================");
		
		// switch ~ case 문을 사용한 학점 계산
		// => case 문에 범위 지정이 불가능하므로 점수 범위에 따른 학점 지정은 불가!
		switch(score) {
			case 100 : grade = "A"; break;
			case 99 : grade = "A"; break;
			case 98 : grade = "A"; break;
			case 97 : grade = "A"; break;
			// .....
			case 90 : grade = "A"; break;
			case 89 : grade = "B"; break;
			// .....
			case 1 : grade = "F"; break;
			case 0 : grade = "F"; break;
		}
		// => 효율적이지 못한 문장
		
		System.out.println("-------------------");
		
		// switch 문에서 점수별 판별을 위해서는
		// score / 10 의 연산을 통해 각 점수대를 계산해야한다!
		score = 91;
		
		System.out.println(score % 10);

		switch(score / 10) {
			case 10 : // grade = "A"; break; 문장은 생략 가능 => case 9에서 동일한 처리를 수행
			case 9 : grade = "A"; break;
			case 8 : grade = "B"; break;
			case 7 : grade = "C"; break;
			case 6 : grade = "D"; break;
			default : grade = "F";
		}
		
		System.out.println(score + " : " + grade + " 학점입니다!");
		
		
		System.out.println("==========================");
		
		String levelString = "";
		String level = "운영자";
		
		switch(level) {
			case "관리자" : levelString += "운영자관리 ";
			case "운영자" : levelString += "회원관리 ";
			case "회원" : levelString += "글쓰기 ";
			default : levelString += "보기 ";
		}

		System.out.println("당신의 권한은 : " + levelString);
		
		System.out.println("====================================");
		
		int month = 9;
		int days = 0;
		
		switch(month) {
			case 2 : 
				days = 28; 
				break;
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				days = 30;
				break;
			default : 
				days = 31;
		}
		
		System.out.printf("%d월은 %d일까지 있습니다.", month, days);
		
		
	}

}






















