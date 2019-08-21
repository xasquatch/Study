
public class Test2 {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.plus(1, 2, 3, 4);
		c.minus(5, 3, 1);
		
		System.out.println("=================");
		
		Calculator2 c2 = new Calculator2();
		c2.calc('+', 1, 2, 3);
		c2.calc('+', 1, 2, 3, 4, 5);
		System.out.println("--------");
		c2.calc('-', 10, 4, 3);
		c2.calc('-', 10, 2, 3, 4, 5);
		System.out.println("--------");
		c2.calc('*', 1, 2, 3);
		c2.calc('*', 10, 2, 3, 4, 5);
		System.out.println("--------");
		c2.calc('/', 10, 2);
		c2.calc('/', 10, 2, 3);
		
		System.out.println("================");
		
		c2.calc('+');
		
		
	}

}

/*
 * Calculator2 클래스 정의
 * - calc() 메서드 오버로딩
 *   => 연산자(opr, 문자형)와 정수 x개 전달받음
 *      => 해당 연산자가 '+' 이면 덧셈, '-' 이면 뺄셈, '*' 이면 곱셈, '/' 이면 나눗셈을 수행하고
 *         그 외의 연산자가 입력되면 "연산자 입력 오류!" 출력하고 종료
 * ex) calc('+', 1, 2, 3, 4) 전달 시 : "1 + 2 + 3 + 4 = 10" 출력
 *     calc('-', 5, 3, 1) 전달 시 : "5 - 3 - 1 = 1" 출력
 *     calc('&', 1, 2, 3) 전달 시 : "연산자 입력 오류!" 출력
 */
class Calculator2 {
	
	public void calc(char opr, int...nums) {
		// 가변인자로 전달된 데이터가 아무것도 없을 경우 calc() 메서드 종료
		
		if(nums.length == 0) {
			System.out.println("계산할 데이터를 입력하세요!");
			return;
		}else if(nums.length == 1) {
			System.out.println("계산에 사용할 데이터를 2개 이상 입력하세요!");
			return;
		}
		
		
		int result = nums[0];
		
		System.out.print(nums[0]);
		
		if(opr == '+') {
			for(int i = 1; i < nums.length; i++) {
				result += nums[i];
				System.out.print(" + " + nums[i]);
			}
		} else if(opr == '-') {
			for(int i = 1; i < nums.length; i++) {
				result -= nums[i];
				System.out.print(" - " + nums[i]);
			}
		} else if(opr == '*') {
			for(int i = 1; i < nums.length; i++) {
				result *= nums[i];
				System.out.print(" * " + nums[i]);
			}
		} else if(opr == '/') {
			for(int i = 1; i < nums.length; i++) {
				result /= nums[i];
				System.out.print(" / " + nums[i]);
			}
		} else {
			System.out.println("연산자 입력 오류!");
			// 계산 결과를 출력할 필요 없이 현재 위치에서 calc() 메서드를 종료
			return;
		}
		
		System.out.println(" = " + result);
		
	}
	
}


/*
 * Calculator 클래스 정의
 * - plus() 메서드 오버로딩
 *   => 정수형 데이터 2개 ~ x개까지 전달받아 덧셈을 계산한 후 출력하도록 정의
 *   ex) plus(1, 2, 3, 4) 전달 시 : "1 + 2 + 3 + 4 = 10" 출력
 *       plus(1, 2, 3) 전달 시 : "1 + 2 + 3 = 6" 출력
 * - minus() 메서드 오버로딩
 *   => 정수형 데이터 2개 ~ x개까지 전달받아 뺄셈을 계산한 후 출력하도록 정의
 *   ex) minus(5, 3, 1) 전달 시 : "5 - 3 - 1 = 1" 출력
 *       minus(5, 3, 1, 2) 전달 시 : "5 - 3 - 1 - 2 = -1" 출력
 *       
 */
class Calculator {
	
	public void plus(int...nums) {
		int result = nums[0]; // 첫번째 숫자를 미리 결과값에 저장하여 연산 시작
		
		System.out.print(nums[0]);
		for(int i = 1; i < nums.length; i++) { // 두번째 숫자부터 계산
			result += nums[i];
			System.out.print(" + " + nums[i]);
		}
		
		System.out.println(" = " + result);
	}
	
	public void minus(int...nums) {
		int result = nums[0];

		System.out.print(nums[0]);
		for(int i = 1; i < nums.length; i++) {
			result -= nums[i];
			System.out.print(" - " + nums[i]);
		}
		
		System.out.println(" = " + result);
	}
	
}
















