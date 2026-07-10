package Day17;

public class DuplicateElementinArray {

	public static void main(String[] args) {
		String arr[]= {"Java","C","C++","Python","C"};
		//Approach 1
		for(int i=0; i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("Found the Duplicate Element : " +arr[i]);
				}
			}
		}

	}

}
