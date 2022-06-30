# Stacks
## Overview

Stacks provide data storage in a LIFO, or last-in, first-out, fashion. An analogy is a stack of plates. 

#
## Time Complexity (worst case)
**Access (at a given location)/Search**: O(n)

To access the ith element in a stack, in the worst case, you must pop all elements, put into another stack, return the element you are accessing, and re-pop into the original stack. This is fairly against the design and use case of a stack, but search is a relevant discussion point for all data structures. O(n) time and O(n) space complexity.

**Push**: O(1) (possibly amortized)

Push adds an element to the stack. Adding to an element to a stack is O(1) because there will always be a pointer to the top of the stack, and that is where you are adding. In the worst case, a stack is implemented with an array, and this insertion requires doubling and copying (per arrays' insertion technique), but this is amortized to O(1). With a linked list, there is no amortization, and the access is O(1). 

**Pop**: O(1)

Pop removes an element from the stack. Removing an element from the stack is O(1) because there will always be a pointer to the top of the stack, and that is where you are removing from.

**Peek()**: O(1)

Peek looks at the top element of a stack without removing. This is the same as `Pop` but without removing the element. Since there is always a pointer to the top of the stack, this is O(1).

#
## Space Complexity

O(n) for all n elements in the stack.

#
## Distinguishing Features
- Four functions: `push(item)`, `pop()`, `peek()`, `isEmpty()`. Some resources say `size()` as well.
- Can use linked list or dynamic (automatic resizing) array under the hood

#
## Strengths and Weaknesses

**Strengths**:
- Fast operations - constant time in all major operations
- Good for powerful operations (DFS of graph, traverse tree, reverse linked list)

**Weaknesses**:
- Not adequate data structure for lookup

#
## Example uses
- Call stack for exception and method calls (i.e. stacktrace)
- Recursion
- Putting away the dishes
- Depth-first search

#
## Resources
- https://www.interviewcake.com/concept/python/stack
- 

#