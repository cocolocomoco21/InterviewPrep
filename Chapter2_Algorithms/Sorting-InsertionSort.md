# Insertion Sort
## Overview

Insertion sort works by inserting elements from an unsorted list into a sorted subsection of the list, one item at a time.

## Typical Use-Case

Sorted, or nearly or likely sorted list

#
## Algorithm
Break a list into two chunks: sorted and unsorted. The 0th element is "sorted" to start. Add the next item to the sorted portion. If it goes before the 0th element, swap them. Now the first two elements are sorted.

Continually work your way until the end - add in the next element and flutter it backwards until it is _inserted_ in the right spot. 

## Ilustration

![Selection sort gif](https://upload.wikimedia.org/wikipedia/commons/9/9c/Insertion-sort-example.gif)

#
## Time Complexity
**Worst case**: O(n^2)

In the worst case, the array is in reverse descending order. In this case, each element we would need to "insert" would be at the front of the sorted side of the array. For n elements, it would be moving the element 1, 2, ..., n-2, n-1 spaces. This is the triangular series, whose sum is O(n^2).

**Best case**: O(n)

In the best case, the input is already sorted. In that case, we'll iterate through to compare each element and will end up seeing they're in the right spot and no insertion needs to actually happen. This one comparison iteration is just n elements, so O(n).

**Average case**: O(n^2)

Rarely are we sorting a sorted array, so this falls to the worst case.

#
## Space Complexity
**Memory**: O(1)

Insertion sort is done in place (mostly, there might be a temp variable for swapping) but no extra data structures, so O(1).

#
## Distinguishing Features
- Efficient on a sorted or nearly sorted list 
- Intuitive, like how you sort cards in a hand

#
## Strengths and Weaknesses

**Strengths**:
- Intuitive
- Space efficient - done in place
- Fast on a sorted list

**Weaknesses**:
- Very inefficient (O(n^2))

#
## Example uses
- Arranging cards while playing poker or go-fish

#
## Resources
- https://www.interviewcake.com/concept/python/insertion-sort

#