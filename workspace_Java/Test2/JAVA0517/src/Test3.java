
public class Test3 {

	public static void main(String[] args) {

		StudaCard card1 = new StudaCard(3, false);
		StudaCard card2 = new StudaCard();

		System.out.println(card1.info());
		System.out.println(card2.info());

	}

}

class StudaCard {
	int num;
	boolean isKwang; // is 판별할때사용

	public StudaCard() {
		num = 1;
		isKwang = true;
	}

	public StudaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String info() { // num 과 isKwang을 하나로 출력하므로 String 타입 리턴
		if (isKwang) {
			return num + "K";
		} else {// isKwang == false 일때
			return num + ""; // 리턴타입이 Strung 이므로 널스트링("") 값을 더하여 문자열로 변한
		}

	}

}
