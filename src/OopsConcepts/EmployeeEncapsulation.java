package OopsConcepts;

public class EmployeeEncapsulation {

    private String name;
    private int age;

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public static void main(String[] args) {

        EmployeeEncapsulation emp = new EmployeeEncapsulation();

        emp.setName("Ujjwal");
        emp.setAge(27);

        System.out.println("Name : " + emp.getName());
        System.out.println("Age : " + emp.getAge());
    }
}