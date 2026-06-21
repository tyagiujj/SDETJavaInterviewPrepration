package OopsConcepts;

/*
===============================================================================
TOPIC: ENCAPSULATION IN JAVA
===============================================================================

1. WHAT IS ENCAPSULATION?
-------------------------------------------------------------------------------
Encapsulation is the process of binding data (variables) and methods
(functions) into a single unit (class) and restricting direct access
to the data by making variables private.

Definition:
Encapsulation = Data Hiding + Controlled Access

-------------------------------------------------------------------------------

2. WHY DO WE USE ENCAPSULATION?
-------------------------------------------------------------------------------

1. Data Security
   - Prevents unauthorized access to variables.

2. Data Hiding
   - Internal implementation remains hidden.

3. Validation
   - Invalid data can be prevented.

4. Better Maintainability
   - Easy to modify code without affecting users.

5. Reusability
   - Classes can be reused in multiple projects.

-------------------------------------------------------------------------------

3. HOW TO ACHIEVE ENCAPSULATION?
-------------------------------------------------------------------------------

Step 1:
Make variables private.

Example:
private String name;

Step 2:
Create public getter methods.

Example:
public String getName() {
    return name;
}

Step 3:
Create public setter methods.

Example:
public void setName(String name) {
    this.name = name;
}

-------------------------------------------------------------------------------

4. WHAT IS DATA HIDING?
-------------------------------------------------------------------------------

Data hiding means restricting direct access to data by making
variables private.

Example:

private String name;

Outside class:
obj.name = "Ujjwal";  // Not Allowed

-------------------------------------------------------------------------------

5. DIFFERENCE BETWEEN ENCAPSULATION AND DATA HIDING
-------------------------------------------------------------------------------

DATA HIDING:
- Hides data using private variables.

ENCAPSULATION:
- Hides data + provides controlled access using methods.

Formula:

Data Hiding = private variables

Encapsulation = private variables + getters/setters

-------------------------------------------------------------------------------

6. WHAT ARE GETTERS?
-------------------------------------------------------------------------------

Getter methods are used to retrieve data.

Example:

public String getName() {
    return name;
}

-------------------------------------------------------------------------------

7. WHAT ARE SETTERS?
-------------------------------------------------------------------------------

Setter methods are used to update data.

Example:

public void setName(String name) {
    this.name = name;
}

-------------------------------------------------------------------------------

8. ADVANTAGES OF ENCAPSULATION
-------------------------------------------------------------------------------

1. Security
2. Flexibility
3. Maintainability
4. Reusability
5. Data Validation
6. Code Readability

-------------------------------------------------------------------------------

9. REAL-TIME EXAMPLE
-------------------------------------------------------------------------------

ATM MACHINE

User can:
- Withdraw money
- Deposit money
- Check balance

User cannot:
- Directly modify account balance

This is Encapsulation.

-------------------------------------------------------------------------------

10. SELENIUM REAL-TIME EXAMPLE
-------------------------------------------------------------------------------

Page Object Model (POM)

private WebElement username;

public void enterUsername(String user) {
    username.sendKeys(user);
}

Data is hidden and accessible through methods.

-------------------------------------------------------------------------------

11. API TESTING REAL-TIME EXAMPLE
-------------------------------------------------------------------------------

POJO Class

private String name;
private int age;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

Used in:
- Rest Assured
- Serialization
- Deserialization

-------------------------------------------------------------------------------

12. WHAT IS A POJO CLASS?
-------------------------------------------------------------------------------

POJO = Plain Old Java Object

Characteristics:

1. Private Variables
2. Public Getters
3. Public Setters
4. No Business Logic

Example:

private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

-------------------------------------------------------------------------------

13. INTERVIEW QUESTIONS AND ANSWERS
-------------------------------------------------------------------------------

Q1. What is Encapsulation?

Answer:
Encapsulation is the process of binding data and methods into a
single unit and restricting direct access using private variables.

-------------------------------------------------------------------------------

Q2. How do you achieve Encapsulation?

Answer:
1. Make variables private.
2. Create public getters.
3. Create public setters.

-------------------------------------------------------------------------------

Q3. Why are variables private?

Answer:
To prevent direct access and achieve data hiding.

-------------------------------------------------------------------------------

Q4. Why are getters and setters public?

Answer:
To provide controlled access to private variables.

-------------------------------------------------------------------------------

Q5. What is Data Hiding?

Answer:
Data hiding is restricting direct access to data using private
access modifiers.

-------------------------------------------------------------------------------

Q6. Difference between Data Hiding and Encapsulation?

Answer:

Data Hiding:
Only hides data.

Encapsulation:
Hides data and provides controlled access.

-------------------------------------------------------------------------------

Q7. Can we achieve Encapsulation without getters and setters?

Answer:
Yes, but getters and setters are the most common way.

-------------------------------------------------------------------------------

Q8. What is a POJO Class?

Answer:
POJO stands for Plain Old Java Object.

Contains:
- Private Variables
- Public Getters
- Public Setters

-------------------------------------------------------------------------------

Q9. What are the benefits of Encapsulation?

Answer:
1. Security
2. Validation
3. Reusability
4. Maintainability
5. Flexibility

-------------------------------------------------------------------------------

Q10. How is Encapsulation used in Selenium?

Answer:
Encapsulation is used in:

1. Page Object Model
2. Test Data Classes
3. Utility Classes
4. Configuration Classes

-------------------------------------------------------------------------------

Q11. How is Encapsulation used in API Automation?

Answer:
POJO classes use encapsulation for request and response payloads.

-------------------------------------------------------------------------------

Q12. Which access modifier is mostly used in Encapsulation?

Answer:
private

-------------------------------------------------------------------------------

Q13. Is Encapsulation one of the OOP pillars?

Answer:
Yes.

Four Pillars:

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

-------------------------------------------------------------------------------

Q14. Can private variables be accessed directly?

Answer:
No.

They can only be accessed through methods.

-------------------------------------------------------------------------------

Q15. What is the biggest advantage of Encapsulation?

Answer:
Data Security and Data Validation.

===============================================================================
PRACTICAL PROGRAM
===============================================================================
*/

public class EncapsulationConcepts {

    // Private Variables (Data Hiding)

    private String name;
    private String city;
    private String department;
    private int empId;

    // Getter Methods

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDepartment() {
        return department;
    }

    public int getEmpId() {
        return empId;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmpId(int empId) {

        if(empId > 0) {
            this.empId = empId;
        }
        else {
            System.out.println("Invalid Employee Id");
        }
    }

    public static void main(String[] args) {

        EncapsulationConcepts emp =
                new EncapsulationConcepts();

        emp.setName("Ujjwal Tyagi");
        emp.setCity("Noida");
        emp.setDepartment("QA Automation");
        emp.setEmpId(101);

        System.out.println("Name : " + emp.getName());
        System.out.println("City : " + emp.getCity());
        System.out.println("Department : " + emp.getDepartment());
        System.out.println("Employee Id : " + emp.getEmpId());
    }
}