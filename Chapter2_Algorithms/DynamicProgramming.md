# Dynamic Programming and Memoization
## Overview

Dynamic programming is finding the overlapping subproblems in a recursive algorithm and caching them for later recursive calls.

## Typical Use-Case

To make recursion more efficient by caching.

## More Details and Definitions

Memoization = ensure a method doesn't run for the same inputs more than once by keeping a record of the results for the given inputs.
- Basically, just put the results in a hash map for later lookup.
- Strategy for dynamic programming problems (problems where the solution is composed of solutions to the same problem with smaller inputs, e.g. Fibonacci)
- Top-down approach

Bottom-up approach = start from the beginning and build up toward solution

#
## Algorithm

Use caching to make recursion, or problems comprised of repeatable subproblems, more efficient. Specific algorithm will depend on the specific problem

## Ilustration

Non-dynamic programming Fibonacci:

![Non-DP fibonacci](https://www.interviewcake.com/images/svgs/fibonacci__binary_tree_recursive.svg?bust=210)

vs.

dynamic programming Fibonacci (saving already-completed calls into map called `memo`): 

![DP fibonacci](https://www.interviewcake.com/images/svgs/fibonacci__binary_tree_memoized.svg?bust=210)

#
## Time Complexity
**Worst/best/average case**: Depends on algorithm

Can make fibonacci from exponential (O(2^n)) to linear (O(n)).

#
## Space Complexity
**Memory**: Depends on algorithm

Adding a cache (e.g. hash map) will add memory usage. This is a tradeoff between the slower, plain/non-DP recursion that you'd otherwise have.

#
## Distinguishing Features
- Optimization over plain recursion - get to save repeated calls (subproblems) for constant time lookup.
- Use hashmap to cache. O(1) lookup.

#
## Strengths and Weaknesses

**Strengths**:
- Cache already-computed results to significantly save on time complexity

**Weaknesses**:
- Adds memory usage

#
## Example uses
- Fibonacci
- Any recursion with repeating subproblems

#
## Resources
- https://www.geeksforgeeks.org/dynamic-programming/
- https://www.programiz.com/dsa/dynamic-programming
- https://www.interviewcake.com/concept/java/bottom-up
- https://www.interviewcake.com/concept/java/memoization

#