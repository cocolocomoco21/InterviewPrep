### Problem
Given an int array `nums` and a window size `k`, find the sliding window maximum, meaning find the maximum value within
each window of `k` sequential elements as the window moves left to right. 

Example (from LeetCode):
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3

Output: [3,3,5,5,6,7]

Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3

1 [3  -1  -3] 5  3  6  7       3

1  3 [-1  -3  5] 3  6  7       5

1  3  -1 [-3  5  3] 6  7       5

1  3  -1  -3 [5  3  6] 7       6

1  3  -1  -3  5 [3  6  7]      7



https://leetcode.com/problems/sliding-window-maximum/

### Approach

Iterate over elements 0->n-k. Maintain a max heap of the current elements (PriorityQueue with Comparator.reverseOrder() 
in Java). Create this max heap up front for the first k objects, and then maintain it by adding the next element and 
removing the last element.

This runs into issues for large datasets, as the remove(Object o) method of the PriorityQueue is O(n) to lookup and 
O(logn) to remove. 

As such, create a hashmap that maintains a count of removed elements. These are effectively "deleted", but are not 
removed from the max heap to avoid costly delete operations for each element. When returning the window max via 
maxHeap.peek(), check if it exists in the deleted map. If so, remove it from the heap and decrement the count in the
deleted map (deleting the key once count == 0). Once maxHeap.peek() does not exist in the deleted map, return it.