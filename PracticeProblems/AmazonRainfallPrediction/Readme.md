###Problem
Given an array of rainfall (ints) and a number k for an offset, find days such that 

arr[k] >= arr[k+1] >= ... >= arr[i] <= arr[i + 1] <= ... <= arr[i+k].

Basically, given a k, for all indexes i, find all i such that for each i, all indexes left are less than or equal and all indexes right are greater than or equal.

Note: day = i+1, so add one to the index to get the proper day.

https://leetcode.com/discuss/interview-question/1482144/Amazon-Online-Assessment-September-2021

###Approach
Iterate over all elements within [k, n-k-1]. For each element i, run two for loops: one for the left side, one for the right.
Look at the current and next values within each loop - if invalid, skip to next index. If valid, add to a list.

**Note**: this solution is O(nk). If k is constant, this is O(n), but if it is large, it could be nearly O(n^2). 
This algorithm could potentially be improved by dynamic programming?

You could keep two boolean arrays, isValidLeft and isValidRight. isValidLeft holds if the given index is valid for the left, and vice versa for isValidRight.
Run a for loop from [k, n-k-1] for isValidLeft. Some checks for index i will require a "full" lookup (i.e. go back the full k elements and check manually).
However, you can shortcut some by checking if the previous is valid, and the current <= previous, then the current is also valid.
For some i, this would reduce the number of iterations from k to 0 due to constant time lookup. However, this logic may be more work than it's worth.
If k is expected to be large and/or the distribution is reasonably flat/uniform, it probably makes sense. However, if k is small (therefore near-constant time lookup)
or the distribution is volatile (therefore not much likelihood of previous being valid, this probably doesn't make sense. I'd discuss this with the interviewer. 