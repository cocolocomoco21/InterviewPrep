# Valid Sudoku
## LC 36
- https://leetcode.com/problems/valid-sudoku/
- https://leetcode.com/discuss/interview-question/1245761/DoorDash-Onsite

## Problem
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

- Each row must contain the digits 1-9 without repetition.
- Each column must contain the digits 1-9 without repetition.
- Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.

## Example
![Example 1](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)
```
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
```

Example 2:

```
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

## Approach
It is inevitable that you are going to have to iterate over all n x n elements to detemrine validity. For my approach, to save on redundant iterations, I created three hashmaps to map to values seen: one for row to the values seen in that row, one for column, and one for quadrant (where quadrant is zero indexed, working left to right, top down).

The maps contained the zero-indexed row/col/quadrant and mapped to a HashSet of values seen in that row. That way, it is constant time lookup and insertion for each row, column, and quadrant.

This does leave a decent memory impact, as you must create three hashmaps, each with values that may contain sets of many objects. If memory is the most important thing, maybe we do a more simple iteration that's more time consuming.

## Search Terms
lc-doordashonsite, lc-hashmap, lc-arrays, lc-medium, lc-36