package Day3;

public class ReverseOfString {

	public static void main(String[] args) {
		//1)USING +(STRING CONCATENATION) OPERATOR
		String str="ABCD";
		String rev="";
		int len=str.length();//4
		for(int i=len-1;i>=0;i--) { //3 2 1 0
			rev=rev+str.charAt(i); //DCBA
		}
		System.out.println("Reverse of the String is : " +rev);
		

	}

}
