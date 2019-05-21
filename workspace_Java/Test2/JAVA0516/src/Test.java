
public class Test {

	public static void main(String[] args) {
		Exchange e = new Exchange();
		
		e.change(); // 1달러에 대한 원화 계산하여 출력
		e.change(10); // 10달러에 대한 원화 계산하여 출력
		e.change(100, "JPY"); // 100엔(JPY)에 대한 원화 계산하여 출력
		
	}

}

/*
 * 환율 계산 클래스(Exchange) 정의(메서드 오버로딩) - 달러(USD), 엔(JPY), 위안(CNY)
 * - 입력받은 금액에 대한 원화 금액을 실수 형태로 계산하여 출력하는 메서드 change() 정의
 *   1. 매개변수가 아무것도 없는 change() 메서드 => 1달러 = X원 출력
 *      ex) change() 호출 시 : 1달러 = 1180원 출력
 *   2. 매개변수가 정수형 1개(x)인 change(int) 메서드 => x달러 = X원 출력(x = 금액)
 *      ex) change(10) 호출 시 : 10달러 = 11800원 출력
 *   3. 매개변수가 정수형 1개(x), 문자열 1개(type)인 change(int, String) 메서드
 *      => x 금액만큼의 type = X원 출력(x = 금액, type = 해당 국가 통화)
 *      ex) change(10, "JPY") 호출 시 : 10엔 = 108원
 */
class Exchange {
	double usd1 = 1189.60; // 1달러 당 원 환율
	double jpy1 = 10.87; // 1엔 당 원 환율
	double cny1 = 172.15; // 1위안 당 원 환율
	
	public void change() {
//		System.out.println("1달러 : " + usd1 + "원");
		change(1, "USD");
	}
	
	public void change(int x) {
		// x달러에 대한 원 환율 출력
//		System.out.println(x + "달러 : " + (usd1 * x) + "원");
		change(x, "USD");
	}
	
	public void change(int x, String type) {
		// x 금액만큼 type 통화에 대한 원 환율 출력
		String typeName = ""; // 통화 이름 저장할 변수
		double result = 0.0; // 환율 계산 결과 저장할 변수
		
		switch(type) {
			case "USD" :
//				System.out.println(x + "달러 : " + (usd1 * x) + "원");
				typeName = "달러";
				result = usd1 * x;
				break;
			case "JPY" :
//				System.out.println(x + "엔 : " + (jpy1 * x) + "원");
				typeName = "엔";
				result = jpy1 * x;
				break;
			case "CNY" :
//				System.out.println(x + "위안 : " + (cny1 * x) + "원");
				typeName = "위안";
				result = cny1 * x;
				break;
			default :
				typeName = "Unknown";
				result = 0;
		}
		
		// 하나의 출력문으로 모든 경우 출력
		System.out.println(x + typeName + " : " + result + "원");
	}
	
}



















