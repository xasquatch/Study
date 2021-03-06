package Chapter15;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelTest {

	public void writeToFile() {
		Path srcPath = Paths.get("C:"+File.separator+"Temp"+File.separator+"byChannel.txt");
		Charset utf8 = Charset.forName("utf-8");
			try(FileChannel writeChannel = FileChannel.open(srcPath, StandardOpenOption.CREATE,StandardOpenOption.WRITE);) {
				
				String src = "안녕 FileChannel. 일반 I/O 대비 쉽나요?";
				ByteBuffer bBuffer = utf8.encode(src);
				
				int byteCnt = writeChannel.write(bBuffer);
				System.out.println(byteCnt+"byte 출력완료");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void copyFile() {
		Path srcPath = Paths.get("C:"+File.separator+"Temp"+File.separator+"byChannel.txt");
		Path targetPath = Paths.get("C:"+File.separator+"Temp"+File.separator+"byChanne2.txt");
			try(FileChannel readChannel = FileChannel.open(srcPath, StandardOpenOption.WRITE);
					FileChannel writeChannel = FileChannel.open(targetPath,StandardOpenOption.CREATE,StandardOpenOption.WRITE);) {
				
				int read = -1;
				ByteBuffer readbuffer = ByteBuffer.allocate(20);
				while ((read = readChannel.read(readbuffer))>0) {
					readbuffer.flip();
					writeChannel.write(readbuffer);
					readbuffer.clear();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	
	public static void main(String[] args) {
		FileChannelTest fct = new FileChannelTest();
		fct.writeToFile();
		fct.copyFile();
		
	
	}

}
