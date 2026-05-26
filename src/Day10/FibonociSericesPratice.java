package Day10;

import java.util.Scanner;

public class FibonociSericesPratice {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the first number");
		int n1=sc.nextInt();
		System.out.println("Enter the second number");
		int n2=sc.nextInt();
		int sum=0;
	System.out.println(n1+" "+n2);
	for(int i=2; i<10;i++) {
		sum=n1+n2;
		System.out.println(" "+sum);
		n1=n2;
		n2=sum;
		sc.close();
	}

	}

}
