# DoorDash Onsite practice problem
## LC Doordash Onsite 
https://leetcode.com/discuss/interview-question/1522955/Doordash-Onsite

## Problem
Given a grid of roads, blocked roads, and DashMarts and a list of locations in this grid, find the distance to the nearest DashMart for each location.

## Example
```
{'X', ' ', ' ', 'D', ' ', ' ', 'X', ' ', 'X'},
{'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
{' ', ' ', ' ', 'D', 'X', 'X', ' ', 'X', ' '},
{' ', ' ', ' ', 'D', ' ', 'X', ' ', ' ', ' '},
{' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X'},
{' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X'}};

locations = [
    [2, 2],
    [4, 0],
    [0, 4],
    [2, 6]
]

answer = [1, 4, 1, 5]
```

## Approach
Ideal: Pretty straightforward BFS from the specified location until you find a DashMart. You could either 1) keep a parallel and syncronized node queue and distance queue or 2) have a level on each node (via complex class) to keep track of level. Return when you encounter a DashMart.

What I tried: I recognized that BFS was the way, but tried a different option: iterate over the whole grid, and when you find a DashMart, update the grid with the nearest DashMart. Doing this for the entire grid leaves the grid having distances for each cell. Then, when looking up locations, you can just return what's stored in the grid.

## Search Terms
lc-doordash, lc-bfs, lc-grid, lc-arrays, lc-medium