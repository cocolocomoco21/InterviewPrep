### Problem
Given an array of ints and a target number, return the two indices that sum to the target. You are guaranteed to have
two and only two numbers that sum to the target.

https://leetcode.com/problems/two-sum/

### Approach
Dynamic programming. Hashmap of remaining value -> index. For each num, lookup nums[i]. If exists, return value (index)
and current index. Otherwise, add target - nums[i] to map for current index. Iterate until found.  