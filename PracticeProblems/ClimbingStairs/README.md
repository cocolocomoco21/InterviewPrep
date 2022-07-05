# Climbing Stairs
### LC 70
https://leetcode.com/problems/climbing-stairs/

### Problem
You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

### Example

```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

### Approach
This is basically Fibonacci.

Dynamic programming/memoization. You can iterate down to get to base cases, then return and sum the climbStairs(n-1) + climbStairs(n-2) to get the total for the current stair. Save this in a hashmap for later use. This is a "top-down"/memoization approach.

Another way is via bottom-up dynamic programming

### Search Terms
lc-blind75, lc-dynamicprogramming, lc-memoization, lc-medium, lc-70 