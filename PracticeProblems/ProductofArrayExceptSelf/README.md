# Product of Array Except Self
### LC 238
https://leetcode.com/problems/product-of-array-except-self/

### Problem
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

### Approach
In order to accomplish this in `O(n)`, you can't just say "for every `i`, multiply every other one and populate the array." This would be `O(n)` to iterate over all `n` elements and then `O(n)` multiplications per each `n` element, giving `O(n^2)` total, which is bad and does not meet the question.

As such, we need to figure out a way to offload some of this multiplication we're doing so we can reuse this work later.

**Solution**:

My solution is to use two arrays to keep the cululative product to that point when working from the left and the right, but excluding the current value. Then, we iterate over `n` elements and multiply from the two arrays to store the value for `answer[i]` into `answer`.

The idea comes from: how can we offload the work? We'll, we're iterating over `n` elements, can we keep a running product for every element we see? If we try to store the cumulative product excluding the current index `i`, we only get one side. E.g. `[1, 2, 3, 4]`: if we keep this product going for index 2, we get `1 * 2 = 2`, but that diregards the right side that we also need to care about.

So if we can also accumulate the product from the right side, we can get both halves of the problem. Since we're doing two iterations over `n` elements, that's just `O(2n)` which equals `O(n)`. Continuing with example `[1, 2, 3, 4]`, if we get the product going for index 2 from the right, we get `4`. We can now multiply these two values, which both exclude the value at index 2 (`3`) and get the product that excludes `3`, being `1 * 2 = 2 (left), 4 (right) => 2 * 4  = 8`.

This solution does 3 iterations of `n`, so `O(3n) = O(n)`.

### Search Terms
lc-blind75, lc-dynamicprogramming, lc-arrays, lc-medium, lc-238 