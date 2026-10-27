package Day32;

public class RemoveDuplicateCharacterformString {

	public static void main(String[] args) {
	String str="aaaaabbccdffdff";
	for(int i=0;i<str.length();i++) {
		boolean isduplicate =false;
		for(int j=0;j<i;j++) {
			if(str.charAt(i)==str.charAt(j)) {
			 isduplicate=true;
			 break;
			}
		}
		if(!isduplicate) {
			System.out.print(str.charAt(i) + " ");
		}
	}

	}

}
