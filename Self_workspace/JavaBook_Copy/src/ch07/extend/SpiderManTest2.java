package ch07.extend;

public class SpiderManTest2{
	public static void main(String[] args) {
		SpiderMan2 sman = new SpiderMan2();
		System.out.println("����");
		sman.isSpider = true;
		sman.jump();
		
		System.out.println("�����");
		sman.isSpider = false;
		sman.jump();
	}
	
}
