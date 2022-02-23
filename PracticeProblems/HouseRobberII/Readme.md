### Problem
You rob houses which contain money in an int[]. Cannot steal from adjacent houses. Houses are arranged in circle so [0]
and [n-1] are also neighbors. Steal the maximum money in one night without alerting police.

https://leetcode.com/problems/house-robber-ii/

### Aproach
Dynamic programming. Iterate over 0->n-2 and 1->n-1 to account for the circular neighbors. Set the base case of start
and start+1. Then, at a given house, know the maximum to that house. Compare (currentHouse + sum[i-2]) vs (sum[i-1]) 
and set sum[i] equal to the max. Continually do this until the end. The end will then contain the max, so return that.
Compare the two calls (0->n-2 vs. 1->n-1) and return the max.