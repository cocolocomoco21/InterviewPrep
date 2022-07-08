# Binary Tree Level Order Traversal
## LC 102
https://leetcode.com/problems/binary-tree-level-order-traversal/

## Problem
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

## Example
Example 1:

![Example 1](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)

```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```

Example 2:

```
Input: root = []
Output: []
```

## Approach
Level-order traversal == BFS. Do a BFS on the tree to get the proper order.

The trickiest part of this problem is getting a properly formed return type. If it were just printing or listing the nodes, that's just BFS. However, since we need to collect based on level, we need to find a way to aggregate all children of a certain level.

For this, I used a second queue to keep track of level. Since we know the first level is one, we can queue that on our levelQueue when we queue the root node on our nodeQueue. As long as we keep these queues in sync, the dequeued level will always correspond with the level of the dequeued node.

**Psuedocode**:

```
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

```

## Search Terms
lc-blind75, lc-tree, lc-binarytree lc-treetraversal, lc-bfs, lc-medium, lc-102