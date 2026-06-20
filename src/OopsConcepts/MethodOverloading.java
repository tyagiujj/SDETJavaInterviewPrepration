/*
===============================================================================
TOPIC: METHOD OVERLOADING (COMPILE-TIME POLYMORPHISM)
===============================================================================

1. What is Method Overloading?

Method Overloading means creating multiple methods
with the same name but different parameter lists.

Example:

display()

display(int a, int b)

display(int a, int b, int c)

Java identifies overloaded methods based on:

1. Number of Parameters
2. Type of Parameters
3. Order of Parameters

===============================================================================

2. Why Method Overloading?

- Improves readability.
- Provides flexibility.
- Allows same operation with different inputs.

===============================================================================

3. Rules of Method Overloading

✓ Method name must be same.

✓ Parameters must be different.

✓ Return type can be same or different.

✓ Inheritance is not required.

===============================================================================

4. Can We Overload Methods By Changing Only Return Type?

NO

Wrong:

int add()

void add()

Compilation Error

===============================================================================

5. Types of Overloading

1. Different Number of Parameters

display()
display(int a)

------------------------------------------------

2. Different Data Types

display(int a)
display(String name)

------------------------------------------------

3. Different Parameter Order

display(int a, String name)

display(String name, int a)

===============================================================================

6. Is Method Overloading Compile Time or Runtime?

Compile Time

Reason:

Compiler decides which method to call during compilation.

===============================================================================

7. Can Static Methods Be Overloaded?

YES

===============================================================================

8. Can Constructors Be Overloaded?

YES

===============================================================================

9. Benefits

✓ Code Reusability

✓ Better Readability

✓ Flexibility

✓ Easy Maintenance

===============================================================================

INTERVIEW QUESTIONS

Q. What is Method Overloading?

Q. Why is it called Compile-Time Polymorphism?

Q. Can methods be overloaded by changing only return type?

Q. Can static methods be overloaded?

Q. Can constructors be overloaded?

Q. Difference between Method Overloading and Overriding?

===============================================================================
*/

package OopsConcepts;

public class MethodOverloading {

    String name = "Ujjwal";
    int age = 27;

    void display() {

        System.out.println("Name of the Employee is : " + name);
        System.out.println("Age of the Employee is : " + age);
    }

    void display(int a, int b) {

        System.out.println("Sum of a and b is : " + (a + b));
    }

    void display(int a, int b, int c) {

        System.out.println("Multiplication of a, b and c is : "
                + (a * b * c));
    }

    public static void main(String[] args) {

        MethodOverloading mob =
                new MethodOverloading();

        mob.display();
        mob.display(10, 20);
        mob.display(5, 4, 3);
    }
}