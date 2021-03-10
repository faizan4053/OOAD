import java.io.*;
import java.util.Scanner;

class Invoice{
	private String number;
	private String description;
	private int quantity;
	private int price;

	static int copy_count=0;//to maintain count of copy objects

	Invoice(){}

	Invoice(String number,String description,int quantity,int price){
		// this.number=number;
		// this.description=description;
		// this.quantity=quantity;
		// this.price=price;
		set_item_number(number);
		set_item_description(description);
		set_item_quantity(quantity);
		set_item_price(price);
	}

	void set_item_number(String number){
		this.number=number;
	}
	void set_item_description(String description){
		this.description=description;
	}
	void set_item_quantity(int quantity){
		this.quantity=quantity;
	}
	void set_item_price(int price){
		this.price=price;
	}

	String get_item_number(){
		return this.number;
	}
	String get_item_description(){
		return this.description;
	}

	int get_item_price(){
		return this.price;
	}
	int get_item_quantity(){
		return this.quantity;
	}

	int getInvoiceAmount(){
		return get_item_quantity()*get_item_price();
	}

	int maximum_Quantity(Invoice a,Invoice b){
		return (a.get_item_quantity()>b.get_item_quantity())?a.get_item_quantity():b.get_item_quantity();
	}
}

public class testInvoice{
	public static void main(String [] arg){

		String number,description;
		int price,quantity;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the invoice features");

		System.out.println("Enter the item number");
			number=sc.nextLine();
		System.out.println("Enter the item description");
			description=sc.nextLine();
		System.out.println("Enter the item quantity");
			quantity=sc.nextInt();
		System.out.println("Enter the item price");
			price=sc.nextInt();

		Invoice obj1=new Invoice(number,description,quantity,price);
		System.out.println("The corresponding features of invoice are");
		System.out.println("Item number is "+obj1.get_item_number());
		System.out.println("Item description is "+obj1.get_item_description());
		System.out.println("Item price is "+obj1.get_item_price());
		System.out.println("Item quantity is "+obj1.get_item_quantity());

		System.out.println("Item Invoice Ammount is "+obj1.getInvoiceAmount());
		int k,f=0;
		System.out.println("Want to enter more invoices enter 1 other 0");
		k=sc.nextInt();
		Invoice obj2,obj3=obj1;
		if(k==1) f=1;

		while(k==1){
			if(f==1)
				obj3.copy_count++;

			System.out.println("Enter the item number");
				number=sc.nextLine();
			System.out.println("Enter the item description");
				description=sc.nextLine();
			System.out.println("Enter the item quantity");
				quantity=sc.nextInt();
			System.out.println("Enter the item price");
				price=sc.nextInt();

			obj2=new Invoice(number,description,quantity,price);
			System.out.println("The corresponding features of invoice are");
			System.out.println("Item number is "+obj1.get_item_number());
			System.out.println("Item description is "+obj1.get_item_description());
			System.out.println("Item price is "+obj1.get_item_price());
			System.out.println("Item quantity is "+obj1.get_item_quantity());

			System.out.println("Item Invoice Ammount is "+obj1.getInvoiceAmount());
			System.out.println("Invoice with maximum quantity"+obj3.maximum_Quantity(obj2,obj3));
			obj3=obj2;
			obj3.copy_count++;
			System.out.println("Want to enter more invoices enter 1 other 0");
			k=sc.nextInt();
		}

		System.out.println("No of times object get copied is "+obj1.copy_count);

	}
}