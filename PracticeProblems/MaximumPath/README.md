**Note**: this file is committed as-is and may not 1) be complete, 2) work or compile, or 3) be a good/reasonable/proper solution

# Binary Tree Maximum Path Sum
## LC 124
https://leetcode.com/problems/binary-tree-maximum-path-sum/

## Problem
Given a binary tree with values on each node, find the maximum path that connects two leaves

## Example
See above

## Approach
Since the problem is not "through the root", you need to be able to handle if a subtree is the maximum path, not just
through the root. As such, do a DFS to get the value at each child, i.e. call findMaximumPath for the left and right
child.

Once you have both leftSum and rightSum, sum them with the value at the current node and compare against a global variable for the maxSum. If greater AND if neither node is null (for valid "is it between two leaves" checking), update global. Return back the largest to a leaf to that point otherwise, for the previous level/caller to be able to determine if a contiguous line is longer at a later point.

Create a Node class that contains left child, right child, and value.

## Search Terms
lc-blind75, lc-tree, lc-binarytree, lc-hard, lc-124 
