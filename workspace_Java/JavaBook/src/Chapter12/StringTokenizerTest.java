package Chapter12;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sc = "�̸�:ȫ�浿, JAva:100, HTML:80, Script:85";
		StringTokenizer tokens = new StringTokenizer(sc,":,");
		System.out.println(tokens.countTokens());
		int sum = 0;
		while (tokens.hasMoreElements()) {
			String token = null;
			try {
				token = tokens.nextToken();
				sum += Integer.parseInt(token);
			} catch (Exception e) {
				System.out.printf("���ھƴ� %s\t",token);
			}
		}
		System.out.printf("���� : %d ",sum);
	}

}
