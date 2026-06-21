package OopsConcepts;

/*
===============================================================================
TOPIC: COMPLETE OOPS CONCEPTS IN JAVA (SDET INTERVIEW NOTES)
===============================================================================

OOPS = Object Oriented Programming System

Java is a fully object-oriented programming language (except primitives).

OOPS is based on 4 MAIN PILLARS:

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

===============================================================================
======================== 1. CLASS & OBJECT ================================
===============================================================================

WHAT IS CLASS?
-------------------------------------------------------------------------------
A class is a blueprint or template for creating objects.

It defines:
- Variables (state)
- Methods (behavior)

Example:
class Car {
    String color;
    void drive() {}
}

-------------------------------------------------------------------------------
WHAT IS OBJECT?
-------------------------------------------------------------------------------
An object is an instance of a class.

It is a real-world entity created from class.

Example:
Car c = new Car();

-------------------------------------------------------------------------------
WHY CLASS AND OBJECT?
-------------------------------------------------------------------------------
- Code reusability
- Real world modeling
- Memory allocation happens at object level

-------------------------------------------------------------------------------
REAL TIME EXAMPLE:
-------------------------------------------------------------------------------
Class → Employee
Object → Ujjwal, Rahul, Amit

===============================================================================
======================== 2. CONSTRUCTOR ================================
===============================================================================

WHAT IS CONSTRUCTOR?
-------------------------------------------------------------------------------
A constructor is a special method used to initialize objects.

Rules:
- Same name as class
- No return type
- Called automatically when object is created

-------------------------------------------------------------------------------
TYPES OF CONSTRUCTOR:
-------------------------------------------------------------------------------
1. Default Constructor (compiler provided)
2. No-arg Constructor
3. Parameterized Constructor
4. Constructor Overloading

-------------------------------------------------------------------------------
WHY CONSTRUCTOR?
-------------------------------------------------------------------------------
- Object initialization
- Memory setup
- Avoid method calling manually

-------------------------------------------------------------------------------
THIS KEYWORD:
-------------------------------------------------------------------------------
Used to refer current class instance variable.

Example:
this.name = name;

===============================================================================
======================== 3. ENCAPSULATION ================================
===============================================================================

WHAT IS ENCAPSULATION?
-------------------------------------------------------------------------------
Encapsulation is binding data and methods into a single unit and restricting
direct access using private variables.

Formula:
Encapsulation = Data Hiding + Getter + Setter

-------------------------------------------------------------------------------
WHY ENCAPSULATION?
-------------------------------------------------------------------------------
- Data security
- Validation
- Maintainability
- Code flexibility

-------------------------------------------------------------------------------
HOW TO ACHIEVE?
-------------------------------------------------------------------------------
1. Make variables private
2. Provide public getters
3. Provide public setters

-------------------------------------------------------------------------------
REAL TIME EXAMPLE:
-------------------------------------------------------------------------------
ATM Machine

User cannot directly access balance.

===============================================================================
======================== 4. INHERITANCE ================================
===============================================================================

WHAT IS INHERITANCE?
-------------------------------------------------------------------------------
One class acquires properties and methods of another class using extends.

-------------------------------------------------------------------------------
WHY INHERITANCE?
-------------------------------------------------------------------------------
- Code reusability
- Avoid duplication
- Easy maintenance

-------------------------------------------------------------------------------
TYPES:
-------------------------------------------------------------------------------
1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance

NOT SUPPORTED:
- Multiple Inheritance (with classes)

-------------------------------------------------------------------------------
WHY NOT MULTIPLE INHERITANCE?
-------------------------------------------------------------------------------
Because of DIAMOND PROBLEM (ambiguity issue)

-------------------------------------------------------------------------------
REAL TIME EXAMPLE:
-------------------------------------------------------------------------------
WebDriver → RemoteWebDriver → ChromeDriver

===============================================================================
======================== 5. POLYMORPHISM ================================
===============================================================================

WHAT IS POLYMORPHISM?
-------------------------------------------------------------------------------
Poly = Many
Morphism = Forms

One thing many forms.

-------------------------------------------------------------------------------
TYPES:
-------------------------------------------------------------------------------
1. Compile Time Polymorphism (Method Overloading)
2. Runtime Polymorphism (Method Overriding)

-------------------------------------------------------------------------------
METHOD OVERLOADING:
-------------------------------------------------------------------------------
Same method name but different parameters.

Example:
add(int a, int b)
add(int a, int b, int c)

Rules:
- Same method name
- Different parameters
- Happens in same class

-------------------------------------------------------------------------------
METHOD OVERRIDING:
-------------------------------------------------------------------------------
Same method in parent and child class with same signature.

Rules:
- Same method name
- Same parameters
- Requires inheritance

-------------------------------------------------------------------------------
UPCASTING:
-------------------------------------------------------------------------------
Parent reference pointing to child object.

Example:
Parent p = new Child();

-------------------------------------------------------------------------------
DYNAMIC METHOD DISPATCH:
-------------------------------------------------------------------------------
At runtime JVM decides which method to call.

===============================================================================
======================== 6. ABSTRACTION ================================
===============================================================================

WHAT IS ABSTRACTION?
-------------------------------------------------------------------------------
Hiding implementation details and showing only functionality.

WHAT = User sees
HOW = Hidden

-------------------------------------------------------------------------------
HOW TO ACHIEVE?
-------------------------------------------------------------------------------
1. Abstract Class
2. Interface

-------------------------------------------------------------------------------
ABSTRACT CLASS:
-------------------------------------------------------------------------------
- Can have abstract + concrete methods
- Cannot create object
- Can have constructor
- Supports partial abstraction

-------------------------------------------------------------------------------
ABSTRACT METHOD:
-------------------------------------------------------------------------------
Method without body.

abstract void sound();

-------------------------------------------------------------------------------
RULES:
-------------------------------------------------------------------------------
- If abstract method exists → class must be abstract
- Child must override abstract methods

-------------------------------------------------------------------------------
100% ABSTRACTION:
-------------------------------------------------------------------------------
Not possible with abstract class

===============================================================================
======================== 7. INTERFACE ================================
===============================================================================

WHAT IS INTERFACE?
-------------------------------------------------------------------------------
Interface is blueprint of class which contains only abstract methods.

It defines WHAT to do.

-------------------------------------------------------------------------------
WHY INTERFACE?
-------------------------------------------------------------------------------
- 100% abstraction
- Multiple inheritance
- Loose coupling
- Framework design

-------------------------------------------------------------------------------
RULES:
-------------------------------------------------------------------------------
- All methods public abstract (default)
- All variables public static final
- No constructor allowed
- Cannot create object

-------------------------------------------------------------------------------
MULTIPLE INHERITANCE:
-------------------------------------------------------------------------------
interface A {}
interface B {}
class C implements A, B {}

-------------------------------------------------------------------------------
REAL TIME EXAMPLE:
-------------------------------------------------------------------------------
WebDriver driver = new ChromeDriver();

-------------------------------------------------------------------------------
WHY SELENIUM USES INTERFACE?
-------------------------------------------------------------------------------
- Easy browser switching
- Loose coupling
- Framework flexibility

===============================================================================
======================== DIFFERENCES ================================
===============================================================================

-------------------------------------------------------------------------------
CLASS VS OBJECT
-------------------------------------------------------------------------------
Class → Blueprint
Object → Real entity

-------------------------------------------------------------------------------
METHOD OVERLOADING VS OVERRIDING
-------------------------------------------------------------------------------
Overloading:
- Same method name
- Different parameters
- Compile time

Overriding:
- Same method name
- Same parameters
- Runtime

-------------------------------------------------------------------------------
ABSTRACT CLASS VS INTERFACE
-------------------------------------------------------------------------------
Abstract Class:
- Partial abstraction
- Can have constructor
- Can have variables
- Single inheritance

Interface:
- 100% abstraction
- No constructor
- Only constants
- Multiple inheritance

-------------------------------------------------------------------------------
ENCAPSULATION VS ABSTRACTION
-------------------------------------------------------------------------------
Encapsulation:
- Data hiding
- Uses private variables

Abstraction:
- Hides implementation
- Focus on functionality

===============================================================================
======================== SELENIUM REAL TIME ================================
===============================================================================

WebDriver driver = new ChromeDriver();

Concepts used:
- Interface (WebDriver)
- Abstraction
- Polymorphism
- Upcasting

===============================================================================
======================== FINAL SUMMARY ================================
===============================================================================

OOPS is foundation for:
- Selenium Framework
- API Automation
- Java Backend Testing
- SDET Interviews

MASTER THESE:
✔ Class & Object
✔ Constructor
✔ Encapsulation
✔ Inheritance
✔ Polymorphism
✔ Abstraction
✔ Interface

===============================================================================
END OF NOTES
===============================================================================
*/