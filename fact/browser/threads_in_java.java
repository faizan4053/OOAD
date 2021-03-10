import java.util.*;

 class Tuna implements Runnable{
	String name;
	int time;
	Random r=new Random();

	public Tuna(String name){
		this.name=name;
		time=r.nextInt(100000);
	}

	public void run(){
		try{
			System.out.printf("%s is sleeping for %d\n",name,time);
			Thread.sleep(time);
			System.out.printf("%s is done\n",name);
		}catch(Exception e){}
	}
}

public class threads_in_java{

	public static void main(String[] ar){
		Thread t1=new Thread(new Tuna("thread_1"));
		Thread t2=new Thread(new Tuna("thread_2"));
		
		Thread t3=new Thread(new Tuna("thread_3"));
		
		Thread t4=new Thread(new Tuna("thread_4"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}