package chapter5;

public class SimpleIntiTest {

	public static void main(String[] args) {
	
		char[][] charArr2Dim = {
									{'H','E','L','L','O'},
									{'J','A','V','A'},
									{'W','O','R','L','D'}
							};
		for(int i = 0; i < charArr2Dim.length; i++) {
			for(int j = 0; j < charArr2Dim[i].length; j++) {
				System.out.print(charArr2Dim[i][j]);
			}
			System.out.println();		}
		
	}

}
