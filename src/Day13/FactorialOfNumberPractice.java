package Day13;

import java.util.Scanner;

public class FactorialOfNumberPractice {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Number");
	int num=sc.nextInt();
	long fact=1;
	for(int i=1;i<=num;i++) {
		fact=fact*i;
	}
	System.out.println("Factorial of the Number is : " + fact);
	sc.close();

	}

}
