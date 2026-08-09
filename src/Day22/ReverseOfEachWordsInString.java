package Day22;

public class ReverseOfEachWordsInString {

	public static void main(String[] args) {
		String Title= "Welcome to Java";
		String [] words= Title.split(" ");
		String finalString ="";
		for(String w : words) {
			String reversewords ="";
			for(int i=w.length()-1;i>=0;i--) {
				reversewords=reversewords + w.charAt(i);
			}
			finalString = finalString +reversewords+ " ";
		}
		System.out.println("Reverse of the Each words is : " + finalString.trim());

	}

}
