package Day25;

public class ArrayareEquals {

	public static void main(String[] args) {
		int a1[]= {1,2,3,4,5,6};
		int a2[]= {1,2,3,4,5,6,};
		boolean status =true;
		if(a1.length==a2.length) {
			for(int i=0;i<a1.length;i++) {
				if(a1[i]!=a2[i]) {
					status=false;
					break;
				}
			}
			
		}
		else {
			status=false;
		}
		if(status==true) {
			System.out.println("Arrays are Equals");
		}
		else {
			System.out.println("Arrays are not Equals");
		}

	}

}
