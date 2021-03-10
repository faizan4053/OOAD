import fact.fact_recursion;
import java.util.Scanner;

public class fact_final{
	public static void main(String [] arg){
		int n;
		System.out.println("Enter the number");
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();

		if(n<0){
			System.out.println("Number is negative");
			System.exit(0);
		}
		fact_recursion obj=new fact_recursion();

		int f=obj.calculate_factorial(n);



		System.out.println("factorial is:"+f);
	}
}