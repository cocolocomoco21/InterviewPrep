# Binary Tree Maximum Path Sum
## LC 124
https://leetcode.com/problems/binary-tree-maximum-path-sum/

## Problem
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

## Example
Example 1

![Example 1](https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg)
```
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
```

## Approach
DFS to find the max sum to the left and max sum to the right for a given node. Keep a global max. Since the path does not have to go through node, any possible variation can be a path. Therefore, we need to update max if 1) currentNode > max, 2) sum with both children > max, or 3) the sum of the largest child + currentNode > max. Then, pass back the largest viable path through this node, which is either 1) or 3) (since we can't pass back a tree with multiple forks, but we can pass back either the current node or a branch including the current node).

**Psuedocode**:
```
class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int maxFromRoot = findMaxPathSum(root);
        return Math.max(max, maxFromRoot);
    }
    
    private int findMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = findMaxPathSum(node.left);
        int rightSum = findMaxPathSum(node.right);
        
        // Update max if possible. Consider the sum through the node,
        // just the largest child path, or just this node itself
        int nodeSum = leftSum + rightSum + node.val;
        int sumWithMaxChild = Math.max(leftSum, rightSum) + node.val;
        if (nodeSum > max) {
            max = nodeSum;
        }
        
        if (node.val > max) {
            max = node.val;
        }
        
        if (sumWithMaxChild > max) {
            max = sumWithMaxChild;
        }
        
        return Math.max(sumWithMaxChild, node.val);
    }
}
```

## Search Terms
lc-blind75, lc-tree, lc-binarytree, lc-dfs, lc-hard, lc-124