package ch10.nested;

interface InfoPrintable {
	public void printInfo();
}

public class VariousInnerClassTest {

	class InstanceInnerClass implements InfoPrintable {

		@Override
		public void printInfo() {
			System.out.println("�ν��Ͻ� ���� Ŭ���� �̿�");

		}

	}
	
	public void useInnerClass(InfoPrintable inner) {
		inner.printInfo();
	}

	public void useSpeakerTest() {
		useInnerClass(new InfoPrintable() {

			@Override
			public void printInfo() {
				System.out.println("�͸��� ����Ŭ����");
			}
		}// end - useInnerClass
		);
		class EngSpeaker implements InfoPrintable {

			@Override
			public void printInfo() {
				System.out.println("���� ���� Ŭ����");
			}

		}// end - EngSpeaker
		useInnerClass(new EngSpeaker());
		
		useInnerClass(new InstanceInnerClass());
	}// end - useSpeakerTest


	
	public static void main(String[] args) {
		VariousInnerClassTest vc = new VariousInnerClassTest();
		vc.useSpeakerTest();
		
	}
}
class SomeClass implements InfoPrintable{

	@Override
	public void printInfo() {
		System.out.println("�������Ͽ� ���� �� �Ϲ� Ŭ����");
		
	}
	
}


