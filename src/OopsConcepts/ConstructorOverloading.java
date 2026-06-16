package OopsConcepts;

public class ConstructorOverloading {
	
	ConstructorOverloading(){
		System.out.println("Default Constructor");
	}
	ConstructorOverloading(String Name){
		System.out.println("Name of the Boy is : " +Name);
	}
	ConstructorOverloading(String Name,int Age, String City){
		System.out.println("Name of the Boy is : " + Name);
		System.out.println("Age of the Boy is : " +Age);
		System.out.println("City of the Boy is : " +City);
	}

	public static void main(String[] args) {
		ConstructorOverloading cobj=new ConstructorOverloading();
		ConstructorOverloading cobj1= new ConstructorOverloading("Ujjwal");
		ConstructorOverloading cobj2=new ConstructorOverloading("Ujjwal", 25, "Mzn");
		

	}

}
