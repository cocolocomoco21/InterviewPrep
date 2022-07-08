package com.cocolocomoco;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();


        pQueue.offer(p);
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode currentP = pQueue.poll();
            TreeNode currentQ = qQueue.poll();

            // P and Q are equal and null - don't operate on null
            if (currentP == null && currentQ == null) {
                continue;
            }

            // Only one is null - not equal
            if (currentP == null || currentQ == null) {
                return false;
            }

            // Value not same - not equal
            if (currentP.val != currentQ.val) {
                return false;
            }

            // Offer children, in order of left to right, to continue equality comparison
            pQueue.offer(currentP.left);
            pQueue.offer(currentP.right);

            qQueue.offer(currentQ.left);
            qQueue.offer(currentQ.right);

        }

        // If we've exited and both queues aren't empty, it means the size of trees is different
        return pQueue.isEmpty() == qQueue.isEmpty();
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