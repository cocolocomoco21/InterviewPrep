### Problem
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

https://leetcode.com/problems/coin-change/

### Approach

Dynamic programming. Create a set of coins for constant lookup. Store the known lowest number of coins for a given remainingAmount in a map. Recursively (like DFS)
find the lowest number of coins for a given remainingAmount, which gets constant time lookup for future operations. After exhausting all potential coin combinations
(using map for constant time lookup efficiency), you will find the overall lowest number.

Do a DFS-like traversal
 . Now, if we encounter that remainingAmount again, we have already done the hard work of finding the lowest 
number already.

Run this recursively, doing a DFS-like traversal:
- Given a remainingAmount, check if remainingAmount is in the set of coins. If so, return 1. If not, iterate over all coins, setting remainingAmount = remainingAmount-coin
- If not a valid combination (i.e. remainingAmount < 0), return -1.
- For a given remainingAmount, once all coins and their subsequent paths have been iterated over/"returned", you know the local min number of coins for that remainingAmount. Add
this to the map to store the lowest known number of coins for that remainingAmount. This gives constant time lookup for future iterations that encounter this remainingAmount
- Continue returning minimum, which propagates it backwards. Add one each time to account for the current coin, effectively
- Once we return to the original calling method, we've got the global min fewest coins. 