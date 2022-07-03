# Radix Sort
## Overview

Radix sort sorts numbers with fixed-number of digits by sequentially sorting one digit at a time.

That is, radix sort sorts the ones place for every integer, then the tens, then the hundreds, etc. The key insight is that radix sort is a **stable** sorting algorithm, meaning that in case of a tie, it reverts to the previous order. Basically, it considers the prior ordering work that was done in case of a tie.

## Typical Use-Case

Really good for a specific use case - sorting fixed-size numbers.

#
## Algorithm

For an integer, sort one digit at a time. Any stable sorting algorithm can be used, like counting sort. However, some algorithms use "buckets" for the currently-sorted digit as well (e.g. array of queues - refer to UW notes).

Sort the ones place into ascending order. Then, sort the tens place into ascending order, but in the case of a tie, use the order from the previous step. Continue until completely sorted.


## Ilustration

![Radix gif](https://upload.wikimedia.org/wikipedia/commons/0/04/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F.gif)

#
## Time Complexity
**Worst/best/average case**: O(k*(n + range)). For 64-bit integers and binary, O(n)

Radix sort takes O(k*(n + range)) time complexity, where
- n = number of items to sort
- k = number of passes of the sorting algorithm/number of digits in each item
- range = the number of values each digit can have

We call counting sort one time for each k digit, and counting sort has time complexity O(n + range). Therefore O(k*(n + range)).

For 64-bit integers, the number of digits, k, = 64. Using binary, each digit can be either 0 or 1, meaning range = 2. Both values are constant, and therefore radix sort becomes O(n) time.  

#
## Space Complexity
**Memory**: O(n + range). For 64-bit integers and binary, O(n)

For 64-bit integers, the number of digits, k, = 64. Using binary, each digit can be either 0 or 1, meaning range = 2. Both values are constant, and therefore radix sort becomes O(n) space.  

#
## Distinguishing Features
- Fast! Linear time to sort n integers with fixed number of bits
- Not a comparison sort

#
## Strengths and Weaknesses

**Strengths**:
- Fast! Linear time to sort n integers with fixed number of bits
- Punch card friendly. Huge for historical reasons

**Weaknesses**:
- Extra space to hold buckets/counting sort algorithm
- Restricted inputs - only works with a fixed number of digits. Can't change digit size

#
## Example uses
- Sorting a fixed number of ints

#
## Resources
- https://www.interviewcake.com/concept/python/radix-sort
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Sorting/#radix
- CtCI

#