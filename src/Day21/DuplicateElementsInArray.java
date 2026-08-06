package Day21;

public class DuplicateElementsInArray {

	public static void main(String[] args) {
		String arr []= {"java" ,"C" ,"c++","Python","java","c"};
		
		// Approach1
		boolean flag= false;
		for(int i =0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("Found Duplicate Element : " +arr[i]);
					flag=true;
				}
				
			}
		}
	 if(flag==false) {
		 System.out.println("Duplicate Element not Found");
	 }
		
		

	}

}
