package Chapter7;

public class SpiderMan2 extends Person {
	Spider spider = new Spider();
	boolean isSpider;

	public void fireWeb() {
		if (isSpider) {
			spider.fireWeb();
		} else {
			System.out.println("person�� �Ź��� �߻� �Ұ�");
		}
	}

	@Override
	public void jump() {
		if (isSpider) {
			spider.jump();
		} else {
//			System.out.println("�ٱ�");
			super.jump();
		}
	}

}
