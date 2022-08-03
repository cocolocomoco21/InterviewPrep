# Object-Oriented Programming - Polymorphism
## Overview

In object-oriented programming, polymorphism is when calling code can be independent of which class in a hierarchy it's operating on - the parent or a subclass. However, the operation being called may behave differently.

For example, there is a parent class Shape, which has the method Draw(). Circle and Square are both subclasses, which inherit/extend from Shape. They are in the same hierarchy as Shape. The Draw() method for both Circle and Square will likely look different, but if a method is expecting a Shape object, Shape::Draw will call the appropriate method for each class.

## More Details and Definitions

* **Abstract class** - in Java, an abstract class is a class which can have some method implementations, but will require some classes to implement their own methods and will fail at compile-time if not completed. In the above example, Shape could be an abstract class that required subclasses (e.g. Circle and Square) to implement their own Draw() methods.
* **Overriding** - in Java, a class can override a method specified in the parent. If a class has a different intended implementation, it can @Override its parent to assert its own functionality over the parent.

#
## Distinguishing Features
- Subtyping is a form of polymorphism.

#
## Strengths and Weaknesses

**Strengths**:
- Allows for subtyping
- Allows for abstraction - a caller doesn't need to care which object it has - it just needs whatever object to perform a known capable action
- Enables separation of concerns

**Weaknesses**:
- ? 

#
## Example uses
- Overriding - subclasses can implement their own version of a parent's method

#
## Resources
- https://en.wikipedia.org/wiki/Object-oriented_programming
- https://stackify.com/oop-concept-polymorphism/

#