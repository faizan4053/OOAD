import java.util.*;
import java.util.Arrays;
 
class Array<E extends Number> {
    private Object[] obj_array;   //object array
    public int length;
    // class constructor
    public Array(int length)    {
        // instantiate a new Object array of specified length
        obj_array = new Object [length];
        this.length = length;
    }
    // get obj_array[i]
    E get(int i) {
        @SuppressWarnings("unchecked")
        E e = (E)obj_array[i];
        return e;
    }
    // set e at obj_array[i]
    void set(int i, E e) {
        obj_array[i] = e;
    }
    
    public static<E extends Number> E add(E x, E y){

        if (x == null || y == null) {
            return null;
        }

        if (x instanceof Double) {
            return (E) new Double(x.doubleValue() + y.doubleValue());
        } else if (x instanceof Integer) {
            return (E)new Integer(x.intValue() + y.intValue());
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }
    public static<E extends Number> E mul(E x, E y){

        if (x == null || y == null) {
            return null;
        }

        if (x instanceof Double) {
            return (E) new Double(x.doubleValue() * y.doubleValue());
        } else if (x instanceof Integer) {
            return (E)new Integer(x.intValue() * y.intValue());
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }
    
    public E getSum(){
        E ans = (E)this.get(0);
        for(int i = 1;i<length;i++){
            ans = add(ans,this.get(i));
        }
        return ans;
    }
    public E getMul(){
        E ans = (E)this.get(0);
        for(int i = 1;i<length;i++){
            ans = mul(ans,this.get(i));
        }
        return ans;
    }
    @Override
    public String toString() {
        return Arrays.toString(obj_array);
    }
}
   
// Driver class to test above 
class Main 
{ 
    public static void main (String[] args) 
    {  
        Array<Integer> arr1 = new Array<Integer>(3);
        arr1.set(0,1);
        arr1.set(1,2);
        arr1.set(2,3);
        System.out.println(arr1.getSum());
        System.out.println(arr1.getMul());

        Array<Double> arr2 = new Array<Double>(4);
        arr2.set(0,1.1);
        arr2.set(1,2.2);
        arr2.set(2,3.6);
        arr2.set(3,4.4);

        System.out.println(arr2.getSum());
        System.out.println(arr2.getMul());
    } 
}