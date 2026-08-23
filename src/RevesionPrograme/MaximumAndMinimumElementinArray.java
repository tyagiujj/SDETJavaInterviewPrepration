package RevesionPrograme;

public class MaximumAndMinimumElementinArray {

	public static void main(String[] args) {
	int a []= {12,23,46,788,98,78,89,677};
	int max=a[0];
	int min=a[0];
	for(int i=1;i<a.length;i++) {
		if(a[i]>max) {
			max=a[i];
		}
		if(a[i]<min) {
			min=a[i];
		}
	}
	System.out.println("Maximum Number in an Array Element is : " + max);
	System.out.println("Minimum Number is an Array Element is : " + min);
	

	}

}
