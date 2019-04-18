package ch10.nested;

interface InfoPrintable {
	public void printInfo();
}

public class VariousInnerClassTest {

	class InstanceInnerClass implements InfoPrintable {

		@Override
		public void printInfo() {
			System.out.println("인스턴스 내부 클래스 이용");

		}

	}
	
	public void useInnerClass(InfoPrintable inner) {
		inner.printInfo();
	}

	public void useSpeakerTest() {
		useInnerClass(new InfoPrintable() {

			@Override
			public void printInfo() {
				System.out.println("익명의 내부클래스");
			}
		}// end - useInnerClass
		);
		class EngSpeaker implements InfoPrintable {

			@Override
			public void printInfo() {
				System.out.println("로컬 내부 클래스");
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
		System.out.println("같은파일에 있을 뿐 일반 클래스");
		
	}
	
}


