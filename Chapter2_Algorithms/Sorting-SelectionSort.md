# Selection Sort
## Overview

Select the smallest remaining element (via linear scan) and move it to the front. Repeat on the remaining n-1 elements, repeatedly, until the array is sorted.

## Typical Use-Case

It's an easy algorithm to understand and learn. In practice, this shouldn't be used on any sizeable datasets.

#
## Algorithm
Find (select!) the smallest element using a linear scan and move it to the front (swap with front element). Then, find second smallest and move it, again doing linear scan.

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
- ??
- Easy to understand?

**Weaknesses**:
- Very inefficient (O(n^2))
- Does not benefit from a pre-sorted list

#
## Example uses
- Learning 

#
## Resources
- https://www.interviewcake.com/concept/python/selection-sort
- CtCI

#