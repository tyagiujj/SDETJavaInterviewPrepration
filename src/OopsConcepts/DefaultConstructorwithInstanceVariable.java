package OopsConcepts;

public class DefaultConstructorwithInstanceVariable {

    String name;
    int age;

    DefaultConstructorwithInstanceVariable() {

        name = "Ujjwal";
        age = 25;
    }

    void display() {

        System.out.println("Name of the Employee is : " + name);
        System.out.println("Age of the Employee is : " + age);
    }

    public static void main(String[] args) {

        DefaultConstructorwithInstanceVariable obj =
                new DefaultConstructorwithInstanceVariable();

        obj.display();
    }
}