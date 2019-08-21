package Chapter7;

public class SpiderManTest2 {
	public static void main(String[] args) {
		SpiderMan2 sman = new SpiderMan2();
		System.out.println("거미모드로 변신");
		sman.isSpider = true;
		sman.jump();

		System.out.println("사람모드로 변신");
		sman.isSpider = false;
		sman.jump();
	}

}
