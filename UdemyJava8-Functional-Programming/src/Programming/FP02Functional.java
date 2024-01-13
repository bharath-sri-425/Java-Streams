package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num = List.of(5,8,0,97,97,66,1,3,4);
		
		int sum=num.stream()
				.reduce(0, FP02Functional::sum);//take aggreate number and reduce it to single
		System.out.println(sum);
		
		int sums = num.stream()
				//.reduce(0, (x,y) -> x+y);
				.reduce(0, Integer::sum);
		System.out.println(sums);
		
		int max =num.stream().reduce(Integer.MIN_VALUE,(x,y) -> x>y ? x:y);//Maximum value
		System.out.println(max);
		

		int min =num.stream().reduce(Integer.MAX_VALUE,(x,y) -> x<y ? x:y);//Minimum value
		System.out.println(min);
		
		
		int sumOfSqrNum=num.stream().map(x -> x * x ).reduce(0, Integer::sum);
		System.out.println(sumOfSqrNum);
		
		int sumOfCubeNum=num.stream().map(x -> x * x * x).reduce(0, Integer::sum);
		System.out.println(sumOfCubeNum);
		
		int sumOfOddNum=num.stream().filter(a -> a % 2 != 0).reduce(0, Integer::sum);
		System.out.println(sumOfOddNum);
		
		// Distinct
		num.stream().distinct().forEach(System.out::println);
		//sorting
		num.stream().distinct().sorted().forEach(System.out::println);
		
		List<String> listStr=List.of("Spring","SpringBoot","SpringBoot","Kubernetes","Java","python");

		listStr.stream().distinct().sorted().forEach(System.out::println); //sorting in natural order
		listStr.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);// sorting in reverse order
		
		listStr.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);// sorting in reverse order
		
//		create a list square of number
		
		List<Integer> sqrList=num.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.println(sqrList);
		
		// create a even number square to list
		
		List<Integer> evnSqrLst=num.stream().filter(n -> n%2 ==0).map(x -> x*x).collect(Collectors.toList());
		System.out.println(evnSqrLst);
		
		//create a list using length of  course titles
		List<Integer> lngCorTit= 
				listStr.stream().map(str -> str.length()).collect(Collectors.toList());
		System.out.println(lngCorTit);

	}
	
	private static Integer sum(int n,int m) {
		return n+m;
		
	}

}
