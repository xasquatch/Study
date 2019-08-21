package Chapter7;

class UserInfo {
	String name = "È«±æµ¿";
}

class MemberInfo extends UserInfo {

	String grade = "Á¤È¸¿ø";

	@Override
	public String toString() {
		return "["+name+" "+ grade + "]";
	}
}

public class PrintObject {

	public static void main(String[] args) {
		Object member = new MemberInfo();
		System.out.println("°´Ã¼Á¤º¸ : "+member);

	}

}
