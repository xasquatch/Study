package ch15.nod.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FileTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		
		String dirName = "C:"+File.separator+"Temp"+File.separator+"mydir";
		
		File file1 = new File(dirName);
		file1.mkdir();
		File file2 = new File(dirName,"test2.txt");
		file2.createNewFile();
		File file3 = new File(file1,"test3.txt");
		file3.createNewFile();
		File file4 = new File(new URI("file:///c:/Temp/test4.txt"));
		file4.createNewFile();
		
		file4.deleteOnExit();
			
		File file5 = new File("C:"+File.separator+"Temp"+File.separator+"mydir"+File.separator+"tlqkf"+File.separator+"xptmxm"+File.separator+"ektlqkfshadk");
		System.out.println(file5.mkdirs());
		
	}

}
