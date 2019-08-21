
public class Test4 {

	public static void main(String[] args) {
		/*
		 * 로또 번호 생성 프로그램
		 * - 1 ~ 45 사이의 "중복되지 않는 숫자" 6개를 배열 myLotto 에 저장 후 출력
		 */
		
		// 로또 번호 6개를 저장할 정수형 배열 myLotto 생성
		int[] myLotto = new int[6];
		
		
		// 1 ~ 45 사이의 난수를 생성하여 배열 myLotto 에 저장
		// 단, 중복되는 숫자가 발생할 경우 
		// 배열에 숫자를 저장하고 저장할 위치값을 -1 하거나
		// 배열에 숫자를 저장하지 않고 새로운 난수 발생
		
		
		// myLotto 배열 내의 저장된 숫자 6개 모두 출력
		System.out.print("이번주 로또 번호 : ");
		for(int i = 0; i < myLotto.length; i++) {
			System.out.print(myLotto[i] + " ");
		}
		
	}

}
