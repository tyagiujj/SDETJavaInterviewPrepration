package TomishInterview;


 class Employee{
	private String name;
	private int salary;
	
	public String getName() {
		return name;
	}
	public int getsalary() {
		return salary;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	
	
}
public class Encapsulation {

	public static void main(String[] args) {
		Employee emp=new Employee();
       emp.setSalary(5000);
       emp.setname("ujjwal");
       System.out.println(emp.getName());
       System.out.println(emp.getsalary());
	}

}
