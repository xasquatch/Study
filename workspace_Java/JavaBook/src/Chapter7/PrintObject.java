package Chapter7;

class UserInfo {
	String name = "ȫ�浿";
}

class MemberInfo extends UserInfo {

	String grade = "��ȸ��";

	@Override
	public String toString() {
		return "["+name+" "+ grade + "]";
	}
}

public class PrintObject {

	public static void main(String[] args) {
		Object member = new MemberInfo();
		System.out.println("��ü���� : "+member);

	}

}
