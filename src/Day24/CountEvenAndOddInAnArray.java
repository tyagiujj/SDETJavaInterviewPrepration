package Day24;

public class CountEvenAndOddInAnArray {

	public static void main(String[] args) {
	int a[] = {12,56,78,90,87,89};
	int even_count=0;
	int odd_count =0;
	for(int i=1;i<a.length-1;i++) {
		if(a[i]%2==0) {
			even_count++;
		}
		else {
			odd_count++;
		}
	}
	System.out.println("Even Count in an Array is : " + even_count);
	System.out.println("Odd Count in an Array is : " + odd_count);



	}
	
}
