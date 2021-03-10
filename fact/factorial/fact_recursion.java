package fact;

 public class fact_recursion{

	public int calculate_factorial(int num){

		 if(num<=1){
		 	return 1;
		 }
		 else
			return num*calculate_factorial(num-1);
	}

}