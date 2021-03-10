import java.util.Scanner;
import javafx.util.Pair;

class SavingsAccount{
	static float annualInterestRate;
	private float savingBalance;

	SavingsAccount(float bal){

		this.savingBalance=bal;
	}

	public static void modifyInterestRate(float ir){
		annualInterestRate=ir;
	}

	public Pair<Float,Float> calculateMonthlyInterest(){
		float temp=(annualInterestRate*savingBalance)/12;
		this.savingBalance+=temp;
		//Pair p=new Pair(temp,this.savingBalance);
		return new Pair<Float,Float>(temp,this.savingBalance);
	}
}

public class account{

	public static void main(String [] arg){
		float salary,interest_rate;
		Scanner sc=new Scanner(System.in);

		//System.out.println("Enter the salary and interest rate");
		//salary=sc.nextFloat();
		//interest_rate=sc.nextFloat();

		SavingsAccount saver1,saver2;
		saver1=new SavingsAccount((float)2000.0);
		saver1.modifyInterestRate((float)0.04);

		saver2=new SavingsAccount((float)2000.0);
		saver2.modifyInterestRate((float)0.04);

		Pair<Float,Float> p=saver1.calculateMonthlyInterest();

		System.out.println("Balance is: "+p.getValue()+"at interest rate: "+p.getKey());

		p=saver2.calculateMonthlyInterest();

		System.out.println("Balance is: "+p.getValue()+"at interest rate: "+p.getKey());

		saver1=new SavingsAccount((float)3000.0);
		saver1.modifyInterestRate((float)0.05);

		saver2=new SavingsAccount((float)3000.0);
		saver2.modifyInterestRate((float)0.05);

		 p=saver1.calculateMonthlyInterest();

		System.out.println("Balance is: "+p.getValue()+"at interest rate: "+p.getKey());

		p=saver2.calculateMonthlyInterest();

		System.out.println("Balance is: "+p.getValue()+"at interest rate: "+p.getKey());

	}
}