package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num = List.of(5,8,0,97,97,66,1,3,4);
		
		Predicate<? super Integer> predicate = t -> t % 2==0; //boolean representation
		Function<? super Integer, ? extends Integer> mapper = t -> t * t;//accept and perform operation and return values
		Consumer<Integer> action = System.out::println;//action
		Supplier<Integer> randomSupplier= () -> {
			Random random=new Random();
			return random.nextInt(1000);
		}; //no input return something
		System.out.println(randomSupplier.get());
		
		
		
		num.stream()
		.filter(predicate)
		.map(mapper)
		.forEach(action);
		
		
		BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		};
		int sum=num.stream()
				.reduce(0, accumulator);//take aggreate number and reduce it to single
		System.out.println(sum);
		
		UnaryOperator<Integer> unaryOperator = (x) -> x+3;//take one as input and return 
		System.err.println(unaryOperator.apply(3));
		
		BiPredicate<Integer, Integer> biPredicate= new BiPredicate<Integer, Integer>() {
			
			@Override
			public boolean test(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t + u ==100;
			}
		};
		
		System.out.println(biPredicate.test(50, 50));
		
		BiPredicate<Integer,String> biPre=(x,str)-> {
		return x<50 && str.length() > x;	
		};
		System.out.println(biPre.test(2, "Hello"));//BiPedicate in functional form
		
		
		BiFunction<Integer, Integer, Integer> biFunctional=new BiFunction<Integer, Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t + u;
			}
		};
		
		System.out.println(biFunctional.apply(20, 30));
		
		BiConsumer<Integer, Integer> biConsumer=new BiConsumer<Integer, Integer>() {
			
			@Override
			public void accept(Integer t, Integer u) {
				// TODO Auto-generated method stub
				System.out.println(t+u);
			}
		};
		biConsumer.accept(2, 3);

	}
	
	
	

}
