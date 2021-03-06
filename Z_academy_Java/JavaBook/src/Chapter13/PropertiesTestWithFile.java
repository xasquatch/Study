package Chapter13;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

public class PropertiesTestWithFile {

	private final static String PROP_FILE_PATH = "./config.properties";
	
	private static void saveToFile() {
		Properties ps = new Properties();
		ps.setProperty("id", "andy");
		ps.setProperty("pass", "1234");
		ps.setProperty("addr", "192.168.0.2");
		ps.setProperty("이름", "홍길동");
		System.out.println("속성 확인 : "+ ps);
		try(FileWriter output = new FileWriter(PROP_FILE_PATH)) {
			ps.store(output, "System Config");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	private static void loadFromFile() {
		Properties props = new Properties();
		try(FileReader input = new FileReader(PROP_FILE_PATH)){
			props.load(input);
			Set<String> keys = props.stringPropertyNames();
			for (String key : keys) {
				System.out.println(key+":"+props.getProperty(key));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		saveToFile();
		loadFromFile();
	}

}
