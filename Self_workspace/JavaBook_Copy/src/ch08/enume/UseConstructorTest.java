package ch08.enume;

enum Family{
	FATHER("아빠"),MOTHER("엄마"),SON("아들"),DAUGHTER("딸");
	private String kor;
	
	Family(String kor) {
		this.kor = kor;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}
	
	
	
}
public class UseConstructorTest {

	public static void main(String[] args) {

		Family cu = Family.MOTHER;
		System.out.println();
		System.out.println(cu+" , "+cu.getKor());
		cu.setKor("으메");
		System.out.println(cu+" , "+cu.getKor());
	}

}
