package ch15.nod.basic;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriterTest {

	public static void main(String[] args) {
		try (Writer wt = new OutputStreamWriter(System.out)){
			String msg = "java hello wow";
			wt.write(msg);
			
			
			wt.append("java").append("world");
			System.out.println("-----------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
