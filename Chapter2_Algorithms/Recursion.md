# Recursion
## Overview

Recursion is a technique where a method calls itself continually until a base case is reached. Once the base case is reached, the method returns and so do each previous caller

## Typical Use-Case

A good hint that a problem is recursive is that it can be built off of subproblems.
- "design an algorithm to compute the nth.."
- "write ode to list the first n.."
- "implement a method to compute all.."

## More Details and Definitions

How to approach:
- Built off subproblems: often times, this means simply computing `f(n)` by adding, subtracting, removing something, or otherwise changing the solution for `f(n-1)`.

Approaches:
1. Bottom-up approach:
    - Start with knowing how to solve problem for simple case (e.g. list with only one element)
    - Then figure out how to solve the problem for two elements, three elements, etc.
    - Key: think how to _build_ the solution for one case off of the previous case (or multiple previous cases)

2. Top-down approach:
    - Think about how we can divide the problem for case N into subproblems

3. Half-and-half approach:
    - Divide data set in half. e.g. binary search, merge sort

#
## Algorithm

Depends on exact algorithm being used. Recursion is a general principle of a method calling into another method, making progress toward the base case, until the base case is met, and returning the result recursively to the original caller.

## Ilustration

![Recursion](https://media2.giphy.com/media/3ov9jQX2Ow4bM5xxuM/giphy.gif)
![Fibonacci recursion example](https://blog.penjee.com/wp-content/uploads/2015/06/fibonacci-recursion-demonstration-animation-python.gif)

#
## Time Complexity
**Worst/best/average case**: Depends on algorithm

To find, figure out how many times total the method will be called and how much work (in terms of problem size, n) is done on each call in addition to the recusive calls. Multiply these two to get the total time complexity.

#
## Space Complexity
**Memory**: Depends on algorithm

Recursive algorithms can be very space inefficient, since you must add a new layer to the call stack for each new recursive call. If your algorithm recurses to a depth of n, it uses at lest O(n) memory

#
## Distinguishing Features
- Must bring context onto the call stack from previous method into current method call
- Can make code clean, but be careful about efficiency

#
## Strengths and Weaknesses

**Strengths**:
- Can make very clean code

**Weaknesses**:
- Can have very high memory costs

#
## Example uses
- Fibonacci
- Dynamic programming
- Factorial

#
## Resources
- https://www.interviewcake.com/concept/java/bottom-up
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Recursion/
- CtCI

#