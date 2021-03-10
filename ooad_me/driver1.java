import java.util.Scanner;

  class Rectangle{
	private float length=(float)1.0;
	private float breadth=(float)1.0;

	Rectangle(){}
	Rectangle(float l,float b){
		set_lenght(l);
		set_breadth(b);
	}

	public void set_lenght(float l){
		if(l>(float)0.0 && l<(float)20.0){
			this.length=l;
		}
		else
		{
			this.length=(float)1.0;
		}
	}

	public void set_breadth(float b){
		if(b>(float)0.0 && b<(float)20.0){
			this.breadth=b;
		}
		else
		{
			this.breadth=(float)1.0;
		}
	}
	public float get_length(){
		return this.length;
	}

	public float get_breadth(){
		return this.breadth;
	}

	public float Area(){
		return get_breadth()*get_length();
	}

	public float Perimeter(){
		return 2*(get_breadth()+get_length());
	}
}

public class driver1{

	public static void main(String[] args) {


	 	float l,b;
	 	Scanner sc=new Scanner(System.in);
	 	System.out.println("Enter the length and breadth");
	 	l=sc.nextFloat();
	 	b=sc.nextFloat();
		Rectangle obj=new Rectangle();

		System.out.println(obj.Area());

		System.out.println(obj.Perimeter());

		Rectangle obj1=new Rectangle(l,b);

		System.out.println(obj1.Area());

		System.out.println(obj1.Perimeter());

	}
}