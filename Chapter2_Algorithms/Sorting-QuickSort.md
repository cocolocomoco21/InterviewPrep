# Quick Sort
## Overview

Quick sort is a recursive, divide and conquer algorithm that works by dividing the input into two smaller lists: one with small items and one with large items. By doing this sorting and dividing recursively, it sorts the smaller lists until we reach the base case of one item. By this point, the list is sorted.

The heavy lifting is done in the "**dividing**" portion of quicksort (not the merging). This is opposite of merge sort. However similarly to merge sort, quicksort recursively breaks the input into two smaller pieces until we hit a base case.

## Typical Use-Case

Mostly-efficient time complexity for sorting. If storage is a hard constraint but potential worst-case performance is not, this can be better than merge sort.

#
## Algorithm

Using recursion, do:
- Choose a pivot to partition the array
- Sort the list such that all elements less than pivot come before it, all elements larger come after it
- Recursively sort each smaller partition.

Base case for recursion: input list with one item (like merge sort). A one-element list is already sorted.

Basically, pick a pivot and sort all elements smaller than the pivot to the left and all elements larger than the pivot to the right. You now have two partitions. Recursively do this algorithm: for each partition, select a pivot, sort all elements smaller to the left and larger to the right. When you reach base case, all elements are sorted.

Note: some algorithms choose the pivot always as the right-most element, and when the left and right iterators cross, swap pivot (right-most) with the left iterator. Other algorithms say pick the midpoint. The idea remains the same however.

Psuedocode: due to the above difference, and since worst-case is O(n^2), I've omitted psuedo code for now.


## Ilustration

![Quicksort gif](https://upload.wikimedia.org/wikipedia/commons/9/9c/Quicksort-example.gif)

#
## Time Complexity
**Worst case**: O(n^2)

We do O(n) for each row:
- We iterate over and compare each element. The work per each element is constant time, but since there are n elements, we do O(n) for each row.

How many rows? 
- If we pick a pivot that's close-ish to the median, we divide each row roughly in half each time. So, on average, we'll have O(logn) rows.
    - O(n) work for each row * O(logn) rows = O(nlogn)
- However if we pick the worst pivot possible, we can get the complexity to be O(n^2)
    - If the array is already sorted and we pick our pivot as the right-most element, we get an empty right sublist and a "full" left sublist (minus the pivot). 
    - This means we have n rows.
    - O(n) work for each row * O(n) rows = O(n^2)

Therefore, our average case is O(nlogn), but the worst case can be O(n^2).

**Average/best case**: O(nlogn)

Above

#
## Space Complexity
**Memory**: O(logn)

Quicksort is in place, without any extra data structures. But in the worst case, due to recursive calls (and tricks to alleviate the O(n)), the space complexity can be O(logn) (although in practice, most non-optimized are more than this).

#
## Distinguishing Features
- Fast. O(nlogn) for all scenarios, which scales well for larger n values.
- Intuitive. Not super crazy logic, just combined CS topics

#
## Strengths and Weaknesses

**Strengths**:
- Fast. On average, O(nlogn)
- Parallelizable - merge sort breaks input into chunks, which can each be sorted at the same time in parallel
- Does not require extra storage like merge sort does

**Weaknesses**:
- Slow worst-case - O(n^2). This isn't common but still makes quicksort undesirable if there's any performance requirement

#
## Example uses
- Efficient sorting
- Giving an O(nlogn) sorting algorithm in an interview :)

#
## Resources
- https://www.interviewcake.com/concept/python/quicksort
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Sorting/#quick
- CtCI

#