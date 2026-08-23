package RevesionPrograme;

import java.util.Scanner;

public class PalindromeOfNumber {

	public static void main(String[] args) {
		System.out.println("Enter the Number");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int rev=0;
		int org_num=num;
		while(num!=0) {
			rev=rev*10+num%10;
			num=num/10;
		}
		if(org_num==rev) {
			System.out.println("Given number is a Palindrome : " + org_num);
		}
		else {
			System.out.println("Given number is not a Palindrome : " + org_num);
			sc.close();
		}

	}

}
