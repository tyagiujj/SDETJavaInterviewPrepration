package TomishInterview;

class Animal {

    String name;

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println(name + " is barking");
    }
}

public class Inheritance {

    public static void main(String[] args) {

        Dog dobj = new Dog();

        dobj.name = "Tommy";

        dobj.eat();
        dobj.sleep();
        dobj.bark();
    }
}