### Problem
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown: <image on leetcode>
https://leetcode.com/problems/pascals-triangle/

### Approach
Basic validation, then check for early exit if numRows == 1 only one row. 

If not, populate the leading 1 for each row. Then, from i = 1 -> i = currentRow - 1, populate the internal contents by
looking back at the previous row's i-1 and i contents, adding them, then moving to next i. Finish with trailing 1 for 
each row. Populate all rows until currentRow = numRows.  
