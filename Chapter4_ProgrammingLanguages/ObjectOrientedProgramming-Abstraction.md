# Object-Oriented Programming - Abstraction
## Overview

In object-oriented programming, abstraction is the design pattern which only "shows" essential details and hides unnecessary details from the user.

Objects in OOP provide abstraction that hides the internal implementation details. You don't need to know how an object's method implements that method, you just need to know the inputs and outputs. Basically, abstraction is creating a "black-box" for a given functionality.

## More Details and Definitions

Abstraction vs. encapsulation:
* **Abstraction** - general idea of implementation hiding for methods
* **Encapsulation** - general idea of bundling relevant data and methods into one object and hiding specifics 

#
## Distinguishing Features
- Abstraction allows a class to define its implementation without the caller needing to know. E.g. Math library - if a more optimal way of implementing square root is discovered, you can swap that in to the Math.sqrt method, and all callers will not know or care about this change.

#
## Strengths and Weaknesses

**Strengths**:
- Separate interface from implementation

**Weaknesses**:
- ? 

#
## Example uses
- Libraries in code - you just use the functions but don't need to know how they're implemented
    - Keeping a contract (i.e. interface) enables differentiation of "using" function vs. implementation
- Anything you use that you know what goes in and comes out, but don't need to know how it works
    - E.g. coffee machine (water + coffee grounds + button -> fresh coffee), car (put in gas + start -> go)

#
## Resources
- https://en.wikipedia.org/wiki/Object-oriented_programming
- https://stackify.com/oop-concept-abstraction/

#