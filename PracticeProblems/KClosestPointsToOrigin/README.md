# K Closest Points to Origin
## LC 973
- https://leetcode.com/problems/k-closest-points-to-origin/
- https://leetcode.com/discuss/interview-question/1293040/Doordash-or-Phone-Screen-or-Software-Engineer-E4-or-Closest-Drivers-to-Restaurant

## Problem
**Leetcode**:

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

---
**DoorDash**:

Same as above, but 1) given complex classes, 2) it's from a specified restaurant location, 3) if there is a tie, revert to the higher rated Dasher, and 4) only return three elemets.

## Example
```
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
```

## Approach
I approached it from a Java 8 stream sorting method. It should be O(nlogn) to sort the stream, O(1) for each element to sort (due to constant time math), then O(n) to return up to n elements. So O(nlogn) total.

A potentially better (and intended?) way of doing this would be loading each location into a priority queue/heap with the distance as the key (and if DoorDash question, rating as the tie breaker). Then pop off k elements (or 3 if DoorDash question) and you're done.

## Search Terms
lc-doordashonsite, lc-heap, lc-priorityqueue, lc-java8streams, lc-arrays, lc-medium, lc-973