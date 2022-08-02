# Object-Oriented Programming - Encapsulation
## Overview

In object-oriented programming, encapsulation is the idea of bundling (encapsulating) data and methods within one unit. In OOP, this manifests as puting data/attributes and methods into one class, and therefore one one object.

Further, encapsulation is often used to hide the internal representation and organization of an object from the outside. The internal representation can be accessed via methods (e.g. Getters or Setters), and 

## More Details and Definitions

* **Information hiding** - when encapsulation is often used to hide the internal representation, or state of an object, from the outside.
    - E.g. you have an attribute that is not visible from outside (e.g. `private`), and bundle it with methods that provide read or write access to the underlying attribute.

Abstraction vs. encapsulation:
* **Abstraction** - general idea of implementation hiding for methods
* **Encapsulation** - general idea of bundling relevant data and methods into one object and hiding specifics 

#
## Distinguishing Features
- Encapsulation is a key feature of OOP to allow decoupling and separation of concerns for objects. It enables bundling (encapsulating) everything relevant to an object in that object and then hides any unnecessary info from external code.

#
## Strengths and Weaknesses

**Strengths**:
- Easy refactoring
- Encourages programmers to put all code that is concerned with a certain set of data in the same class
- Encourages decoupling

**Weaknesses**:
- ? 

#
## Example uses
-  Refactoring - allowing author to change how objects represent their data internally without changing external code (as long as contract is kept the same)
- Getters and Setters for private variables

#
## Resources
- https://en.wikipedia.org/wiki/Object-oriented_programming
- https://stackify.com/oop-concept-for-beginners-what-is-encapsulation/

#