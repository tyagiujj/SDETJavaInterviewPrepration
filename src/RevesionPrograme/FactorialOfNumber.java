package RevesionPrograme;

import java.util.Scanner;

public class FactorialOfNumber {

	public static void main(String[] args) {
		System.out.println("Enter the Number");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int fact=1;
		for(int i=1;i<=num;i++) {
			fact=fact*i;
		}
		System.out.println("Factorial of the Given Number is : " + fact);
		sc.close();

	}

}
