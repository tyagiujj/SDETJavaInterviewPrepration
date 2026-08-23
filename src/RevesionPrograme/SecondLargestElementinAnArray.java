package RevesionPrograme;

public class SecondLargestElementinAnArray {

	public static void main(String[] args) {
	int arr[]= {1,23,56,78,99,76,100};
	int firstlargest=Integer.MIN_VALUE;
	int secondlargest=Integer.MIN_VALUE;
	for(int number : arr) {
		if(number>firstlargest) {
			secondlargest=firstlargest;
			firstlargest=number;
		}
		else if(number>secondlargest && number!=firstlargest) {
			secondlargest=number;
		}
	}
	System.out.println("Second largest number in an Array is : " + secondlargest);

	}

}
