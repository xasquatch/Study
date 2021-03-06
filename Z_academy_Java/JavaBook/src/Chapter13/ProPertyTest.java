package Chapter13;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ProPertyTest {

	public static void main(String[] args) {
		Properties props = System.getProperties();
		Set<Object> keys = props.keySet();

		System.out.println("key					props.get(key)");
		for (Object key : keys) {
			System.out.printf("%s\t\t\t\t\t%s\n",key,props.get(key));
		}
		String is = System.getProperty("java.io.tmpdir");
		System.out.println("사용자 임시 디렉터리 경로: "+is);
		
		Map<String, String> envs = System.getenv();
		Set<String> envKeys = envs.keySet();
		for (String key : envKeys) {
			System.out.printf("key : %s, value: %s%n",key,envs.get(key));
			
		}
		String userName = System.getenv("userName");
		System.out.println("사용자명 : "+ userName);
	}

}
