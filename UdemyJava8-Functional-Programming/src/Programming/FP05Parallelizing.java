package Programming;

import java.util.stream.LongStream;

public class FP05Parallelizing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time = System.currentTimeMillis();
		//sum of 1 to 100000
		System.out.println(LongStream.range(1, 10000000).sum());
		System.out.println(System.currentTimeMillis() - time);
	}
	
	
}
