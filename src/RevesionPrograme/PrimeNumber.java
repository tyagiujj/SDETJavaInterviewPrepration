package RevesionPrograme;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
	System.out.println("Enter the Number is : ");
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int count=0;
	if(num>1) {
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				count++;
			}}
			if(count==2) {
				System.out.println("Given number is Prime number : " + num);
			}
			else {
				System.out.println("Give number is not Prime number : " + num);
			}
			
	}
		
	
	else {
		System.out.println("Number is not a Prime Number because give number is less then 1");
		sc.close();
	}

}}


