# Merge Sort
## Overview

Merge sort is a recursive, divide and conquer algorithm that works on the concept of splitting and sorting the input recursively, and then merging the sorted halves back together.

The heavy lifting is done in the "**merge**" portion of merge sort (not the dividing). The key insight is that it's possible to merge two sorted arrays (containing n/2 items each) in O(n). 

Merge sort is notable for its complexity - O(nlogn) - for all scenarios.

## Typical Use-Case

Efficient time complexity for sorting.

#
## Algorithm

Using recursion, do:
- Divide the array into two halves
- Recursively, sort the left half
- Recursively, sort the right half
- Merge the two sorted halves

Base case for recursion: input list with one item. A one-element list is already sorted.

Basically, take the list down to one item on each half. This sorting is easy - it's one comparison. Put the smaller first. For subsequent sorting of the two disjointed arrays, have a pointer for each one. Start the pointer at the beginning, then for whichever side is smaller, add that value to the "sorted" array and move the pointer. Once one array is empty, just move the remainders of the other array into the sorted list (even if it's just one element). 

Psuedocode:
```
mergeSort(input) {
    if input.length <= 1
        return list
    
    middleIndex = floor(input.length / 2)
    leftList = input.sublist(0,middleIndex)
    rightList = input.sublist(middleIndex, input.length)

    leftSorted = mergeSort(leftList)
    rightSorted = mergeSort(rightList)

    return combineSortedLists(leftSorted, rightSorted)
}

combineSortedLists(leftList, rightList) {
    leftIndex, rightIndex = 0
    mergedList = []

    // Merge sorted halves into new array
    while leftIndex < leftList.length && rightIndex < rightList.length
        if (leftList[leftIndex] < rightList[rightIndex]) 
            mergedList.add(leftList[leftIndex])
            leftIndex++
        else
            mergedList.add(rightList[rightIndex])
            rightIndex++

    // Grab leftover items and add to merged list
    while (leftIndex < leftlist.length)
        mergeList.add(leftList[leftIndex])
        leftIndex++
    
    while (rightIndex < rightlist.length)
        mergeList.add(rightList[rightIndex])
        rightIndex++

    return mergedList
}

```

## Ilustration

![Merge sort gif](https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif)

#
## Time Complexity
**Worst/best/average case**: O(nlogn)

We do O(n) for each row:
- In the first half (splitting/sorting), we do constant time work for each item by coping the item to a smaller list. However we do this for all n items, so O(n).
-  In the second half (merging), we do constant time work for each item by coping from smaller to larger, merged list. However we do this for all n items, so O(n).

Therefore, we do O(n) for each row.

How many rows? 
- We divide each row in half until we get down to one. This is O(logn) divisions to get to the base case (splitting/sorting)
- We then multiply each row by two until we get to n. This is O(logn) multiplications to get to the final merged and sorted list.
- We have O(logn) + O(logn) = O(2logn) -> O(logn)

Therefore, we have O(n) for row * O(logn) number of rows = O(nlogn) total.

#
## Space Complexity
**Memory**: O(n)

When combining two sorted lists into a single bigger one, we need extra space to hold the merged result. Since the lists we'll be combining have O(n) items, we need O(n) space total. 

(above psuedocode uses more than O(n), but it is possible)

#
## Distinguishing Features
- Fast. O(nlogn) for all scenarios, which scales well for larger n values.
- Intuitive. Not super crazy logic, just combined CS topics

#
## Strengths and Weaknesses

**Strengths**:
- Fast. O(nlogn)
- Parallelizable - merge sort breaks input into chunks, which can each be sorted at the same time in parallel

**Weaknesses**:
- Space - merge sort takes up extra O(n) space, including O(logn) for the recursive call stack

#
## Example uses
- Efficient sorting
- Giving an O(nlogn) sorting algorithm in an interview :)

#
## Resources
- https://www.interviewcake.com/concept/python/merge-sort
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Sorting/#merge
- CtCI

#