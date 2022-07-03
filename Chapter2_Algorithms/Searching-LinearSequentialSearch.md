# Linear (Sequential) Search
## Overview

Linear/sequential search involves looking at each value in turn (i.e. start with value in `array[0]`, then `array[1]`, etc.). If it finds the value, return. Otherwise quit when the entire array is searched.

## Typical Use-Case

Simple algorithm. Brute-force fallback. Good for learning and doesn't need sorted data to search?

#
## Algorithms

Start from the left-most element of the array. Iterate through the array elements one by one, comparing the current element to `x`. If `x` matches, return the index. If `x` does not match with any elements, return -1.

## Ilustration
Linear/sequential search:

![Linear/sequential search](https://www.tutorialspoint.com/data_structures_algorithms/images/linear_search.gif)

Linear/sequential search vs. binary search:

![Linear/sequential search vs. binary search](https://c.tenor.com/Jl0YrqxnHmAAAAAd/binary-search-sequence-search.gif)

#
## Time Complexity
**Worst case/average**: O(n)

To compare each element, you must iterate over all n elements.

**Best case**: O(1)

`x` is the first element in the array

#
## Space Complexity
**Memory**: O(1)

No additional space is needed for linear/sequential search.

#
## Distinguishing Features
- Easy, but not efficient

#
## Strengths and Weaknesses

**Strengths**:
- Easy to implement and easy conceptually
- Data does not need to be sorted for linear/sequential search to function

**Weaknesses**:
- Inefficient - can use better options (binary search, hash table)

#
## Example uses
- Learning about searching
- Unordered list?

#
## Resources
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Searching/
- https://www.geeksforgeeks.org/linear-search/
- https://www.geeksforgeeks.org/linear-search-vs-binary-search/

#