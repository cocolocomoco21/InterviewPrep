# Maximum Subarray
### LC 53
https://leetcode.com/problems/maximum-subarray

### Problem
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

### Example
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

### Approach
I approached this from a greedy and dynamic programming perspective. Since we're doing the work of summing, can we store this sum to reduce redundant opertions?

Basically, if we can say "the current maximum sum to this point (at index `i`) is `x`, then our next index `i + 1` can ask the same thing, however using the previous max as a reference. For instance, `i + 1` can say "is the max at `i + 1` the contents at `i + 1` or is it the contents at `i + 1` plus `x` (the contents at `i`), which is the max through `i`?

To save space, we can do this in place, overwriting `nums[i]` with the max to that point. 

We greedily pick the highest max (i.e `nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);`) and if it's bigger than `max`, update. Return max when we've iterated through the entire array, as it will have the largest max.

### Search Terms
lc-blind75, lc-greedyalgorithm, lc-dynamicprogramming, lc-arrays, lc-medium, lc-53