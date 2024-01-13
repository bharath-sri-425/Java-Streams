package Programming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FP04FunctionalProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> listStr=List.of("Spring","SpringBoot","SpringBoot","Kubernetes","Java","python");

		//Join the string with the help of comma
		System.out.println(listStr.stream().collect(Collectors.joining(",")));
		
		String[] str="Spring".split("");
			for(String s: str)
				System.out.println(s);
			
			//list of string its splitted and converted to array stream and saved to list
			System.out.println(listStr.stream().map(c -> c.split("")).flatMap(Arrays::stream).distinct().sorted().collect(Collectors.toList()));
		
			
			List<String> listStr2=List.of("Spring","SpringBoot","SpringBoot","Kubernetes","Java","python");
			//joining the list with the same length
			
			System.out.println(listStr.stream().flatMap(c -> listStr2.stream().filter(c2 ->c2.length() == c.length()).map(c2 -> List.of(c,c2)))
					.filter(list -> list.get(0).equals(list.get(1))).distinct().collect(Collectors.toList()));

	}
	
	
}
