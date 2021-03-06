package Chapter16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class FromFile {

	public static void main(String[] args) throws IOException {
		Path current = Paths.get(".");
		BiPredicate<Path, BasicFileAttributes> matcher = (t,u) -> {
			return Files.isDirectory(t);
		};
		Stream<Path> pStream = Files.find(current, 1, matcher);
		pStream.forEach(System.out::println);
		pStream.close();
		
		Path pom = Paths.get("./pom.xml");
		Stream<String> lines = Files.lines(pom);
		System.out.println("�� ���: "+lines.count());
		lines.close();
	}

}
