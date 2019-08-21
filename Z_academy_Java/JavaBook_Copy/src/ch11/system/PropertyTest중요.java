package ch11.system;

import java.util.Map;
import java.util.Set;

public class PropertyTest중요 {

	public static void main(String[] args) {
//		Properties props = System.getProperties();
//		Set keys = props.keySet();
//		for (Object key : keys) {
//			System.out.printf("key : %s\t\t\t, value : %s%n",key,props.get(key));
//		}
		String is = System.getProperty("java.io.tmpdir");
		System.out.println("임시 디렉터리 경로"+is);
		
		Map<String,String> envs = System.getenv();
		Set<String> envKeys = envs.keySet();
		for (String key : envKeys) {
			System.out.printf("key : %s\t, value : %s%n",key,envs.get(key));
		}
		
	}

}
