package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}