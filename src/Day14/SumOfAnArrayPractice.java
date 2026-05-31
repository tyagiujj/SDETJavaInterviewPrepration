package Day14;

public class SumOfAnArrayPractice {

	public static void main(String[] args) {
		int a[]={4,6,7,9,7,8,9};
		int sum=0;
		for(int i=0;i<=a.length-1;i++) {
			sum=sum+a[i];
		}
		System.out.println("Sum of an Array is : " + sum);
		

	}

}
