# Pacific Atlantic Water Flow
## LC 417
https://leetcode.com/problems/pacific-atlantic-water-flow/

## Problem
There is an `m x n` rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an `m x n` integer matrix `heights` where `heights[r][c]` represents the height above sea level of the cell at coordinate `(r, c)`.

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where `result[i] = [ri, ci]` denotes that rain water can flow from cell `(ri, ci)` to both the Pacific and Atlantic oceans.

## Example
Example 1

![Example 1 diagram](https://assets.leetcode.com/uploads/2021/06/08/waterflow-grid.jpg)

```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

Example 2:

```
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
```
## Approach
Intersecting BFS/bidirectional search. Since our goal is to reach the water, we can alternatively iterate _up_ from the water, rather than down, to find how far "up" we can go. Treat this as a graph - do BFS from the pacific "up" and BFS from the atlantic "up" to find which nodes intersect both traversals.

I created a list of nodes and populated their neighbors and heights. Then, run BFS on the pacific ocean. Load all "coast" nodes into the queue and let it traverse as far as it can. This gives a list of visited nodes (or have a field on each node themselves). Similarly, run BFS for the atlantic, starting from the cost, up until it stops a traverse as well.

In order to run "up", we simply flip the rules for traversal - each neighbor must be _greater than_ or equal to, rather than less than or equal to. This allows us to traverse _up_ from the water, rather than having to find how to iterate down toward the water from the middle of the graph.

## Search Terms
lc-blind75, lc-graphs, lc-graphtraversal, lc-bfs, lc-bidirectionalsearch, lc-medium, lc-417 