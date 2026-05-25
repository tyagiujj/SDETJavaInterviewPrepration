package Day9;

import java.util.Scanner;

public class LargestOfThreeNumberSecondApproach {

	public static void main(String[] args) {
		// Ternary operator in java
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the First Number");
	     int A = sc.nextInt();
	     
	     System.out.println("Enter the Second Number");
	     int B= sc.nextInt();
	     
	     System.out.println("Enter the Third Number");
	     int c=sc.nextInt();
	     
	     int largest1=A>B?A:B;  //Largest of A AND B
	     int largest2 =c>largest1?c:largest1; //Largest of C and Largest1
	     System.out.println(largest2 + " is Largest Number ");
	     sc.close();

	}

}
