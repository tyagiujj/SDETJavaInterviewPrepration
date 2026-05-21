package Day5;

import java.util.Scanner;

public class PalindromOfString {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the String");
	String str=sc.next();
	String org_str=str;
	String rev="";
	int len=str.length();
	for(int i=len-1;i>=0;i--) {
		rev=rev+str.charAt(i);
	}
	if(org_str.equalsIgnoreCase(rev)) {
		System.out.println("String is Palindrome");
	}
	else {
		System.out.println("String is not Palindrome");
	}
	sc.close();

	}

}
