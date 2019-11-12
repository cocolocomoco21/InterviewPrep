# Stacks
## Overview

Stacks provide data storage in a, well, stack-like fashion. It is a LIFO, or last-in, first-out storage technique. An analogy is a stack of plates. 

#
## Time Complexity (worst case)
**Access (at a given location)**: O(n)

To access the ith element in a stack, in the worst case, you must pop all elements, put into another stack, return the element you are accessing, and re-pop into the original stack. This is fairly against the design and use case of a stack, but this bullet/header is here for consistency.

**Peek()**: O(1)

Peek is essentially the access function or capability for a stack. This can happen in constant time, because there will always be a pointer to the top of the stack due to its nature, regardless of its underlying implementation. 

**Insertion/Push(item)**: O(1) (possibly amortized)

Adding to an element to a stack is O(1) since there will always be a pointer to the top of the stack, and that is where you are adding. In the worst case, a stack is implemented with an array, and this insertion requires doubling and copying (per arrays' insertion technique), but this is amortized to O(1). With a linked list, there is no amortization, and the access is O(1). 

**Deletion/Pop()**: O(1)

Pop is essentially the access function or capability for a stack. This can happen in constant time, because there will always be a pointer to the top of the stack due to its nature, regardless of its underlying implementation. 

**Search**: O(n)

Similar to Access above. Atypical for this data structure. O(n).

#
## Space Complexity

#
## Distinguishing Features
- Four functions: `push(item)`, `pop()`, `peek()`, `isEmpty()`. Some resources say `size()` rather than `peek()` too. 
- 

#
## Example uses
- Recursion
- Exception/method calls (i.e. stacktrace)
- Putting away the dishes
- Depth-first search

#
## Resources
- 
- 

#