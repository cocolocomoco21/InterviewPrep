**Note**: this file is committed as-is and may not 1) be complete, 2) work or compile, or 3) be a good/reasonable/proper solution


# ?
## LC ?
https://leetcode.com/discuss/interview-question/570407/salesforce-oa-hackerrank

## Problem
Given number of VM instances and the price per unit at that number (sorted smallest to largest), create a quote for a
requested number of instances, n.

If number exists, return existing number. If number is less any existing numbers, extrapolate using the smallest two 
existing numbers. If greater than any existing numbers, extrapolate using largest two numbers. If only one number
exists, extrapolate with just that number. If in between two existing estimates, use linear extrapolation to find value 
(create line between both and plot requested n on line).

## Example
See above

## Approach
Algorithm:

```
If only one, get price per and multiply
Create hashmap for quick lookup based on iterating through two arrays
If n exists in hashmap, return value
Else,
    If value at i=0 is greater than n, extrapolate
    If value at i=size-1 is less than n, extrapolate
    Else, iterate through until you find index where the value at i-1 is less than n and value at i+1 is greater than n
        If values are 0 or neg, go to next one? i.e. if i-1 is 0, to go i-2 (EDGE CASE, worry about at end)
        Find slope and put on line. Return value
```

Rather than creating additional hashmap, you could also include an "is i == n" check in the for loop when iterating through. Depends on expected data size to determine if creating hashmap is an efficiency or inefficiency.

## Search Terms
lc-salesforce 