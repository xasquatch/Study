package Chapter7;

class Bookbase{
	
	int price;
	String title, author;
	String test;
	public char[] toString;
	
	Bookbase(int price,String title,String author){
		this.price = price;
		this.title = title;
		this.author = author;
	
		this.test = "String ��� : "+price+" "+" "+title+" "+" "+author;
		
	}
}

public class Book{
	
	public static void main(String[] args) {
		
		Bookbase[] Books = new Bookbase[3];
			Books[0] = new Bookbase(20000,"java7","�ΰ��");
			Books[1] = new Bookbase(2500,"������ȣ","������");
			Books[2] = new Bookbase(12000,"������","������");

		for(Bookbase sysbook : Books) {
			System.out.println(sysbook.price+" "+" "+sysbook.title+" "+" "+sysbook.author);
		}
		
		System.out.println();
		
		for(Bookbase sys : Books) {
			System.out.println(sys.test);
		}
		
		System.out.println();
		
		for(Bookbase sysbook : Books) {
			System.out.println(sysbook);
		}
	}
}
