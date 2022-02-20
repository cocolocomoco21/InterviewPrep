### Problem
(Similar to CTCI 8.2)

A robot is located at the top-left corner of an m x n grid and can only move down or right at any point in time.
Some cells of the grid are obstacles (marked with 1) and all others are available moves (marked with 0).
How many unique paths are there?

https://leetcode.com/problems/unique-paths-ii/

### Approach
Dynamic programming. Similar to CTCI 8.2, get the available children/potential moves from a given cell (meaning non-borders
or obstacles). Continue to call each child. If we reach the end (bottom right), return 1. Else, return 0.

If all potential moves for a given cell return 0, mark this cell as an obstacle (to save processing later). Once all
potential moves for a cell are known (i.e. the bottom and right children's number of unique paths are known), hash this
for the given cell in a hashmap to enable constant time lookup of that cell's known number of unique paths.