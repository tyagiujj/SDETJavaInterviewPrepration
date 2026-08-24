package Day27;

public class Pangram {

	public static void main(String[] args) {
		String input="The quick brown fox jumps over the lazy dog";
		//LowerCase
	input=input.toLowerCase();
	System.out.println(input);
	boolean result=checkPangram(input);
	if(result) {
		System.out.println("Its a Pangram");
	}
	else {
		System.out.println("Its not a Pangram");
	}
	}
	private static boolean checkPangram(String input) {
		if(input.length()<26) {
			return false;
		}
		for(char i='a';i<='z';i++) {
			if(input.indexOf(i)<0) {
				return false;
			}
		}
		return true;
	}

}
