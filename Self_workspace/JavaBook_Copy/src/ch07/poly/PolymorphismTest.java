package ch07.poly;


import ch07.extend.Person;
import ch07.extend.SpiderMan;

public class PolymorphismTest {

	public static void main(String[] args) {

		SpiderMan sman = new SpiderMan();
		Person ps = sman;
		Object ob = sman;
		
		System.out.printf("sman==ps? %b%n",sman == ps);
		System.out.printf("sman==obj? %b%n",sman == ob);
		
	}

}
