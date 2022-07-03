# Binary Search
## Overview

Binary search uses a sorted list to compare the midpoint of an interval to `x`. If the midpont equals `x`, it returns. If `x` is less than the midpoint, search the left half of the array. If `x` is greater than the midpoint, search the right half of the array. 

This disregards half of the array depending on if `x` is greater than or less than the midpoint and continues the search on the remaining half.  

The key insight is that in a sorted array, you can perform search in O(logn).

## Typical Use-Case

Simple algorithm on a sorted list to accomplish search with good time complexity.

#
## Algorithms

Start by looking at the middle item `mid`. If `mid` is the value `x` that we're searching for, return (either index or true). Otherwise, use relative order of `mid` and `x` to eliminate half of the array. That is, if `x` < `arr[mid]`, look from 0 to `mid`; if `x` > `arr[mid]`, look from `mid` to `array.length - 1`. Repeat the algorithm until you find the element or are down to one element that isn't equal to `x`.

## Psuedocode
```
binarySearch(input, x) {
    lowerIndex = 0
    upperIndex = input.length - 1

    while (lowerIndex < upperIndex)
        midpointDisplacement = (upperIndex - lowerIndex)/ 2
        midpointIndex = lowerIndex + midpointDisplacement

        midpointValue = input[midpointIndex]
        if (x == midpointValue)
            return true

        if (x < midpointValue)
            upperIndex = midpointIndex - 1
        else 
            lowerIndex = midpointIndex + 1

    return false
}
```

## Ilustration
Linear/sequential search:

![Binary search](https://d18l82el6cdm1i.cloudfront.net/uploads/bePceUMnSG-binary_search_gif.gif)

Linear/sequential search vs. binary search:

![Linear/sequential search vs. binary search](https://c.tenor.com/Jl0YrqxnHmAAAAAd/binary-search-sequence-search.gif)

#
## Time Complexity
**Worst case/average**: O(logn)

Each "round" is constant time comparisons. So the complexity comes down to how many times the algorithm is run. Since we continually divide by half, this results in logn rounds. So O(logn).

**Best case**: O(1)

`x` is the midpoint of the array

#
## Space Complexity
**Memory**: O(1)

No additional space is needed - you just have two pointers to the current lower and upper bounds.

#
## Distinguishing Features
- Must use a sorted list
- Simple yet fast

#
## Strengths and Weaknesses

**Strengths**:
- Easy to implement and easy conceptually
- Significant improvement over linear search
- Good efficiency that rivals some harder to implement algorithms

**Weaknesses**:
- Must have sorted array - cannot search on unsorted array

#
## Example uses
- Searching on a sorted list

#
## Resources
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Searching/
- https://www.interviewcake.com/concept/java/binary-search
- https://www.geeksforgeeks.org/linear-search-vs-binary-search/

#