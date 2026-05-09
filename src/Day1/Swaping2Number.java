package Day1;

public class Swaping2Number {

	public static void main(String[] args) {
		int a=10, b=20;
		System.out.println("Before Swapping values are..."+a+" "+b);
		//logic 1 Third Variable
//		
//		int t=a;
//		a=b;
//		b=t;
//		
		// Logic 2 : use + and -  we do not use third variable
		a=a+b;  
		b=a-b;
		a=a-b;
		System.out.println("After Swapping values are..."+a+" "+b);

	}

}
