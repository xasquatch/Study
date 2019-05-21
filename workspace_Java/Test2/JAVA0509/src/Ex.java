
public class Ex { // Ex 클래스 시작

	public static void main(String[] args) { // main() 메서드 시작
		/*
		 * 로컬 변수(지역 변수)
		 * - 메서드의 바디{} 내에 선언된 변수
		 * - 메서드 내에서 선언된 후 메서드가 종료될 때(중괄호가 끝날 때) 변수도 제거됨
		 * - main() 메서드 내에서 선언된 변수는 main() 메서드가 끝날 때 제거됨
		 * - main() 메서드 내 for문 등의 문장 내(초기식 부분 포함)에서 선언된 변수는
		 *   해당 문장이 끝날 때 제거됨
		 */
		
//		System.out.println(a); // 로컬 변수 선언보다 윗쪽에서 변수에 접근할 수 없다! (없는 변수!)
		
		int a = 10; // 현재 위치에서 생성되며, main() 메서드가 끝날 때 제거됨
		// => main() 메서드 끝나기 전까지 메서드 내 선언 위치 이후의 어디서든 접근 가능
		System.out.println("a = " + a);
		
		
		for(int i = 0; i < 5; i++) { // for문 시작 
			// 로컬 변수 i는 for문이 시작될 때 생성되며, for문이 끝날 때 제거됨
			System.out.println("i = " + i);
		} // for문 종료(로컬변수 i가 제거됨)
		
//		System.out.println("i = " + i); // 로컬변수 i는 존재하지 않는 변수이므로 오류 발생!
		
		System.out.println("------------");
		int j;
		
		// 로컬 변수 j는 for문이 시작되기 전 생성되며, for문이 끝난 후에도 제거되지 않음
		for(j = 0; j < 5; j++) { // for문 시작 
			System.out.println("j = " + j);
		} // for문 종료
		
		System.out.println("j = " + j); // 로컬변수 j는 존재하므로 변수 접근 가능
		
		
		System.out.println("a = " + a); // 로컬 변수 선언보다 아래쪽에서 변수 접근 가능
		
	} // main() 메서드 끝

} // Ex 클래스 끝
