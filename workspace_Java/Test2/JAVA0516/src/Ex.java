
public class Ex {

	public static void main(String[] args) {
		WalkTestBad wtb = new WalkTestBad();
		wtb.walk();
		wtb.walk(100);
		wtb.walk(100, "cm");
		wtb.walk(100, "inch");
		wtb.walk(100, "m");
		// => 어떤 메서드를 호출하더라도 출력문은 동일하다! (출력문 코드의 중복 발생)
		
		System.out.println("-----------------");
		
		WalkTestGood wtg = new WalkTestGood();
		wtg.walk();
		wtg.walk(100);
		wtg.walk(100, "cm");
		wtg.walk(100, "inch");
		wtg.walk(100, "m");
	}

}

class WalkTestGood {
	public void walk() {
		// 같은 클래스의 다른 메서드를 호출하여 작업을 대신 수행할 수 있다!
		walk(100, "cm"); // 100, cm 데이터를 매개변수로 전달하여 대신 출력
	}
	
	public void walk(int distance) {
		walk(distance, "cm"); // 입력받은 거리(distance)와 cm 데이터를 매개변수로 전달
	}
	
	public void walk(int distance, String unit) {
		// switch~case 문을 사용하여 unit 변수값 비교("cm", "inch", 기타)
		switch(unit) {
			case "cm" :
				// 아무런 변환없이 switch~case 문 종료
				break;
			case "inch" :
				// 입력받은 distance 값을 cm 단위로 변환(1 inch = 2.54 cm)
				distance *= 2.54;
				break;
			default :
				System.out.println("Unknown");
				distance = 0;
		}
		
		System.out.println(distance + "cm 이동");
	}
	
}




class WalkTestBad {
	// 메서드 오버로딩을 활용한 걸음 측정
	public void walk() {
		System.out.println("100cm 이동");
	}
	
	public void walk(int distance) {
		System.out.println(distance + "cm 이동");
	}
	
	public void walk(int distance, String unit) {
		// switch~case 문을 사용하여 unit 변수값 비교("cm", "inch", 기타)
		switch(unit) {
			case "cm" :
				// 아무런 변환없이 switch~case 문 종료
				System.out.println(distance + "cm 이동");
				break;
			case "inch" :
				// 입력받은 distance 값을 cm 단위로 변환(1 inch = 2.54 cm)
				distance *= 2.54;
				System.out.println(distance + "cm 이동");
				break;
			default :
				System.out.println("Unknown");
				distance = 0;
		}
	}
	
}





















