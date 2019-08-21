package ch05.basic;

public class TimesTable2Dim {

	public static void main(String[] args) {
		int[][] gugu = new int[9][9];
		System.out.println(gugu.length);
		System.out.println(gugu[0].length);
		
		for (int i = 0; i < gugu.length; i++) {
			for (int j = 0; j < gugu[i].length; j++) {
				gugu[i][j] = (i+1)*(j+1);
			}
		}
		for (int i = 0; i < gugu.length; i++) {
			for (int k = 0; k < gugu.length; k++) {
				System.out.printf("%d\t",gugu[i][k]);
			}
			System.out.println();
		}
	}
}
