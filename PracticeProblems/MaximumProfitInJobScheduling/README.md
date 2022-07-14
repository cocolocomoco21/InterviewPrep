# Maximum Profit in Job Scheduling
## LC 1235
https://leetcode.com/problems/maximum-profit-in-job-scheduling/

## Problem
We have `n` jobs, where every job is scheduled to be done from `startTime[i]` to `endTime[i]`, obtaining a profit of `profit[i]`.

You're given the `startTime`, `endTime` and `profit` arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time `X` you will be able to start another job that starts at time `X`.

NOTE: this is in a DoorDash onsite. "Round 3" here: https://leetcode.com/discuss/interview-question/1379696/DoorDASH-Onsite

## Example
![Example 1](https://assets.leetcode.com/uploads/2019/10/10/sample1_1584.png)

```
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
```

## Approach
We can do a dynamic programming/memoization approach, similar to House Robber II (though that does bottom-up) or Coin Change. Sort the jobs relative to startTime (I made a complex Jobs class for ease). We do a DFS on each job, considering the max if the next valid job is included or if the next job is the one taken, regardless of if it is valid or not. e.g.

```
int profitInclusive = jobs[currentIndex].profit + (nextValidIndex == -1 ? 0 : lookup(nextValidIndex, jobs));
int profitExclusive = lookup(currentIndex + 1, jobs);
```

We save the max of these two in a hashmap at the current index for lookup later if we encounter the same index (memoization). Then, return whatever DFS returns.

## Search Terms
lc-doordash, lc-doordashonsite, lc-dynamicprogramming, lc-memoization, lc-dfs, lc-hard, lc-1235 