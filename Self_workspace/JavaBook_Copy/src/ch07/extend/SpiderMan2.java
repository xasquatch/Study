package ch07.extend;

public class SpiderMan2 extends Person{
	
	Spider sp = new Spider();
	boolean isSpider;
	
	public void fireWeb() {
		if (isSpider) {
			sp.fireWeb();
		}else {
			System.out.println("Person�� �߻�Ұ�");
		}
	}

	@Override
	public void jump() {
		if(isSpider) {
			sp.jump();
		}else {
			System.out.println("�ٱ�");
		}
	}
	
	
}
