package OopsConcepts;

/*
===============================================================================
TOPIC: INHERITANCE IN JAVA (SDET INTERVIEW)
===============================================================================

DEFINITION:
Inheritance is an OOP concept where a child class acquires properties
and methods of parent class using "extends" keyword.

WHY USE:
- Code Reusability
- Reduce duplication
- Easy maintenance
- Framework design (Selenium, TestNG)

TYPES:
1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance

NOTE:
Java does NOT support multiple inheritance using classes.

REAL TIME EXAMPLE:
WebDriver → RemoteWebDriver → ChromeDriver
===============================================================================
*/

// ======================= PARENT CLASS =======================
class Parent1 {

    String name = "Ujjwal";
    int age = 27;

    void displayParent() {
        System.out.println("Parent Class Method");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// ======================= CHILD CLASS =======================
class Child1 extends Parent1 {

    String city = "Noida";

    void displayChild() {
        System.out.println("Child Class Method");
        System.out.println("City: " + city);
    }
}

// ======================= MAIN CLASS =======================
public class InheritanceDemo {

    public static void main(String[] args) {

        System.out.println("===== CHILD OBJECT =====");

        Child1 obj = new Child1();

        // Parent class method + variables
        obj.displayParent();

        // Child class method + variables
        obj.displayChild();

        System.out.println("-----------------------");

        System.out.println("===== PARENT REFERENCE (UPCASTING) =====");

        Parent1 p = new Child1();

        p.displayParent();
    }
}