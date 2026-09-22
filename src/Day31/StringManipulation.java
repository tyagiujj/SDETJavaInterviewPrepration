package Day31;

public class StringManipulation {

	public static void main(String[] args) {
		String str="The rains has started here";
		System.out.println("Length of the Stirng : " + str.length());
		System.out.println("Value of 5th index is : " + str.charAt(5));
		System.out.println("Index of s is : " + str.indexOf('s'));
		System.out.println(str.indexOf('s', 9));
	}}
