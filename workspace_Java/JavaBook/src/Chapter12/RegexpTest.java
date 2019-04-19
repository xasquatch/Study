package Chapter12;

import java.text.MessageFormat;
import java.util.regex.Pattern;

public class RegexpTest {

	public static void main(String[] args) {

		String regexp = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}";
		String[] nums = {
				"010-000-1234",
				"01112345678",
				"010)1234 5678",
				"010 1234 567a"};
		String resultPattern = "{0}�� ��ȭ��ȣ Ÿ���ΰ�? {1}";
		for (String num : nums) {
			boolean result = Pattern.matches(regexp, num);
			System.out.println(MessageFormat.format(resultPattern, num, result));
		}
	}

}
