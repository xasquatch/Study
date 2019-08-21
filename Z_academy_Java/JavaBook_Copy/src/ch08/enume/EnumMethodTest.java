package ch08.enume;

enum Tea{
	COFFEEE, BLACK_TEA, GREEN_TEA
}

public class EnumMethodTest {

	

	public static void main(String[] args) {
		Tea[] teaArray = Tea.values();
		for (Tea tea : teaArray) {
			String strName = tea.name();
			System.out.printf("이름 : %s%n",tea);
			System.out.printf("등장순서 : %d%n",tea.ordinal());
			Tea reTea = Tea.valueOf(strName);
			System.out.println(reTea.equals(tea));
			System.out.println(reTea.name());
		}

	}

}
