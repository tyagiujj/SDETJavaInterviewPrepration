package Day9;

import java.util.Scanner;

public class LargestOfThreeNumber {
 //Approach 1
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the First Number");
		int A=sc.nextInt();
		
		System.out.println("Enter the Second Number");
		int B= sc.nextInt();
		
		System.out.println("Enter the Third Number");
		int C= sc.nextInt();
		if(A>B && A>C) {
			System.out.println("A is a Largest number");
		}
		else if (B>A && B>C){
			System.out.println("B is a Largest Number");
			
		}
		else {
			System.out.println("C is a Largest Number");
			sc.close();
		}

	}

}
