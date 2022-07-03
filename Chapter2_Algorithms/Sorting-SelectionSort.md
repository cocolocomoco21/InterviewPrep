# Selection Sort
## Overview

Selection sort works by selecting the smallest element from an unsorted list and moving it to the front.

## Typical Use-Case

It's an easy algorithm to understand and learn. In practice, this shouldn't be used on any sizeable datasets.

#
## Algorithm
Find (select!) the smallest remaining element (via linear scan) and move it to the front (swap with front element). Then, find second smallest for the remaining n-1 elements and move it to the front, again doing linear scan. Repeat until you reach the end of the list.

## Ilustration

![Selection sort gif](https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif)

#
## Time Complexity
**Worst case**: O(n^2)

Iterate over list n times. We iterate over n elements, then n-1 elements, then n-2, ..., 3, 2, 1. Adding this is the triangular series, which is O(n^2).

**Best case**: O(n^2)

Above

**Average case**: O(n^2)

Above

#
## Space Complexity
**Memory**: O(1)

Selection sort is done in place.

#
## Distinguishing Features
- Normally somewhat meme-y with how bad it is.
- 

#
## Strengths and Weaknesses

**Strengths**:
- Easy to understand?

**Weaknesses**:
- Very inefficient (O(n^2))
- Does not benefit from a pre-sorted list

#
## Example uses
- Learning
- Packing a suitcase, putting large items before small - selection sort

#
## Resources
- https://www.interviewcake.com/concept/python/selection-sort
- CtCI

#