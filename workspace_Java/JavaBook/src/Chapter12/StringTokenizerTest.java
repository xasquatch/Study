package Chapter12;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sc = "ÀÌ¸§:È«±æµ¿, JAva:100, HTML:80, Script:85";
		StringTokenizer tokens = new StringTokenizer(sc,":,");
		System.out.println(tokens.countTokens());
		int sum = 0;
		while (tokens.hasMoreElements()) {
			String token = null;
			try {
				token = tokens.nextToken();
				sum += Integer.parseInt(token);
			} catch (Exception e) {
				System.out.printf("¼ýÀÚ¾Æ´Ô %s\t",token);
			}
		}
		System.out.printf("ÃÑÁ¡ : %d ",sum);
	}

}
