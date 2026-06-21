package OopsConcepts;

/*
===============================================================================
TOPIC: ABSTRACTION & INTERFACE IN JAVA (SDET INTERVIEW NOTES)
===============================================================================

###############################################################################
============================ 1. ABSTRACTION ===================================
###############################################################################

-------------------------------------------------------------------------------
WHAT IS ABSTRACTION?
-------------------------------------------------------------------------------
Abstraction is an OOP concept in Java that hides implementation details and
shows only essential features to the user.

In simple terms:
👉 Abstraction = WHAT to do, not HOW to do

-------------------------------------------------------------------------------
REAL LIFE EXAMPLE:
-------------------------------------------------------------------------------
ATM Machine:

User knows:
- Withdraw money
- Deposit money
- Check balance

User does NOT know:
- Database connection
- Transaction processing
- Security encryption
- Backend logic

👉 This hidden logic is ABSTRACTION

-------------------------------------------------------------------------------
WHY WE USE ABSTRACTION?
-------------------------------------------------------------------------------
1. To reduce complexity
2. To improve security
3. To hide internal implementation
4. To improve maintainability
5. To achieve loose coupling
6. To design frameworks (Selenium, Spring, etc.)

-------------------------------------------------------------------------------
HOW TO ACHIEVE ABSTRACTION?
-------------------------------------------------------------------------------
1. Abstract Class
2. Interface

-------------------------------------------------------------------------------
WHAT IS ABSTRACT CLASS?
-------------------------------------------------------------------------------
An abstract class is a class declared using "abstract" keyword.

It is used to achieve partial abstraction.

-------------------------------------------------------------------------------
CHARACTERISTICS OF ABSTRACT CLASS:
-------------------------------------------------------------------------------
✔ Can have abstract methods (without body)
✔ Can have concrete methods (with body)
✔ Can have variables
✔ Can have constructors
✔ Can have static methods
✔ Can have final methods

❌ Cannot create object directly

-------------------------------------------------------------------------------
WHAT IS ABSTRACT METHOD?
-------------------------------------------------------------------------------
A method without body is called abstract method.

Example:
abstract void sound();

-------------------------------------------------------------------------------
RULES OF ABSTRACT CLASS:
-------------------------------------------------------------------------------
1. If class has abstract method → class must be abstract
2. Abstract class cannot be instantiated
3. Child class must implement abstract methods
4. If not implemented → child must be abstract
5. Abstract method cannot be final or private

-------------------------------------------------------------------------------
CAN ABSTRACT CLASS HAVE CONSTRUCTOR?
-------------------------------------------------------------------------------
YES

Reason:
To initialize common variables for child classes.

-------------------------------------------------------------------------------
CAN ABSTRACT CLASS HAVE VARIABLES?
-------------------------------------------------------------------------------
YES

-------------------------------------------------------------------------------
CAN ABSTRACT CLASS HAVE STATIC METHODS?
-------------------------------------------------------------------------------
YES

-------------------------------------------------------------------------------
CAN ABSTRACT METHOD BE FINAL?
-------------------------------------------------------------------------------
NO

Reason:
Final methods cannot be overridden.

-------------------------------------------------------------------------------
CAN ABSTRACT METHOD BE PRIVATE?
-------------------------------------------------------------------------------
NO

Reason:
Private methods cannot be inherited.

-------------------------------------------------------------------------------
PARTIAL ABSTRACTION:
-------------------------------------------------------------------------------
Abstract class = Partial Abstraction
Because it contains both:
- Abstract methods
- Concrete methods

===============================================================================
ABSTRACT CLASS PRACTICAL PROGRAM
===============================================================================
*/

abstract class Animal {

    // Abstract Method (No body)
    abstract void sound();

    // Concrete Method
    void sleep() {
        System.out.println("Animal is sleeping");
    }

    // Constructor
    Animal() {
        System.out.println("Animal Constructor Called");
    }
}

// Child Class
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog Barks");
    }
}

