package Programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listStr=List.of("Spring","SpringBoot","Kubernetes","Java","python");
		printListOfAllNumbersFunctional(List.of(5,8,0,97,97,66,1,3,4));
		//exercise
		printListOfAllOddNumbersFunctional(List.of(5,8,0,97,97,66,1,3,4));
		printListOfExercise(listStr);
		printListOfCubeOfOddNumber(List.of(5,8,0,97,97,66,1,3,4));
		
	}
	
	private static void printListOfCubeOfOddNumber(List<Integer> of) {
		// TODO Auto-generated method stub
		System.out.println("print list of  odd cube numbers");

		of.stream()
		.filter(number -> number % 2 !=0)
		.map(number -> number * number * number)
		.forEach(System.out::println);
		
	}

	private static void printListOfExercise(List<String> listStr) {
		// TODO Auto-generated method stub
		//print all in the list
		listStr.stream()
		.forEach(System.out::println);
		//print string contains spring
		System.out.println("print list contains spring");
		listStr.stream()
		.filter(list -> list.toLowerCase().contains("spring"))
		.forEach(System.out::println);
		System.out.println("Print whose name has atleast 4 character");
		listStr.stream()
		.filter(list -> list.length()>4)
		.forEach(System.out::println);
		
		System.out.println("Print length of courses");
		listStr.stream()
		.map(str -> "length of "+str +" is "+str.length())
		.forEach(System.out::println);
	}

	private static void printListOfAllOddNumbersFunctional(List<Integer> numbers) {
		// TODO Auto-generated method stub
		System.out.println("print odd numbers");
		numbers.stream()
		.filter(number-> number%2 !=0)
		.forEach(System.out::println); //print odd numbers
		
	}

	private static boolean isEven(Integer i) {
		return i % 2 == 0 ;
	}

	private static void print(Integer i) {
		System.out.println(i);
	}
	private static void printListOfAllNumbersFunctional(List<Integer> numbers) {
		//list to streams 
		numbers.stream()
		.forEach(FP01Functional::print);//functional approach with method ref (class name::method name)
		
		numbers.stream()
		.forEach(System.out::println); // streams to print elements in simple way
		
		System.out.println("is even check/n ======");
		numbers.stream()
		.filter(FP01Functional::isEven)
		.forEach(System.out::println);//functional approach with method ref (class name::method name)
		
		System.out.println("is even check using lamda expression/nlamda expression is nothing but simplest way of representing a method/n ======");//lamda expression is nothing but simplest way of representing a method
		numbers.stream()
		.filter(number -> number % 2 == 0)//lamda expression
		.forEach(System.out::println);
	}

}
