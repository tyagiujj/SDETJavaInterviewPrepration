package Day2;

import java.util.Scanner;

public class ReverseOfNumberLogic2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
	    System.out.println("Enter the Number");
	    int num =sc.nextInt();
	    
	    //Using String Buffer class method
	   
	    StringBuffer sb= new StringBuffer(String.valueOf(num));
	    StringBuffer rev =sb.reverse();
	    System.out.println("Reverse of number is : " +rev);
	    

	}

}
