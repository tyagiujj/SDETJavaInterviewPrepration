package OopsConcepts;

class Parent {

    void display() {
        System.out.println("Parent Display");
    }
}

class Child extends Parent {

    @Override
    void display() {
        System.out.println("Child Display");
    }

    void childMethod() {
        System.out.println("Child Specific Method");
    }
}

public class RunTimePolymorphism {

    public static void main(String[] args) {

        Child obj = new Child();

        obj.display();      // Overridden Method
        obj.childMethod();  // Child Method
    }
}