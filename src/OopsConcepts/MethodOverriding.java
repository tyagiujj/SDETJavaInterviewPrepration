package OopsConcepts;

class Dog {

    void display() {

        System.out.println("Dog Barks");
    }
}

class Cat extends Dog {

    @Override
    void display() {

        System.out.println("Cat Meows");
    }
}

public class MethodOverriding {

    public static void main(String[] args) {

        Dog obj = new Cat();
        Dog obj1=new Dog();

        obj.display();
        obj1.display();
    }
}