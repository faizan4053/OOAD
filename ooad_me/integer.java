class IntegerSet{
	public int array[];

	IntegerSet(){
		this.array=new int[101];
		for(int i=0;i<101;i++){
			array[i]=0;
		}
	}

	public IntegerSet union(IntegerSet a,IntegerSet b){
		IntegerSet c=new IntegerSet();
		int i;
		for(i=0;i<101;i++){
			if(a.array[i]==1 || b.array[i]==1)
				c.array[i]=1;
		}
		return c;
	}

	public IntegerSet intersection(IntegerSet a,IntegerSet b){
		IntegerSet c=new IntegerSet();
		int i;
		for(i=0;i<101;i++){
			if(a.array[i]==1 && b.array[i]==1)
				c.array[i]=1;
		}
		return c;
	}

	public void insertElement(int i){
		this.array[i]=1;
	}

	public void deleteElement(int i){
		this.array[i]=1;
	}

}

class integer{
	public static void main(String [] a){
		IntegerSet o1=new IntegerSet();

		IntegerSet o2=new IntegerSet();

		int i;

		o1.insertElement(0);
		o1.insertElement(5);
		o1.insertElement(67);
		o1.insertElement(4);
		o1.insertElement(99);
		o1.insertElement(76);


		o2.insertElement(0);
		o2.insertElement(3);
		o2.insertElement(57);
		o2.insertElement(4);
		o2.insertElement(9);
		o2.insertElement(70);
		o2.insertElement(99);
		o2.insertElement(76);

		IntegerSet o3;

		o3=o1.union(o1,o2);
		for(i=0;i<101;i++){
			if(o3.array[i]==1)
				System.out.print(i+" ");
		}
		System.out.println();

		o3=o1.intersection(o1,o2);
		for(i=0;i<101;i++){
			if(o3.array[i]==1)
				System.out.print(i+" ");
		}

	}
}