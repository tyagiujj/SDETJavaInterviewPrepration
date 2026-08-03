package Day18;

public class FindMaximumAndMinimumElementofArray {

	public static void main(String[] args) {
		int a[]= {30,50,60,80,90};
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
		System.out.println("Maximum Element of an Array is : " + max);
		System.out.println("Minimum Element of an Array is : " + min);

	}

}
