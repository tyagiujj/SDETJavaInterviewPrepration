package Day4;

import java.util.Scanner;

public class PalindromNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int num=sc.nextInt();
		int orgnum=num;
		int rev=0;
		while(num!=0) {
			rev=rev*10+num%10;
			num=num/10;
		}
		System.out.println("Reverse of number is : " +rev);

	
	if(orgnum==rev) {
		System.out.println("Number is a palindrom Number");
	}else {
		System.out.println("Number is not a palindrom Number");
	}
	}

}
