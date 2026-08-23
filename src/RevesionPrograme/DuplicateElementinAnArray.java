package RevesionPrograme;

public class DuplicateElementinAnArray {

	public static void main(String[] args) {
	String name []= {"Selenium","Java","TestNG","Selenium","Java"};
	boolean flag=false;
	for(int i=0;i<name.length;i++) {
		for(int j=i+1;j<name.length;j++) {
			if(name[i].equals(name[j])) {
				System.out.println("Duplicate Element in an Array is : " + name[i]);
				flag=true;
				break;
			}
		}}
	
	if(flag==false) {
		System.out.println("Element not found");
	}

	}

}
