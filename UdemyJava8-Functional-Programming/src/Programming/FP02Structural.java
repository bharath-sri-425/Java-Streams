package Programming;

import java.util.List;

public class FP02Structural {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num = List.of(5,8,0,97,97,66,1,3,4);
		int sum=sumOfallNumber(num);
		System.out.println(sum);
		
	}

	private static int sumOfallNumber(List<Integer> num) {
		// TODO Auto-generated method stub
		int sum=0;
		for (int n:num) {
			sum = sum +n;
		}
		return sum;
	}

}
