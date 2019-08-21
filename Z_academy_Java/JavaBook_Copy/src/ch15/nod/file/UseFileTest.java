package ch15.nod.file;

import java.io.File;
import java.util.Date;


public class UseFileTest {

	public static void main(String[] args) {
		File currentDir = new File(".");
		if (currentDir.exists()) {
			File[] childs = currentDir.listFiles();
			
			for (File child : childs) {
				Date time = new Date(child.lastModified());
				String name = child.getName();
				long length = child.length();
			
				if (child.isDirectory()) {
					name = "["+child.getName()+"]";
				}
				
				System.out.printf("%-20s\t%tF %<tT\t%s%n",name,time,length);
				System.out.printf("\n\n\n");
				System.out.println(name+"   ,    "+time+"       ,        "+length);
			}
		}

	}

}
