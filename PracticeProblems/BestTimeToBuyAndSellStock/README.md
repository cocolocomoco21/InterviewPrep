# Best Time to Buy and Sell Stock
### LC 121
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

### Problem
You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return _the maximum profit you can achieve from this transaction_. If you cannot achieve any profit, return `0`.


Example 1:

```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

### Approach
Greedy algorithm approach. Keep track of the min and max price seen, as well as current max profit. Iterate over all elements, updating according to below rules. Return profit at end 
- Do input validation for size, etc. and set min/max to `prices[0]` and profit to `0`.
- If you encounter a new max, update max price and if larger than the current max profit, update max profit.
- If you encounter a new min, update both min and max, since the previous max is no longer valid (must be _after_ the min).
- When you get to the end of the array, return profit.

### Search terms
lc-blind75, lc-greedyalgorithm, lc-arrays, lc-easy, lc-121