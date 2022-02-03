https://leetcode.com/problems/two-sum/
Given an array of ints and a target number, return the two indices that sum to the target. You are guaranteed to have
two and only two numbers that sum to the target.

Approach: hashmap of value -> index. For each num, lookup target - num and return value (index) and i when found