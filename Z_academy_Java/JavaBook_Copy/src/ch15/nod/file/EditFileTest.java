package ch15.nod.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class EditFileTest {

	public static void main(String[] args) {
		File target = new File("C:"+File.separator+"Temp"+File.separator+"diary.txt");
		
		try(Scanner sc = new Scanner(System.in);
			FileWriter writer = new FileWriter(target,true);
			FileReader reader = new FileReader(target);){
			
			writer.write("\n½ÃÀÛ - " + new Date() + "\r\n");
			String str = null;
			while (true) {
				str = sc.nextLine();
				if (str.equals("x")) {
					break;
				} else {
					writer.write(str + "\r\n");
				}
			}
			writer.flush();
			
			
			char[] buffer = new char[10];
			int read = -1;
			while ((read = reader.read(buffer)) > 0) {
				System.out.print(String.valueOf(buffer,0,read));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
