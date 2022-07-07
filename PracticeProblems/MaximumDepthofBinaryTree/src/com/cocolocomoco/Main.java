package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
        
    }
}

class Solution {
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
