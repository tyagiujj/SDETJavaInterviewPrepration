
 /*

# TOPIC: CLASS AND OBJECT (CORE JAVA)

1. WHAT IS A CLASS?

---

A Class is a blueprint, template, or user-defined data type used to create
objects.

A class contains:

* Variables (Data Members / Instance Variables)
* Methods (Behavior)
* Constructors
* Blocks

Example:
class Employee {
String name;
int age;
}

Employee is a Class.

2. WHAT IS AN OBJECT?

---

An Object is an instance of a class.

When memory is allocated for a class and it is instantiated using the
'new' keyword, an object is created.

Example:
Employee emp = new Employee();

Here:

* Employee = Class
* emp = Reference Variable
* new Employee() = Object Creation

3. WHY DO WE NEED A CLASS?

---

* To represent real-world entities.
* To achieve code reusability.
* To organize data and methods.
* To implement Object-Oriented Programming concepts.

4. WHY DO WE NEED OBJECTS?

---

* To access instance variables.
* To access instance methods.
* To store different data separately.

Example:
Employee emp1 = new Employee();
Employee emp2 = new Employee();

Both objects can store different data.

5. WHAT IS A REFERENCE VARIABLE?

---

A reference variable stores the address of an object.

Example:
Employee emp = new Employee();

'emp' is a reference variable.

6. WHAT HAPPENS INTERNALLY WHEN AN OBJECT IS CREATED?

---

Step 1:
JVM loads the class.

Step 2:
Memory is allocated in Heap Memory.

Step 3:
Instance variables get default values.

Example:
int = 0
String = null
boolean = false

Step 4:
Constructor is executed (if available).

Step 5:
Reference variable stores object address in Stack Memory.

7. MEMORY ALLOCATION

---

Stack Memory:

* Stores Reference Variables
* Example: emp

Heap Memory:

* Stores Actual Objects
* Example: Employee Object

8. SYNTAX OF OBJECT CREATION

---

ClassName referenceVariable = new ClassName();

Example:
Employee emp = new Employee();

9. INSTANCE VARIABLES

---

Variables declared inside the class but outside methods.

Example:
String Name;
String City;
int Age;

These belong to an object.

10. INSTANCE METHODS

---

Methods declared inside a class but outside another method.

Example:
void emp_details() {
}

Instance methods are called using an object.

11. HOW TO ACCESS INSTANCE VARIABLES?

---

Using Object Reference.

Example:
emp1.Name = "Ujjwal";
emp1.City = "Noida";

12. HOW TO ACCESS INSTANCE METHODS?

---

Using Object Reference.

Example:
emp1.emp_details();

13. DIFFERENCE BETWEEN CLASS AND OBJECT

---

CLASS

* Blueprint
* Logical Entity
* No Memory Allocation

OBJECT

* Instance of Class
* Physical Entity
* Memory Allocated in Heap

14. CAN WE CREATE MULTIPLE OBJECTS OF A CLASS?

---

Yes.

Example:
Employee emp1 = new Employee();
Employee emp2 = new Employee();
Employee emp3 = new Employee();

15. CAN A CLASS EXIST WITHOUT AN OBJECT?

---

Yes.

A class can exist without creating any object.

16. CAN AN OBJECT EXIST WITHOUT A CLASS?

---

No.

Every object must belong to a class.

17. WHAT IS THE 'new' KEYWORD?

---

The 'new' keyword:

* Allocates memory in Heap.
* Creates an object.
* Returns object reference.

18. INTERVIEW QUESTIONS

---

Q. What is a Class?
A. A blueprint used to create objects.

Q. What is an Object?
A. An instance of a class.

Q. Difference between Class and Object?
A. Class is a blueprint, Object is an instance.

Q. What is a Reference Variable?
A. Variable storing object address.

Q. Where are objects stored?
A. Heap Memory.

Q. Where are references stored?
A. Stack Memory.

Q. What is the purpose of the new keyword?
A. To create objects and allocate memory.

Q. Can we create multiple objects?
A. Yes.

Q. Can a class exist without objects?
A. Yes.

Q. Can an object exist without a class?
A. No.

===============================================================================
PRACTICAL IMPLEMENTATION OF CLASS AND OBJECT
============================================

*/

package OopsConcepts;

public class ClassAndObject {

    String Name;
    String City;
    int Age;
    int rollno;
    String Department;
    

    void emp_details() {
        System.out.println("Name of the employee is : " + Name);
        System.out.println("City of the employee is : " + City);
        System.out.println("Age of the employee is : " + Age);
        System.out.println("Roll no of the employee is : " + rollno);
        System.out.println("Department of the employee is : " + Department);
       
    }

    public static void main(String[] args) {

     
        ClassAndObject emp1 = new ClassAndObject();


        emp1.Name = "Ujjwal Tyagi";
        emp1.City = "Noida";
        emp1.Age = 27;
        emp1.rollno = 101;
        emp1.Department = "QA Automation";
     

       
        emp1.emp_details();
    }
}