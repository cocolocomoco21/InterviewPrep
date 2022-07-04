# Divide and Conquer
## Overview

Divide and conquer algorithms solve problems by dividing the problem into smaller subproblems, recursively conquering (solving) the subproblems, and combining the result.

## Typical Use-Case

This is a general technique that can be extended by specific algorithms. Some use-cases for divide and conquer are:
- Solving hard problems: all it requires is breaking down the problem into sub-problems, solving the trivial cases, and combining subproblems to the original problem
- Finding fast algorithms (e.g. Karatsuba's, quicksort, merge sort, FFTs)

## More Details and Definitions

Divide and conquer technique is three parts:
1. Divide: divide the problem into smaller subproblems of the same problem
2. Conquer: solve the subproblems recursively (if small enough, solve the base cases)
3. Combine: combine the subproblems to get the final solution to the whole problem 

#
## Algorithm

Divide and conquer's basic idea is to decompose a given problem into two or more similar, but simpler, subproblems, to solve them in turn, and to compose their solutions to solve the given problem. 

## Ilustration

Divide and conquer algorithm overview:

![Divide and conquer diagram](https://cdn.kastatic.org/ka-perseus-images/98c02634ee7f970a6bfb0812cc1495bacb462282.png)


Example divide and conquer with merge sort:

![Merge sort divide and conquer](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/927px-Merge_sort_algorithm_diagram.svg.png)

Per Wikipedia (caption): "Divide-and-conquer approach to sort the list (38, 27, 43, 3, 9, 82, 10) in increasing order. Upper half: splitting into sublists; mid: a one-element list is trivially sorted; lower half: composing sorted sublists."

#
## Time Complexity
**Worst/best/average case**: Depends on algorithm

Divide and conquer is just a general approach - the actual complexity will rely on the algorithm extending this technique.

#
## Space Complexity
**Memory**: Depends on algorithm

Divide and conquer is just a general approach - the actual complexity will rely on the algorithm extending this technique.

That being said, divide and conquer is recursive, so there will be some hit on either 1) the call stack or 2) external data structures to avoid overloading the call stack.

#
## Distinguishing Features
- Powerful way to reduce hard problems into easier problems and solve efficiently
- Efficient

#
## Strengths and Weaknesses

**Strengths**:
- Good for solving hard problems: all it requires is breaking down the problem into sub-problems, solving the trivial cases, and combining subproblems to the original problem
- Finding fast algorithms (e.g. Karatsuba's, quicksort, merge sort, FFTs)
- Good with paralellism due to nature of splitting into subproblems
- Can be done efficiently in cache rather than memory of a computer

**Weaknesses**:
- Recursion leads to a large call stack (inefficient space complexity and risk of stack overflow)

#
## Example uses
- Merge sort (divide: into smaller sorted arrays, conquer: sort them, combine: merge two sorted halves)
- Quicksort (divide: create partition based on pivot, conquer: sort values into partition accordingly, combine: recursively sort subarrays on left and right of pivot )
- Multiplying large numbers (Karatsuba algorithm)
- Closest pair of points

#
## Resources
- https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm
- https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/divide-and-conquer-algorithms
- https://www.geeksforgeeks.org/divide-and-conquer-algorithm-introduction/

#