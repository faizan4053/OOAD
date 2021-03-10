import javafx.util.Pair;
import java.util.Scanner;
class Complex{
	private float real1,real2;
	private float img1,img2;
	
	Complex(){
		this.real1=0.0f;
		this.real2=0.0f;
		this.img1=0.0f;
		this.img2=0.0f;
	}
	Complex(float r1,float r2,float i1,float i2){
		this.real1=r1;
		this.real2=r2;
		this.img1=i1;
		this.img2=i2;
		//obj=new Complex();
	}
	
	public Pair<Float,Float> Add(){
		float r,i;
		r=this.real1+this.real2;
		i=this.img1+this.img2;
		return new Pair<Float,Float> (r,i);
	}
	
	public Pair<Float,Float> Sub(){
		float r,i;
		r=this.real1-this.real2;
		i=this.img1-this.img2;
		return new Pair<Float,Float> (r,i);
	}
}

public class driver{
	public static void main(String [] arg){
		Complex obj=new Complex();//default
		Pair<Float,Float> p;
		p=obj.Add();
		System.out.println("("+p.getKey()+","+p.getValue()+")");
		p=obj.Sub();
		System.out.println("("+p.getKey()+","+p.getValue()+")");
		
		Scanner sc=new Scanner(System.in);
		float r1,r2,i1,i2;
		r1=sc.nextFloat();
		r2=sc.nextFloat();
		i1=sc.nextFloat();
		i2=sc.nextFloat();
		
		Complex obj1=new Complex(r1,r2,i1,i2);
		
		p=obj1.Add();
		System.out.println("("+p.getKey()+","+p.getValue()+")");
		p=obj1.Sub();
		System.out.println("("+p.getKey()+","+p.getValue()+")");
		
		
	}
}
