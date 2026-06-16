/*package OopsConcepts;

# JAVA CONSTRUCTORS - COMPLETE INTERVIEW NOTES

## 1. What is a Constructor?

A Constructor is a special member of a class that is automatically invoked when an object is created.

The primary purpose of a constructor is to initialize the object.

### Example

```java
class Employee {

    Employee() {
        System.out.println("Constructor Called");
    }
}
```

```java
Employee emp = new Employee();
```

Output:

```text
Constructor Called
```

The constructor executes automatically when the object is created.

---

# 2. Why Do We Need Constructors?

Without constructors:

```java
Employee emp = new Employee();

emp.name = "Ujjwal";
emp.age = 27;
```

Using constructors:

```java
Employee emp = new Employee("Ujjwal", 27);
```

Benefits:

* Automatic object initialization
* Cleaner code
* Better readability
* Less repetitive code
* Better maintainability

---

# 3. Characteristics of Constructors

1. Constructor name must be exactly the same as the class name.
2. Constructors do not have a return type.
3. Constructors execute automatically.
4. Constructors can be overloaded.
5. Constructors cannot be overridden.
6. Constructors cannot be static.
7. Constructors cannot be final.
8. Constructors can have access modifiers.

---

# 4. Constructor vs Method

| Constructor             | Method                  |
| ----------------------- | ----------------------- |
| Same name as class      | Any valid name          |
| No return type          | Has return type         |
| Executes automatically  | Called explicitly       |
| Used for initialization | Used for business logic |

Constructor Example:

```java
Employee() {
}
```

Method Example:

```java
void display() {
}
```

---

# 5. Types of Constructors

## Default Constructor

Automatically provided by JVM if no constructor is written.

```java
class Employee {

}
```

JVM internally provides:

```java
Employee() {

}
```

Important:

If you write even one constructor, JVM stops creating the default constructor.

---

## No-Argument Constructor

Written by programmer.

```java
Employee() {

    System.out.println("Employee Created");
}
```

Difference:

Default Constructor:

* Created by JVM

No-Argument Constructor:

* Created by programmer

---

## Parameterized Constructor

Accepts parameters.

```java
Employee(String name, int age) {

    this.name = name;
    this.age = age;
}
```

Usage:

```java
Employee emp =
        new Employee("Ujjwal", 27);
```

Benefits:

* Dynamic initialization
* Better flexibility
* Cleaner code

---

# 6. Object Creation Process

When:

```java
Employee emp = new Employee();
```

is executed:

### Step 1

Class is loaded into JVM.

### Step 2

Memory is allocated in Heap.

### Step 3

Instance variables receive default values.

| Data Type | Default Value |
| --------- | ------------- |
| int       | 0             |
| double    | 0.0           |
| boolean   | false         |
| String    | null          |

### Step 4

Constructor executes.

### Step 5

Reference variable stores object address.

---

# 7. Stack Memory vs Heap Memory

## Stack Memory

Stores:

* Reference Variables
* Local Variables

Example:

```java
Employee emp;
```

## Heap Memory

Stores:

* Objects
* Instance Variables

Example:

```java
new Employee();
```

---

# 8. this Keyword

Used to refer to current class instance variables.

Example:

```java
class Employee {

    String name;

    Employee(String name) {

        this.name = name;
    }
}
```

Explanation:

```java
this.name = name;
```

Left Side:

* Instance Variable

Right Side:

* Constructor Parameter

---

# 9. Constructor Overloading

Creating multiple constructors with different parameter lists.

Example:

```java
Employee() {

}

Employee(String name) {

}

Employee(String name, int age) {

}
```

Benefits:

* Multiple ways to create objects
* Better flexibility
* Cleaner design

Java identifies overloaded constructors based on:

* Number of parameters
* Type of parameters
* Order of parameters

---

# 10. Constructor Chaining

Calling one constructor from another constructor.

Example:

```java
Employee() {

    this("Ujjwal");
}

Employee(String name) {

    System.out.println(name);
}
```

Benefits:

* Code reuse
* Avoid duplicate code
* Better maintainability

---

# 11. this()

Used to call another constructor within the same class.

Example:

```java
Employee() {

    this("Java");
}
```

Rules:

1. Must be the first statement.
2. Used only inside constructors.
3. Cannot be used with super() in the same constructor.

---

# 12. super()

Used to call parent class constructor.

Example:

```java
class Parent {

    Parent() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    Child() {

        super();
    }
}
```

Purpose:

* Initialize parent data
* Execute parent constructor

---

# 13. Constructor Execution Order

Example:

```java
class Parent {

    Parent() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    Child() {

        System.out.println("Child");
    }
}
```

Output:

```text
Parent
Child
```

Parent constructor always executes first.

---

# 14. Private Constructor

A constructor can be private.

Example:

```java
private Employee() {

}
```

Uses:

* Singleton Pattern
* Restrict object creation
* Utility classes

---

# 15. Can Constructors Be Overloaded?

Yes.

Example:

```java
Employee()

Employee(String name)

Employee(String name, int age)
```

---

# 16. Can Constructors Be Overridden?

No.

Reason:

Constructors are not inherited.

Overriding requires inheritance.

---

# 17. Can Constructors Be Static?

No.

Invalid:

```java
static Employee() {

}
```

Compilation Error.

---

# 18. Can Constructors Be Final?

No.

Invalid:

```java
final Employee() {

}
```

Compilation Error.

---

# 19. Real-Time Selenium POM Example

```java
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
}
```

Usage:

```java
LoginPage loginPage =
        new LoginPage(driver);
```

Why Used?

* Driver Initialization
* Dependency Injection
* Reusability
* Better Framework Design

---

# 20. Frequently Asked Interview Questions

1. What is a constructor?
2. Why do we need constructors?
3. Constructor vs Method?
4. What is a default constructor?
5. What is a no-argument constructor?
6. What is a parameterized constructor?
7. What is constructor overloading?
8. Can constructors be overloaded?
9. Can constructors be overridden?
10. Can constructors be static?
11. Can constructors be final?
12. What is constructor chaining?
13. What is this()?
14. What is super()?
15. What is the order of constructor execution?
16. What happens internally during object creation?
17. Why are constructors used in Selenium POM?

---

# Revision Checklist

* [ ] Default Constructor
* [ ] No-Argument Constructor
* [ ] Parameterized Constructor
* [ ] this Keyword
* [ ] Constructor Overloading
* [ ] Constructor Chaining
* [ ] this()
* [ ] super()
* [ ] Private Constructor
* [ ] Constructor Execution Order
* [ ] Stack vs Heap Memory
* [ ] Selenium POM Constructor


public class ConstructorNotes {

}*/
