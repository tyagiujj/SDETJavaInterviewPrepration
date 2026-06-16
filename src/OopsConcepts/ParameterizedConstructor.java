package OopsConcepts;

public class ParameterizedConstructor {
	
	String name;
	int age;
	String Department;
	
	ParameterizedConstructor(String name, int age, String Department){
		this.name=name;
		this.age=age;
		this.Department=Department;
	}
	void Display() {
		System.out.println("Name of the Employee is : " + name);
		System.out.println("Age of the Employee is : " +age);
		System.out.println("Department of the Employee is : " +Department);
	}

	public static void main(String[] args) {
		ParameterizedConstructor pobj= new ParameterizedConstructor("Ujjwal",25,"QA");
		pobj.Display();
	

	}

}
