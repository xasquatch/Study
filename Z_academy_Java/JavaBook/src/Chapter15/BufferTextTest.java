package Chapter15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferTextTest {

	public static void main(String[] args) {

		File src = new File("./pom.xml");
		try(BufferedReader br = new BufferedReader(new FileReader(src)); ) {
			String line = null;
			while ((line = br.readLine()) != null ) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}