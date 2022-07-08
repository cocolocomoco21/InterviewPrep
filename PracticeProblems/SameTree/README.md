# Same Tree
## LC 100
https://leetcode.com/problems/same-tree/

## Problem
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Example
Example 1:

![Example 1](https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg)
```
Input: p = [1,2,3], q = [1,2,3]
Output: true
```

Example 2:

![Example 2](https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg)
```
Input: p = [1,2,1], q = [1,1,2]
Output: false
```

## Approach
Do an in-sequence BFS for each tree, comparing the current node across both BFSes. 

For instance, create two unique BFS iterations: create a `pQueue` and `qQueue`, enqueue the roots, etc. Start at the root of tree `p` and the root of tree `q`; compare them. If they're equal, enqueue their left child to the respective queue, then their right child, in the same order. Dequeue each queue (aka the left child of `p` and `q`); compare them. Complete until one or both queues are empty. Finally, compare the queue sizes to determine if one completed before the other - if so, one tree has more elements than the other

**Psuedocode**:
```
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
```

## Search Terms
lc-blind75, lc-tree, lc-binarytree, lc-treetraversal, lc-dfs, lc-easy, lc-100 