/*
###############################################################################
============================ 2. INTERFACE =====================================
###############################################################################

-------------------------------------------------------------------------------
WHAT IS INTERFACE?
-------------------------------------------------------------------------------
An Interface is a blueprint of a class that contains abstract methods and
constants.

It defines:
👉 WHAT to do (not HOW to do)

-------------------------------------------------------------------------------
REAL LIFE EXAMPLE:
-------------------------------------------------------------------------------
Remote Control:

Buttons:
- Power
- Volume
- Channel

User knows WHAT buttons do

But TV decides HOW it works internally

-------------------------------------------------------------------------------
WHY INTERFACE IS USED?
-------------------------------------------------------------------------------
1. To achieve 100% abstraction
2. To achieve multiple inheritance
3. To achieve loose coupling
4. To design frameworks (Selenium)
5. To define standard rules

-------------------------------------------------------------------------------
CHARACTERISTICS OF INTERFACE:
-------------------------------------------------------------------------------
✔ All methods are public abstract (by default)
✔ All variables are public static final (by default)
✔ No constructors allowed
✔ Cannot create object
✔ Supports multiple inheritance

-------------------------------------------------------------------------------
METHODS IN INTERFACE:
-------------------------------------------------------------------------------
Before Java 8:
Only abstract methods

After Java 8:
✔ Default methods
✔ Static methods

After Java 9:
✔ Private methods allowed

-------------------------------------------------------------------------------
VARIABLES IN INTERFACE:
-------------------------------------------------------------------------------
All variables are:

public static final

Meaning:
✔ Constant values

-------------------------------------------------------------------------------
MULTIPLE INHERITANCE USING INTERFACE:
-------------------------------------------------------------------------------
Java does NOT support:

class A extends B, C ❌

But supports:

interface A {}
interface B {}

class C implements A, B {} ✔

-------------------------------------------------------------------------------
WHY JAVA DOES NOT SUPPORT MULTIPLE INHERITANCE (CLASS)?
-------------------------------------------------------------------------------
Because of DIAMOND PROBLEM:

Same method in two parent classes → ambiguity

Interface solves this problem.

===============================================================================
INTERFACE PRACTICAL PROGRAM
===============================================================================
*/

interface Vehicle {

    void start();  // abstract method
    void stop();
}

// Implementation Class
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car Starts with Key");
    }

    @Override
    public void stop() {
        System.out.println("Car Stops with Brake");
    }
}

/*
###############################################################################
============================ MAIN CLASS =======================================
###############################################################################
*/

public class AbstractionInterfaceDemo {

    public static void main(String[] args) {

        /*
        ================= ABSTRACTION =================
        */

        System.out.println("===== ABSTRACTION EXAMPLE =====");

        Animal animal = new Dog();   // Upcasting

        animal.sound();  // Dog implementation hidden
        animal.sleep();

        /*
        ================= INTERFACE =================
        */

        System.out.println("\n===== INTERFACE EXAMPLE =====");

        Vehicle vehicle = new Car();

        vehicle.start();
        vehicle.stop();
    }
}

/*
###############################################################################
============================ INTERVIEW QUESTIONS ==============================
###############################################################################

Q1. What is Abstraction?
Answer:
Abstraction is the process of hiding implementation details and showing only
essential features to the user.

-------------------------------------------------------------------------------

Q2. Why do we use Abstraction?
Answer:
- To reduce complexity
- To improve security
- To improve maintainability
- To achieve loose coupling

-------------------------------------------------------------------------------

Q3. What is Abstract Class?
Answer:
A class that contains abstract and concrete methods and cannot be instantiated.

-------------------------------------------------------------------------------

Q4. Can we create object of abstract class?
Answer:
No.

-------------------------------------------------------------------------------

Q5. What is Interface?
Answer:
Interface is a blueprint of a class that contains abstract methods and defines
WHAT to do, not HOW to do.

-------------------------------------------------------------------------------

Q6. Can Interface have constructor?
Answer:
No.

-------------------------------------------------------------------------------

Q7. Can Interface have variables?
Answer:
Yes, but they are:
public static final (constants)

-------------------------------------------------------------------------------

Q8. Difference between Abstract Class and Interface?

Abstract Class:
- Partial abstraction
- Can have constructors
- Can have concrete methods

Interface:
- 100% abstraction (traditional)
- No constructors
- Only abstract methods (mostly)

-------------------------------------------------------------------------------

Q9. Why Selenium uses Interface?

Answer:
Because WebDriver is an interface:

WebDriver driver = new ChromeDriver();

It provides:
- Flexibility
- Loose coupling
- Easy browser switching

-------------------------------------------------------------------------------

Q10. Explain WebDriver line?

WebDriver driver = new ChromeDriver();

Answer:
- WebDriver = Interface
- ChromeDriver = Class
- Upcasting + Abstraction + Polymorphism

###############################################################################
END OF NOTES
###############################################################################
*/