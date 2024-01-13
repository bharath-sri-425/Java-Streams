package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03BehaviorParameterziation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num = List.of(5,8,0,97,97,66,1,3,4);
		
		
		Predicate<? super Integer> oddPredicate = x -> x% 2 ==0;
		Consumer<? super Integer> action = System.out::println;
		evenOrOdd(num, oddPredicate, action);
		Predicate<? super Integer> evenPredicate = x -> x% 2 !=0;
		evenOrOdd(num, evenPredicate, action);

		
		
		List<Integer> sqrList=squareAndList(num, x -> x*x);
		List<Integer> cubeList=squareAndList(num, x -> x*x*x);
		List<Integer> doubleList=squareAndList(num, x -> x+x);
		System.out.println(sqrList);
		System.out.println(cubeList);
		System.out.println(doubleList);

		
		


	}

	private static List<Integer> squareAndList(List<Integer> num,
			Function<? super Integer, ? extends Integer> squareFun) {
		return num.stream().map(squareFun).collect(Collectors.toList());
	}

	private static void evenOrOdd(List<Integer> num, Predicate<? super Integer> predicate,
			Consumer<? super Integer> action) {
		num.stream().filter(predicate).forEach(action);
	}
	
	

	

}
