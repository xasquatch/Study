package ch08.enume;

enum Family{
	FATHER("�ƺ�"),MOTHER("����"),SON("�Ƶ�"),DAUGHTER("��");
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
		cu.setKor("����");
		System.out.println(cu+" , "+cu.getKor());
	}

}
