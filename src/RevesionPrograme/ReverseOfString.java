package RevesionPrograme;

public class ReverseOfString {

	public static void main(String[] args) {
	String name="Automation";
	String rev="";
	int len=name.length();
	for(int i=len-1;i>=0;i--) {
		rev=rev+name.charAt(i);
	}
	System.out.println("Reverse of the String is : " + rev);

	}

}
