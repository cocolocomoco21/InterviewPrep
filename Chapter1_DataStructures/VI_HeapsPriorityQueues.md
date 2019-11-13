# Heaps and Priority Queues
## Overview

A **priority queue** is a queue ordered based on some priority value. For example, a printer: if the CEO prints a job, it should be the highest priority and print fastest. If a VP prints, it should be higher than the jobs of people under him/her, but not higher than the C suite. An intern should (of course) be lowest ;).

A **heap** is a binary tree with two special properties (using a max heap for example):
    
1) **Order property**: every node n must have a value greater than or equal to its children (and thus the rest of the subtree).
2) **Shape property**: the binary tree must be complete (the only free space in the tree must be in the rightmost elements).

Elements inserted are added at the bottom-right most open leaf, and continually compared and swapped with the parent until the parent is larger. Elements removed are removed from the top always. The value at the end of the heap is then swapped into the root, and compare and swap (with the _larger_ child) until it settles in the right place (i.e. swap with larger elements until there is a smaller element which you don't swap with).   

#
## Time Complexity (worst case)
**Access (at a given location)**: O(1) for top node (if you're just reading it). More cases below.

Typically, accessing only occurs on the top node. Just accessing without removing is O(1) since the head (and therefore max value) is always tracked. If removing, O(log n) (below). If you know (for some reason) where the node that you're trying to read the value of is (which seems weird...), then it's technically O(log n) to navigate to this node. This is atypical though. So my answer is, to access just the root, which is the typical use case, it's O(1)

**Insertion**: O(log n)

According to the insertion algorithm (above), we add value to the bottom of the heap and compare and swap its way up, to be settled and restore the order property. In the worst case, the swapping occurs from leaf to root, which, since the tree is balanced, the height of the tree is log N, so O(log n).

**Deletion/RemoveMax()**: O(log n)

Again, according to the deletion algorithm, when moving the bottom most leaf up to the top, we can, in the worst case, have to move the node from root to leaf. Similar to insertion, due to the log N height of the tree, the complexity is O(log n).

**Search (to find if element exists)**: Not the use case for a heap, but technically O(n)

If you're trying to search a binary tree, use a binary search tree. But technically, the complexity of searching a heap is O(n) because in the worst case, you'd have to go through all elements. Since there is no rule on putting values to the left or right, rather just putting values above or below each other, there is no O(log n) guarantee like a BST.

#
## Space Complexity

#
## Distinguishing Features
- Two rules must be followed to implement a heap: 1) order property, and 2) shape property (above).
- Heaps can be min or max, depending on what the use case is. In this example and page, I used max heap.
- Priority queue can be implemented using a heap, which can be implemented using an array.
- Heaps provide logarithmic worst-case complexities for a priority queue.

#
## Example uses
- Priority queue <--> heap
- Anything which has a "weight" regarding priority or urgency

#
## Resources
- CS 367 packet (paper, unfortunatley no link)
- 

#