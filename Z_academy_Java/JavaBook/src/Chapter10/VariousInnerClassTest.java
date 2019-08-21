package Chapter10;

interface InfoPrintable {
	public void printInfo();
}

public class VariousInnerClassTest {

	public void useInnerClass(InfoPrintable inner) {
		inner.printInfo();
	}

	public void useSpeakerTest() {
		useInnerClass(new InfoPrintable() {
			public void printInfo() {
				System.out.println("�͸��� ���� Ŭ����");
			}
		});
				class EngSpeaker implements InfoPrintable {
					public void printInfo() {
						System.out.println("���� ���� Ŭ����");
					}
				}
		useInnerClass(new EngSpeaker());
		useInnerClass(new InstanceInnerClass());
	}

	class InstanceInnerClass implements InfoPrintable {

		@Override
		public void printInfo() {
			System.out.println("�ν��Ͻ� ���� Ŭ���� �̿�");
		}

	}
}

class SomeClass implements InfoPrintable {

	@Override
	public void printInfo() {
		System.out.println("���� ���Ͽ� ���� �� �Ϲ� Ŭ����");
	}

	public static void main(String[] args) {
	}

}