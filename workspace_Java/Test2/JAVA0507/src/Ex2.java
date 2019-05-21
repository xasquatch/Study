
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * - 배열 선언과 동시에 리터럴로 배열을 초기화하면 자동으로 배열 생성까지 가능
		 * - 배열 생성 코드 대신 중괄호{} 를 사용하여 초기화할 배열 데이터를 
		 *   콤마(,)로 구분하여 중괄호 내에 기술
		 *   => 중괄호 내의 데이터 갯수 만큼 배열 공간이 자동으로 생성된 후 초기화됨
		 * 
		 * < 배열 선언 및 생성, 초기화를 동시에 수행하는 문법 >
		 * 데이터타입[] 변수명 = {데이터1, 데이터2, ..., 데이터n};
		 * => 총 n 개의 배열 공간이 자동으로 생성되고, 주어진 값으로 초기화 됨 
		 * 
		 */
		
		int[] a = {10, 20, 30}; // 정수형 배열 3칸 생성되면서, 10, 20, 30 으로 각각 초기화됨
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("----------------");
		
		// String 형 배열을 사용 5칸 생성 및 초기화
		String[] str = {"Java", "JSP", "HTML", "Oracle", "Android"};
		
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
	}

}


















