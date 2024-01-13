package Programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Files.lines(Paths.get("src/file.txt"))
		.map(str -> str.toUpperCase().split(" "))
		.flatMap(Arrays::stream)
		.forEach(System.out::println);
		
		Files.list(Paths.get(".")).forEach(System.out::println);
	}
	
	
}
