package Day23;

public class SumOfAnArray {

	public static void main(String[] args) {
		int a [] = {1,3,54,67,7,89,9};
		int sum=0;
		for(int i =0;i<a.length;i++) {
			sum=sum+a[i];
		}
		System.out.println("Sum of an Array is : " + sum);

	}

}
