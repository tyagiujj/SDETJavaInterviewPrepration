package RevesionPrograme;

import java.util.Scanner;

public class CountNumberofDigit {

	public static void main(String[] args) {
		System.out.println("Enter the Number");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int count=0;
		while(num!=0) {
			num=num/10;
			count++;
		}
		System.out.println("Count number of Digit is : " + count);
		sc.close();

	}

}
