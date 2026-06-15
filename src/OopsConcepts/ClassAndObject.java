package OopsConcepts;

public class ClassAndObject {

    String Name;
    String City;
    int Age;
    int rollno;
    String Department;
    

    void emp_details() {
        System.out.println("Name of the employee is : " + Name);
        System.out.println("City of the employee is : " + City);
        System.out.println("Age of the employee is : " + Age);
        System.out.println("Roll no of the employee is : " + rollno);
        System.out.println("Department of the employee is : " + Department);
       
    }

    public static void main(String[] args) {

     
        ClassAndObject emp1 = new ClassAndObject();


        emp1.Name = "Ujjwal Tyagi";
        emp1.City = "Noida";
        emp1.Age = 27;
        emp1.rollno = 101;
        emp1.Department = "QA Automation";
     

       
        emp1.emp_details();
    }
}