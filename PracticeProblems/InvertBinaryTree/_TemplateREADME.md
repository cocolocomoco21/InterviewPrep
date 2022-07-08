# Invert Binary Tree
## LC 226
https://leetcode.com/problems/invert-binary-tree/

## Problem
Given the root of a binary tree, invert the tree, and return its root.

## Example
Example 1:

![Example 1](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)

```
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
```

## Approach
This boils down into just flipping the left and right child for every node in the tree. Do a simple BFS to get every node (DFS would work too), and just swap the elements. Hardest part was remembering to include null checking :).

## Search Terms
lc-blind75, lc-tree, lc-binarytree, lc-treetraversal, lc-bfs, lc-easy, lc-226 