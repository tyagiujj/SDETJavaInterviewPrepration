package OopsConcepts;

/*
===============================================================================
TOPIC: METHOD OVERLOADING vs METHOD OVERRIDING
===============================================================================

1. METHOD OVERLOADING (Compile Time Polymorphism)
-------------------------------------------------------------------------------
Definition:
Method Overloading means having multiple methods in the SAME class
with the SAME NAME but DIFFERENT PARAMETERS.

Rules:
- Same method name
- Different parameters (number/type/order)
- Return type can be same or different
- Happens in same class
- No inheritance required

Example:
show()
show(int a)
show(int a, int b)

Decision Time:
Compile Time (Compiler decides method call)

-------------------------------------------------------------------------------

2. METHOD OVERRIDING (Runtime Polymorphism)
-------------------------------------------------------------------------------
Definition:
Method Overriding means child class provides its own implementation
of parent class method with SAME NAME and SAME PARAMETERS.

Rules:
- Same method name
- Same parameters (number/type/order)
- Same return type
- Requires inheritance
- Happens in Parent & Child class
- Uses @Override annotation

Decision Time:
Runtime (JVM decides method call)

===============================================================================
DIFFERENCE BETWEEN OVERLOADING & OVERRIDING
===============================================================================

| Feature            | Overloading                     | Overriding                     |
|-------------------|--------------------------------|--------------------------------|
| Method Name       | Same                           | Same                           |
| Parameters        | Different                      | Same                           |
| Class             | Same Class                     | Parent & Child                 |
| Inheritance       | Not Required                   | Required                       |
| Polymorphism Type | Compile Time                   | Runtime                        |
| Binding           | Early Binding                  | Late Binding                   |
| Return Type       | Can be different               | Must be same (or covariant)    |

===============================================================================
REAL TIME EXAMPLES
===============================================================================

Overloading Example:
- print()
- print(int a)
- print(String name)

Overriding Example:
- WebDriver driver = new ChromeDriver();
- driver.get();

===============================================================================
*/

public class OverloadingVsOverriding {

    // =========================
    // METHOD OVERLOADING
    // =========================

    void show() {
        System.out.println("No Parameter Method");
    }

    void show(int a) {
        System.out.println("One Parameter: " + a);
    }

    void show(int a, int b) {
        System.out.println("Two Parameters Sum: " + (a + b));
    }

    // =========================
    // MAIN METHOD
    // =========================

    public static void main(String[] args) {

        OverloadingVsOverriding obj =
                new OverloadingVsOverriding();

        // Method Overloading Example
        obj.show();
        obj.show(10);
        obj.show(10, 20);

        System.out.println("-----------------------------");

        // METHOD OVERRIDING EXAMPLE (RUNTIME POLYMORPHISM)

        BaseClass ref = new DerivedClass();
        ref.display();
    }
}

// =========================
// METHOD OVERRIDING CLASSES
// =========================

class BaseClass {

    void display() {
        System.out.println("Base Class Display Method");
    }
}

class DerivedClass extends BaseClass {

    @Override
    void display() {
        System.out.println("Derived Class Display Method");
    }
}