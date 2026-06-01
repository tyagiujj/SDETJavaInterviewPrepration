package Day15;

public class PrintEvenAndOddFormAnArray {

	public static void main(String[] args) {
   int a[]= {1,2,4,6,78,9};
   System.out.println("Even number from an Array...");
   for(int i=0;i<a.length;i++) {
	   if(a[i]%2==0) {
		   System.out.println(a[i]);
		   
	   }}
	   System.out.println("odd Number from an Array...");
	   for(int i=0;i<a.length;i++) {
		   if(a[i]%2!=0) {
			   System.out.println(a[i]);
		   }
	   }
   }


	}


