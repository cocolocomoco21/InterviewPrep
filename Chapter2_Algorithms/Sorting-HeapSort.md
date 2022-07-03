# Heap Sort
## Overview

Heapsort creates a heap to routinely present the min (or max) value. By continually calling RemoveMin()/RemoveMax() on the heap, we can mimic selection sort by repeatedly chosing the smallest/largest item and moving it into our list.

The key insight in heapsort is that we can build a heap in O(n) and remove in O(logn). By using a heap that uses an array underneath, we can have an O(nlogn) algorithm with O(1) space complexity.

## Typical Use-Case

Mostly-efficient time complexity for sorting. If storage is a hard constraint but potential worst-case performance is not, this can be better than merge sort.

#
## Algorithm

Note: there are a few ways you could do this. If space isn't an issue, you can just pop off min-heap elements into a new array. If you want to do it in place, you actually should make a MAX-heap (not a min-heap) and return the max value to the end of the array, then the index one left of the end for the next max, etc. This backloads the array with the largest values, working smaller to the front, until you have a min-sorted array. 

Add to new array algorithm:

1. Heapify

    Given a list, we can treat this like a min-heap/complete binary tree (not actually making the heap/tree and keeping the list solely in memory). 

    ![test](https://www.interviewcake.com/images/svgs/heapsort__input_list_as_binary_tree.svg?bust=210)

    The heap most likely will not be valid. We need to make it valid. Swap nodes and children to maintain validity, working your way up the heap. This causes larger nodes to move lower in the tree, "bubbling down" to allow smaller nodes to rise to the top.

2. Repeatedly remove min
    
    Each time we remove an element from the heap, it's the minimum element in the underlying list (due to heap maintenance rules that come with RemoveMin).

3. Add min to new array

    Append the min value to the sorted array. Once heap is empty, you will have sorted array.


In place algorithm:

1. Heapify

    Given a array, we can treat this like a max-heap/complete binary tree (not actually making the heap/tree and keeping the array solely in memory). 

    ![Array as heap](https://www.interviewcake.com/images/svgs/heapsort__input_list_as_binary_tree.svg?bust=210)

    The heap most likely will not be valid. We need to make it valid. Swap nodes and children to maintain validity, working your way up the heap. This causes smaller nodes to move lower in the tree, "bubbling down" to allow larger nodes to rise to the top.

2. Remove max
    
    Each time we remove an element from the heap, it's the maximum element in the underlying array (due to heap maintenance rules that come with RemoveMax). Hold this max in a temp variable.

    ![Remove max into temp variable](https://www.interviewcake.com/images/svgs/heapsort__binary_tree_with_deleted_max_node_9.svg?bust=210)

3. Make heap valid again
    
    Basically the same as heapify - move the bottom right most element to the root, swapping with the largest child if it's greater than the current node. Once all children are smaller, heap is valid

4. Add previous max into array

    Since the previous bottom-right element was moved and the heap was restructured with one less element, there is room in one index the very back of the array to insert the previous max (stored in a temp variable). Insert this at the back to have the largest value in the end of the array.
    
    ![Add previous max into array](https://www.interviewcake.com/images/svgs/heapsort__binary_tree_with_sorted_node_9.svg?bust=210)

5. Continue until at front of array

    Keep a pointer to where to add the next max. Continue calling RemoveMax(), reordering heap, and adding that max to the end. Once you reach the front, you have an ascendingly sorted array.


## Ilustration

![Heapsort gif](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

#
## Time Complexity
**Worst/average case**: O(nlogn)

For heapify: examine every item and move it downwards until it's larger than its children. Tree heightis O(logn), we could do these O(logn) moves. For all n nodes, that's O(nlogn) (however we can be clever to only have it be O(n)!).

We then remove all n elements one at a time. This is O(logn) to remove from the heap, and for n elements, this gives O(nlogn).

These steps combine to be O(nlogn) worst/average case.

**Best case**: O(n)

If all items are identical, we don't have to bubble down. That omits the cost of remove and makes each remove O(1). We do this for n elements, so O(n).

These steps combine to be O(n) best case.

#
## Space Complexity
**Memory**: O(1)

Heapsort is in place, without any extra data structures. We simply rearrange an array.

#
## Distinguishing Features
- Fast. O(nlogn) scales well for larger n values
- Intuitive. Not super crazy logic, just combined CS topics

#
## Strengths and Weaknesses

**Strengths**:
- Fast. On average, O(nlogn)
- Space efficient - O(1)

**Weaknesses**:
- Slow in practice - although O(nlogn), we do have addition of various large terms (e.g. heapify is O(n) or O(nlogn) + O(nlogn)). O(n) and O(2n) are both O(n), but that constant does impact real-world performance.

#
## Example uses
- Need efficient, in-place sort

#
## Resources
- https://www.interviewcake.com/concept/python/heapsort
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Sorting/#heap
- CtCI

#