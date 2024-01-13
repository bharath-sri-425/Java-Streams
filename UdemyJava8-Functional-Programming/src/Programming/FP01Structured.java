package Programming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> num = List.of(5,8,0,97,97,66,1,3,4);
		printListOfAllNumbersStructured(num);
		printListOfAllEvenNumbersStructured(num);
	}

	private static void printListOfAllNumbersStructured(List<Integer> numbers) {

		System.out.println("printListOfAllNumbersStructured\n");

		for (Integer integer : numbers) {
			System.out.println(integer);
			 
		}
	}

	private static void printListOfAllEvenNumbersStructured(List<Integer> numbers) {
		
		System.out.println("printListOfAllEvenNumbersStructured\n");

		for (Integer integer : numbers) {
			if (integer % 2 == 0) {
			System.out.println(integer);
			}
		}
		
	}
}
