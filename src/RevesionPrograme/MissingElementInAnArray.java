package RevesionPrograme;

public class MissingElementInAnArray {

	public static void main(String[] args) {
	int a[]= {1,2,3,4,5,6,7,8,9,11,12,13,14,15};
	int sum1=0;
	for(int i=0;i<a.length;i++) {
		sum1=sum1+a[i];
	}
	System.out.println("Sum of an Array Element is : " + sum1);
	
	int sum2=0;
	for(int i=1;i<=15;i++) {
		sum2=sum2+i;
		
	}
	System.out.println("Sum of Range an Array Element is : " + sum2);
	System.out.println("Missing Element in an Array is : " + (sum2-sum1));

	}

}
