# Heaps and Priority Queues
## Overview

Min-heaps are a complete (totally filled except from bottom right corner) binary tree where each node is smaller than its children. The root is the minimum element in the tree.

The same goes for max-heaps; the root is the maximum element in the tree.

## More Details and Definitions
Heaps are used to implement **priority queues** - a priority queue is a queue ordered based on some priority value. Every item in queue has priority and higher-priority items are dequeued first.

For example, a printer: if the CEO prints a job, it should be the highest priority and print fastest. If a VP prints, it should be higher than the jobs of people under him/her, but not higher than the C suite. An intern should be lowest ;).

A **heap** is a binary tree with two special properties (using a min heap for example):
    
1) **Order property**: every node n must have a value less than or equal to its children (and thus the rest of the subtree).
2) **Shape property**: the binary tree must be complete (the only free space in the tree must be in the rightmost elements).

Example graph for a min-heap:
```
              4
            /   \
          10     17
        /   \   /
       54   89 86     
```

#
## Algorithms for Operations (Insert and RemoveMin)
- **Insert**: Elements inserted are added at the bottom-right most open leaf, and continually compared and swapped with the parent until the parent is smaller. 
- **RemoveMin**: Elements removed are removed from the top always. The value at the end of the heap is then swapped into the root. Compare and swap (with the _smaller_ child) until it settles in the right place (i.e. swap with all elements that are smaller until there is no smaller element which you can't swap with).
- **Heapify**: Create a heap from a list. Treat list like a complete binary tree that is unordered for a heap. Compare each node to its children, swapping when a child is smaller than the parent. This causes the larger nodes to "bubble down," which is similar for removing items from the heap. Eventually, we create small valid min-heaps and progressively merge them until the entire heap is considered valid. 

#
## Time Complexity (worst case)
**Insert**: O(logn)

According to the insertion algorithm (above), we add the value to the bottom of the heap and compare and swap its way up, to be settled and restore the order property. In the worst case, the swapping occurs from leaf to root, which, since the tree is balanced, the height of the tree is log N, so O(log n).

**RemoveMin()**: O(logn)

According to the deletion algorithm, when moving the bottom most leaf up to the top, we can, in the worst case, have to move the node from root to leaf. Similar to insertion, due to the log N height of the tree, the complexity is O(log n).

**GetMin()**: O(1)

Since the min (or max) is always at the top of the list, accessing it is constant time.

**Heapify()**: O(n)

It is O(n) to make a heap from a list. There are algorithms to achieve this (StackOverflow) and InterviewCake (below). From the leaves, recusively make valid small heaps and merge them.

This is not O(nlogn) because that overestimates the amount of work. The n/2 number of leaf nodes will never move. The n/4 number of nodes one level up from leaves will move at most 1 time, etc. If we work the math of this series, we get the summation which converges to 1/2. So for n nodes, O(n * 1/2) = O(n).

**Search (to find if element exists)**: Not the use case for a heap, but technically O(n)

If you're trying to search a binary tree, use a binary search tree. But technically, the complexity of searching a heap is O(n) because in the worst case, you'd have to go through all elements in a BFS-like search. Since there is no rule on putting values to the left or right, rather just putting values above or below each other, there is no O(log n) guarantee like a BST.

#
## Space Complexity
O(n) to hold the n elements. Noteworthy that this is commonly done in a list as well, so the memory block is contiguous (better for caching/memory) and there is less overhead with pointers to children.

#
## Distinguishing Features
- Two rules must be followed to implement a heap: 1) order property, and 2) shape property (above).
- Heaps can be min or max, depending on what the use case is. In this example and page, I used max heap.
- Priority queue can be implemented using a heap, which can be implemented using an array.
- Heaps provide logarithmic worst-case complexities for a priority queue.

#
## Strengths and Weaknesses
**Strengths**:
- Enables quick lookup of min or max O(1) or removal (Olog(n)).
- Can implement priority queue with heap.

**Weaknesses**:
- Limited interface - can only add or remove top. No search or other useful things.

#
## Example uses
- Priority queue <--> heap. 
  - Priority queue = every item in queue has priority and higher-priority items are dequeued first
- Anything which has a "weight" regarding priority or urgency
- Heapsort (create a heap and then remove them into a sorted list) is efficient (O(nlogn))

#
## Resources
- CS 367 packet (paper, unfortunately no link)
- https://www.interviewcake.com/concept/python/heap
- https://www.interviewcake.com/concept/python/priority-queue
- https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/

#