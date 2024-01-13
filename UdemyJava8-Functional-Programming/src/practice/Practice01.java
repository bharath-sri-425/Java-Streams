package practice;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num= List.of(1,2,3,4,5,6,7,8,9,9,8,7,66,55,33);
		
		int z=num.stream().reduce(0, (x,y) -> x+y);
		System.out.println(z);
		z=num.stream().reduce(0,(x,y)->x);
		System.out.println(z);
		z=num.stream().reduce(0,(x,y)->y);
		System.out.println(z);
		z=num.stream().reduce(0,(x,y)->x>y ? x:y);
		System.out.println(z);
		
		List<Integer>sortedList=num.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println(sortedList);
		
		List<Integer> list;
		int[] nums = {3,2,4};
		int target=6;
		int[] output;
		for (int i=0;i<nums.length;i++) {
			for (int j=i+1;j<nums.length;j++) {
			int sum=nums[i]+nums[j];
			if (sum==target) {
				list=List.of(i,j);	
				System.out.println(list);
			}
			}
		}
		//Palindrom check

		int a=-121;
		String aa=String.valueOf(a);
		StringBuilder ss=new StringBuilder(aa);
		if (ss.reverse().toString().equals(aa)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		int N=4;
		
		    if(N >=2 && N<=5){
                System.out.println("Not Weired");
            }
		}
   
	
	

}
