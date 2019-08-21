package ch05.basic;

public class TimesTableArrayTest {

	public static void main(String[] args) {
		
		int[] timesTable = new int[9];
		for (int i = 0; i < timesTable.length; i++) {
			timesTable[i] = 3 * (i + 1);
		}
		System.out.println("¿Ï·á");
		for (int i : timesTable) {
			System.out.print(i+"\t");
		}
		System.out.println();
		
		int sum = 0;
		for (int i = 0; i < timesTable.length; i++) {
			if (i % 2 ==0) {
				sum += timesTable[i];
			}
		}
		System.out.println(sum);
	}

}
