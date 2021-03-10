package fact;

public class factorial{

	int num;

	factorial(int n){
		this.num=n;
	}

	 int calculate_factorial(){

		 int a[];
		int n=this.num;
		a=new Int[n+1];
		for(int i=2;i<=n;i++){
			a[i]=i*a[i-1];
		}

		return a[n]
	}

}