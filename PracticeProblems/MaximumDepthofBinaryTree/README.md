# Maximum Depth of Binary Tree
## LC 104
https://leetcode.com/problems/maximum-depth-of-binary-tree/

## Problem
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Example

![Example tree](https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg)
```
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

## Approach
Use DFS to recurse down to leaf node using node and level. Once reach leaf node, return level. Compare max for a given node and return that.

At root, we will have max from left and right.

**Psuedocode**:
```
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    // Perform DFS
    return findMaxDepth(root, 1);
}

private int findMaxDepth(TreeNode node, int level) {
    if (node == null) {
        return level;
    }

    int leftMaxDepth = node.left == null ? level : findMaxDepth(node.left, level + 1);
    int rightMaxDepth = node.right == null ? level : findMaxDepth(node.right, level + 1);

    return Math.max(leftMaxDepth, rightMaxDepth);
}

```

## Search Terms
lc-blind75, lc-binarytree, lc-tree, lc-dfs, lc-easy, lc-104