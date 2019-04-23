package ch11.string;

class RegexpTest{

	public RegexpTest() {
		String str="Hello Java World";
		String [] splitResult = str.split("[a ]");
			for (int i = 0; i < splitResult.length; i++) {
				System.out.println(i+":"+splitResult[i]);
			}
		String nameRule = "[a-zA-Z°¡-ÆR]{2,5}";
		
		System.out.println("Hello Java".matches(nameRule));
		System.out.println("È«±æµ¿".matches(nameRule));
		System.out.println("È«±æµ¿2".matches(nameRule));
	}
	
}

public class Trim$Regexp {

	public static void main(String[] args) {
		RegexpTest test1 = new RegexpTest();
		System.out.println();

	}

}
