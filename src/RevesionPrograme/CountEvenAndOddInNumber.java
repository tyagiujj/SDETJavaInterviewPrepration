package RevesionPrograme;

import java.util.Scanner;

public class CountEvenAndOddInNumber {

	public static void main(String[] args) {
	System.out.println("Enter the Number is ");
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int even_count=0;
	int odd_count=0;
	while(num!=0) {
		int rem=num%10;
		if(rem%2==0) {
			even_count++;
		}
		else {
			odd_count++;
		}
		num=num/10;
	}
	System.out.println("Even count in a Digit is : " + even_count);
	System.out.println("Odd count in a Digit is : " + odd_count);
	sc.close();

	}

}
