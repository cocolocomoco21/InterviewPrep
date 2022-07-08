package com.cocolocomoco;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Create queues for nodes and levels. Keep synchronized to get level info for each node
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        List<List<Integer>> levelOrderTraversal = new ArrayList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        // Add first node to queue, and start with level 1
        nodeQueue.offer(root);
        levelQueue.offer(1);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            Integer currentLevel = levelQueue.poll();

            // Populate current level for levelOrderTraversal if not yet populated
            if (levelOrderTraversal.size() < currentLevel) {
                // Subtract one from level since array is zero-indexed
                levelOrderTraversal.add(currentLevel - 1, new ArrayList<Integer>());
            }

            // Add current value to level - subtract one from level since array is zero-indexed
            levelOrderTraversal.get(currentLevel - 1).add(currentNode.val);

            // Add left and right children to queue and increment level
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                levelQueue.offer(currentLevel + 1);
            }

            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                levelQueue.offer(currentLevel + 1);
            }
        }

        return levelOrderTraversal;
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