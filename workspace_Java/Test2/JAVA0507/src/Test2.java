
public class Test2 {

	public static void main(String[] args) {
		/*
		 * 학생 점수를 저장할 1차원 배열(score), 과목명을 저장할 1차원 배열(subject)을 생성하여 
		 * 다음과 같이 출력되도록 초기화하고, 총점(total) 및 평균(avg)을 계산하여 출력하시오.
		 * 
		 * < 출력 결과 >
		 * Java : 100점
		 * JSP : 50점
		 * HTML : 80점
		 * Oracle : 100점
		 * Android : 77점
		 * --------------
		 * 총점 : 407점
		 * 평균 : 81.4점
		 */
		
		String[] subject = {"Java", "JSP", "HTML", "Oracle", "Android"};
		int[] score = {100, 50, 80, 100, 77};
		
		int total = 0; // 총점(반복문 내에서 계산)
		
		for(int i = 0; i < score.length; i++) {
			System.out.println(subject[i] + " : " + score[i] + "점");
			
			total += score[i];
		}
		
//		double avg = total / subject.length; // 평균(int / int = int 이므로 소수점 계산 불가)
		double avg = (double)total / subject.length; // 둘 중 하나라도 double 형으로 형변환해서 계산 필요!
		
		System.out.println("-------------");
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + avg + "점");
		
	}

}
















