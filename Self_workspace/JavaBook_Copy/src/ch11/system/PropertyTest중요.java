package ch11.system;

import java.util.Map;
import java.util.Set;

public class PropertyTest�߿� {

	public static void main(String[] args) {
//		Properties props = System.getProperties();
//		Set keys = props.keySet();
//		for (Object key : keys) {
//			System.out.printf("key : %s\t\t\t, value : %s%n",key,props.get(key));
//		}
		String is = System.getProperty("java.io.tmpdir");
		System.out.println("�ӽ� ���͸� ���"+is);
		
		Map<String,String> envs = System.getenv();
		Set<String> envKeys = envs.keySet();
		for (String key : envKeys) {
			System.out.printf("key : %s\t, value : %s%n",key,envs.get(key));
		}
		
	}

}
