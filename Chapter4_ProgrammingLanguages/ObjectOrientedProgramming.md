# Object-Oriented Programming
## Overview

Object-oriented programming, or OOP, is a programming paradigm that is defined by using "objects", which can contain data and code. Data is the fields/attributes/properties of an object, and code is the method/behaviors/procedures it can complete. 

OOP typically defines its objects by classes. Classes give a layout of the fields and methods an object of that type can have. Further, objects are an instance of a class.  

## More Details and Definitions

An object in an instance of a class. This leads to:
* **Class variables** - variable belonging to the class as a whole, not just one instance/object. There is only one copy of each class variable.
    * In Java, this is a static variable for the class
* **Instance variable/attribute** - variable belonging to individual objects. Each object has its own copy of each instance variable.
* **Member variables** - Both the class and instance variables defined by a class. Basically, for an object of a class, what variables can it see.
* **Class methods** - methods belonging to the class as a whole and have access to only class variables.
    * In Java, this is static methods
* **Instance methods** - methods belonging to individual objects, and has access to instance variables for that specific object that the method is called on, as well as class variables.
* **Constructor** - method used to create an instance of a class.

Objects are often treated like a variable itself, and is easily thought of as a pointer, serving as references to a single instance within memory.

Main tenents of OOP (**refer to each idea's specific chapter**):
* **Encapsulation** - information hiding. Pack (encapsulate) data into single component and restrict access to some of the object's components. Prevent external code from being concerned with inner workings of an object.
* **Abstraction** - implementation hiding. Represent the essential features without including implementation details (abstract method implemenation details away).
* **Composition** - objects can contain other objects.
* **Inheritance** - one class can be a subclass of another, and the child receives the parent's data and methods. 
* **Polymorphism** - a subclass can be treated as an object with the parent class' type (e.g. as method parameters). 

#
## Distinguishing Features
- Objects provide a layer of abstraction which can be used to separate internal from external code
- Above definitions and features of OOP

#
## Strengths and Weaknesses

**Strengths**:
- Logical representation of data is to organize by objects
- Can handle complexity well by utilizing objects and breaking down large problems into dichotomy
- Promote code reuse

**Weaknesses**:
- OOP may overemphasize software design and modeling (data/objects) at the expense of other important aspects (computation/algorithms)

#
## Example uses
- Languages: Java, Python, C++, C#, JavaScript/TypeScript, etc.
- Interaction with relational databases (each table is a logical class, each row is a logical object)

#
## Resources
- https://en.wikipedia.org/wiki/Object-oriented_programming
- https://www.interviewbit.com/oops-interview-questions/
- https://stackoverflow.com/questions/742341/difference-between-abstraction-and-encapsulation

#