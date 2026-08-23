package RevesionPrograme;

public class PalindromeOfString {

	public static void main(String[] args) {
		String name="Naman";
		String rev="";
		String org_name=name;
		int len=name.length();
		for(int i=len-1;i>=0;i--) {
			rev=rev+name.charAt(i);
		}
		System.out.println("Reverse of the String is : " + rev);
		if(org_name.equalsIgnoreCase(rev)) {
			System.out.println("Given String is a Palindrome : " + org_name);
		}
		else {
			System.out.println("Give String is not a Palindrome : " + org_name);
		}

	}

}
