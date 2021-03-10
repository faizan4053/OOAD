import java.util.*;

class Employee{
	private String first_Name;
	private String last_Name;
	private int monthly_Salary;
	static int count=0;//to count default no. of objects

	Employee(){};

	Employee(String first_Name,String last_Name,int monthly_Salary){
		set_first_Name(first_Name);
		set_last_Name(last_Name);
		set_monthly_Salary(monthly_Salary);
		this.count++;
	}
	void set_first_Name(String first_Name){
		this.first_Name=first_Name;
	}
	void set_last_Name(String last_Name){
		this.last_Name=last_Name;
	}
	void set_monthly_Salary(int  monthly_Salary){
		this.monthly_Salary=monthly_Salary;
	}
	String get_first_Name(){
		return this.first_Name;
	}
	String get_last_Name(){
		return this.last_Name;
	}
	int get_monthly_Salary(){
		return this.monthly_Salary;
	}
	int get_yearly_Salary(){
		return 12*get_monthly_Salary();
	}
	double raise_Salary(int percent){
		double temp=(get_monthly_Salary()*(percent))/100;
		temp=temp+(double)get_monthly_Salary();
		return temp;
	}

	double get_yearly_Salary_after_Raise(int raise_Percent){
		double temp=raise_Salary(raise_Percent);
		return (double)(temp*12);
	}
	String Employee_With_Higher_Salary(Employee a,Employee b){
		return ((a.monthly_Salary>b.monthly_Salary)?(a.first_Name+" "+a.last_Name):(b.first_Name+" "+b.last_Name));
	}
}

public class testEmployee{

	public static void main(String [] ar){

		String first_Name,last_Name;
		int monthly_Salary;
		Employee obj1,obj2;

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first employee details");

		System.out.println("Enter first name");
			first_Name=sc.nextLine();
		System.out.println("Enter last name");
			last_Name=sc.nextLine();
		System.out.println("Enter monthly Salary");
			monthly_Salary=sc.nextInt();

		obj1=new Employee(first_Name,last_Name,monthly_Salary);

		System.out.println("first employee details are");

		System.out.println("first name is "+obj1.get_first_Name());

		System.out.println("last name is "+obj1.get_last_Name());
	
		System.out.println("monthly Salary is "+obj1.get_monthly_Salary());

		System.out.println("Yearly Salary is "+obj1.get_yearly_Salary());

		System.out.println("Yearly Salary after raise is "+obj1.get_yearly_Salary_after_Raise(10));

		System.out.println("Enter Second employee details");

		System.out.println("Enter first name");
			first_Name=sc.nextLine();
		System.out.println("Enter last name");
			last_Name=sc.nextLine();
		System.out.println("Enter monthly Salary");
			monthly_Salary=sc.nextInt();

		obj2=new Employee(first_Name,last_Name,monthly_Salary);

		System.out.println("first employee details are");

		System.out.println("first name is "+obj2.get_first_Name());

		System.out.println("last name is "+obj2.get_last_Name());
	
		System.out.println("monthly Salary is "+obj2.get_monthly_Salary());

		System.out.println("Yearly Salary is "+obj2.get_yearly_Salary());

		System.out.println("Yearly Salary after raise is "+obj2.get_yearly_Salary_after_Raise(10));


		System.out.println("Employee with maximum salary is "+obj2.Employee_With_Higher_Salary(obj1,obj2));
		System.out.println("Default object count is "+obj1.count);
	}
}