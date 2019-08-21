package Chapter7;

public class SpiderMan2 extends Person {
	Spider spider = new Spider();
	boolean isSpider;

	public void fireWeb() {
		if (isSpider) {
			spider.fireWeb();
		} else {
			System.out.println("person은 거미줄 발사 불가");
		}
	}

	@Override
	public void jump() {
		if (isSpider) {
			spider.jump();
		} else {
//			System.out.println("뛰기");
			super.jump();
		}
	}

}
