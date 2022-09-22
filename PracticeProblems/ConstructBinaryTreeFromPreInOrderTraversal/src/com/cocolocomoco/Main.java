package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // If only root, return just root/
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);

        int preorderItr = 1;
        int inorderItr = 0;
        while (preorderItr != preorder.length - 1) {
            // We've found a left child. Create and add it
            if (inorder[inorderItr] == preorder[preorderItr]) {
                root.left = new TreeNode(preorder[preorderItr]);
            }

            boo


            preorderItr++;
        }

        return root;
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
