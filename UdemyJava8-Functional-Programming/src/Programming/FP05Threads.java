package Programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Threads {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Runnable runThread = new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<=1000;i++) {
				System.out.println(Thread.currentThread().getId() +" : "+i);
				}
				
			}
		};
		
		Thread thd=new Thread(runThread);
		thd.start();
		
		Thread thd1=new Thread(runThread);
		thd1.start();
		
		Thread thd2=new Thread(runThread);
		thd2.start();
		
		
Runnable runThreadFunctional =()->{
				// TODO Auto-generated method stub
				for(int i=0;i<=1000;i++) {
				System.out.println(Thread.currentThread().getId() +" : "+i);
				}
		};
		
		Thread thdFun=new Thread(runThreadFunctional);
		thdFun.start();
		
		Thread thdFun1=new Thread(runThreadFunctional);
		thdFun1.start();
		
		Thread thdFun2=new Thread(runThreadFunctional);
		thdFun2.start();
	}
	
	
}
