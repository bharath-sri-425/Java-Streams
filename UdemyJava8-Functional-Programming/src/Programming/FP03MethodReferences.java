package Programming;

import java.util.List;

public class FP03MethodReferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		List<String> listStr=List.of("Spring","SpringBoot","SpringBoot","Kubernetes","Java","python");

		listStr.stream()
		.map(String::toUpperCase)//Method Reference
		.forEach(System.out::println);

	}
	
	

}
