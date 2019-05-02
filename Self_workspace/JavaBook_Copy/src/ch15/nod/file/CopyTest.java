package ch15.nod.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {

	public static void main(String[] args) {
		File src = new File("C:"+File.separator+"Windows"+File.separator+"explorer.exe");
		File target = new File("C:"+File.separator+"Temp"+File.separator+"explorer.exe");
		
		try (FileInputStream input = new FileInputStream(src);
				FileOutputStream output = new FileOutputStream(target)){
			byte[] buffer = new byte[100];
			int read = 0;
			while ((read = input.read(buffer)) >0) {
				output.write(buffer,0,read);
			}
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
