package Chapter7;

import java.util.Date;

class Person2 {
	String name;
	Person2(String name) {
		this.name = name;
		System.out.println("person2(String name)场");
	}
}

public class SpiderMan3 extends Person2{

	Spider spider;
	boolean isSpider;
	
	SpiderMan3(String name,Spider spider, boolean isSpider){
		super(name);
		this.spider = spider;
		this.isSpider = isSpider;
		System.out.println("SpiderMan3(String name,Spider spider, boolean isSpider) 场");
	}
	
	SpiderMan3(String name){
		this(name,new Spider(),true);
		System.out.println("SpiderMan3(String name) 场");
	}
	
	public static void main(String[] args) {
		SpiderMan3 sman = new SpiderMan3("乔磐颇目");
		Date d = new Date();
		
		
	}

}
