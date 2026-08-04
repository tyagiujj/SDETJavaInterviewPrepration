package Day20;

public class MissingElementinArray {

	public static void main(String[] args) {
		int a[]= {1,2,3,5,6,7,8,9,10};
		int sum1=0;
		for(int i=0;i<a.length;i++) {
			sum1=sum1+a[i];
		}
		System.out.println("Sum of an Array Element is : " + sum1);
		
		int sum2=0;
		for(int i=1;i<=10;i++) {
			sum2=sum2+i;
		}
		System.out.println("Sum  of range Element is : " +sum2);
		System.out.println("Missing Eelement in an Array is : " +(sum2-sum1));

	}

}
