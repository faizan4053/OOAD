import fact.factorial;
import java.util.Scanner;

public class fact_final{
	public static void main(String [] arg){
		int n;
		System.out.println("Enter the number");
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();

		factorial obj=new factorial(n);

		int fact=obj.calculate_factorial();

		System.out.println("factorial is:"+fact);
	}
}